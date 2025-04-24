package net.spartan075.phenoltest.blocks.SugoiRefinery;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.capability.templates.FluidTank;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.spartan075.phenoltest.Registration;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.jetbrains.annotations.NotNull;

public class SugoiRefineryEntity extends BlockEntity {

    // Initialize item slot variables
    public static final String ITEMS_TAG = "Inventory";
    public static int ITEM_SLOT_COUNT = 1;
    public static int ITEM_SLOT = 0;

    //initialize fluid slot variables
    public static final String FLUIDS_TAG = "Fluid";
    public static int FLUID_SLOT_COUNT = 5;
    public static int FLUID_SLOT = 0;

    // Add handler for the items
    private final ItemStackHandler items = createItemHandler();
    private final LazyOptional<IItemHandler> itemHandler = LazyOptional.of(() -> items);

    // Add handler for the fluids
    private final IFluidHandler fluids = new IFluidHandler() {
        @Override
        public int getTanks() {
            return 0;
        }

        @Override
        public @NotNull FluidStack getFluidInTank(int tank) {
            return null;
        }

        @Override
        public int getTankCapacity(int tank) {
            return 0;
        }

        @Override
        public boolean isFluidValid(int tank, @NotNull FluidStack stack) {
            return false;
        }

        @Override
        public int fill(FluidStack resource, FluidAction action) {
            return 0;
        }

        @Override
        public @NotNull FluidStack drain(FluidStack resource, FluidAction action) {
            return null;
        }

        @Override
        public @NotNull FluidStack drain(int maxDrain, FluidAction action) {
            return null;
        }
    };

    private final FluidTank OIL_TANK = new FluidTank(64000) {

        @Override
        protected  void  onContentsChanged() {
            setChanged();
        }

        @Override
        public boolean isFluidValid(FluidStack stack) {
            return stack.getFluid() == Fluids.WATER;
        }
    };

    public SugoiRefineryEntity(BlockPos pos, BlockState state) {
        super(Registration.SUGOI_REFINERY_BE.get(), pos, state);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        itemHandler.invalidate();
    }

    @NonNull
    private ItemStackHandler createItemHandler() {
        return new ItemStackHandler(ITEM_SLOT_COUNT) {
            @Override
            protected void onContentsChanged(int slot) {
                //TODO Add network related handler
            }
        };
    }

}
