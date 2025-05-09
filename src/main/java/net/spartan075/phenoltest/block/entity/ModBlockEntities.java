package net.spartan075.phenoltest.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.spartan075.phenoltest.PhenolTest;
import net.spartan075.phenoltest.block.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, PhenolTest.MODID);

        public static final RegistryObject<BlockEntityType<OxidizerBlockEntity>> OXIDIZER_BE =
                BLOCK_ENTITIES.register("oxidizer_be",
                        () -> BlockEntityType.Builder.of(OxidizerBlockEntity::new,
                        ModBlocks.OXIDIZER.get()).build(null));

        public static final RegistryObject<BlockEntityType<RefineryBlockEntity>> REFINERY_BE =
                BLOCK_ENTITIES.register("refinery_be",
                        () -> BlockEntityType.Builder.of(RefineryBlockEntity::new,
                        ModBlocks.REFINERY_BLOCK.get()).build(null));

        public static final RegistryObject<BlockEntityType<PhenolConverterBlockEntity>> PHENOL_CONVERTER_BE =
                BLOCK_ENTITIES.register("phenol_converter_be",
                        () -> BlockEntityType.Builder.of(PhenolConverterBlockEntity::new,
                        ModBlocks.PHENOL_CONVERTER.get()).build(null));



    public static void register (IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

}
