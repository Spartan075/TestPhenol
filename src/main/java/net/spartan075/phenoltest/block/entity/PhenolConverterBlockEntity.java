package net.spartan075.phenoltest.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.GlazedTerracottaBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.spartan075.phenoltest.item.ModItems;
import net.spartan075.phenoltest.screen.PhenolConverterMenu;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.windows.INPUT;

public class PhenolConverterBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(2) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return switch (slot) {
                case 0 -> stack.getItem().isEdible();
                case 1 -> stack.getItem() == ModItems.SOLID_PHENOL.get();
                default -> super.isItemValid(slot, stack);
            };
        }

    };

    public static final int INPUT_SLOT = 0;
    public static final int OUTPUT_SLOT = 1;

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 78;

    public PhenolConverterBlockEntity( BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.PHENOL_CONVERTER_BE.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> PhenolConverterBlockEntity.this.progress;
                    case 1 -> PhenolConverterBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> PhenolConverterBlockEntity.this.progress = pValue;
                    case 1 -> PhenolConverterBlockEntity.this.maxProgress = pValue;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.phenoltest.phenol_converter");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new PhenolConverterMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }
        return super.getCapability(cap,side);
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemHandler.serializeNBT());

        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
    }

    // Tick is important, keep at bottom for readability
    public void tick(Level level, BlockPos pPos, BlockState pState) {
        if((level.getGameTime() % 2 == 0) && !this.itemHandler.getStackInSlot(0).isEmpty()) {
            progress += 1;
            //progress = 0;
            if(progress == maxProgress) {
                ItemStack stack = itemHandler.getStackInSlot(INPUT_SLOT);
                if(!stack.isEmpty()) {
                    FoodProperties food = stack.getItem().getFoodProperties(stack, null);
                    if(food != null) {
                        int nutrition = food.getNutrition();
                        float saturation = food.getSaturationModifier();
                        int adjustedNutrition = ((int)saturation + nutrition) / 2;
                        this.itemHandler.extractItem(INPUT_SLOT, 1, false);
                        this.itemHandler.insertItem(OUTPUT_SLOT, new ItemStack(ModItems.SOLID_PHENOL.get(), adjustedNutrition), false);
                        progress = 0;
                    }
                }
            }
        }
    }
}