package net.spartan075.phenoltest;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.spartan075.phenoltest.Fluids.ModFluidTypes;
import net.spartan075.phenoltest.Fluids.ModFluids;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.common.SoundAction;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.spartan075.phenoltest.blocks.SugoiRefinery.SugoiRefineryBlock;
import net.spartan075.phenoltest.blocks.SugoiRefinery.SugoiRefineryEntity;

import static net.spartan075.phenoltest.PhenolTest.MODID;

public class Registration {

    // Setting up the registers
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MODID);
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, MODID);

    // Register an example block, and its item
    public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)));
    public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = ITEMS.register("example_block", () -> new BlockItem(EXAMPLE_BLOCK.get(), new Item.Properties()));

    // Register the Sugoi Refinery block, item, and entity
    public static final RegistryObject<Block> SugoiRefineryBlock = BLOCKS.register("sugoi_refinery", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)));
    public static final RegistryObject<Item> SugoiRefineryItem = ITEMS.register("sugoi_refinery", () -> new BlockItem(SugoiRefineryBlock.get(), new Item.Properties()));
    public static final RegistryObject<BlockEntityType<SugoiRefineryEntity>> SugoiRefineryBlockEntity = BLOCK_ENTITIES.register("sugoi_refinery_block_entity",
            () -> BlockEntityType.Builder.of(SugoiRefineryBlock::new, validBlocks).build(null));

    // Register fluids
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, PhenolTest.MODID);
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS,PhenolTest.MODID);

    // Register the Oil fluid and its block
    public static final RegistryObject<FluidType> OIL_FLUID_TYPE = ModFluidTypes.fluidRegister("oil_fluid",
            FluidType.Properties.create().lightLevel(2).density(15).viscosity(5).sound(SoundAction.get("drink"),
                    SoundEvents.HONEY_DRINK));

    public static final RegistryObject<LiquidBlock> OIL_BLOCK = BLOCKS.register("oil_block",
            () -> new LiquidBlock(ModFluids.SOURCE_OIL, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<Item> OIL_BUCKET = ITEMS.register("oil_bucket",
            () -> new BucketItem(ModFluids.SOURCE_OIL, new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));

    //Registering an example item
    public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEat().nutrition(1).saturationMod(2f).build())));

    public static void init(IEventBus modEventBus) {

        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        BLOCK_ENTITIES.register(modEventBus);
        FLUIDS.register(modEventBus);
        FLUID_TYPES.register(modEventBus);

    }

    // Add the example block item to the building blocks tab
    static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
            event.accept(Registration.EXAMPLE_ITEM);
            event.accept(Registration.EXAMPLE_BLOCK_ITEM);
            event.accept(Registration.EXAMPLE_BLOCK);
            event.accept(Registration.SugoiRefineryBlock);
            event.accept(Registration.OIL_BLOCK);
            event.accept(Registration.OIL_BUCKET);
    }

}
