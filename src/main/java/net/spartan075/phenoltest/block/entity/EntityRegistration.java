package net.spartan075.phenoltest.block.entity;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.spartan075.phenoltest.PhenolTest;
import net.spartan075.phenoltest.block.BlockRegistration;

public class EntityRegistration {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, PhenolTest.MODID);

        public static final RegistryObject<BlockEntityType<OxidizerBlockEntity>> OXIDIZER_BE =
                BLOCK_ENTITIES.register("oxidizer_be",
                        () -> BlockEntityType.Builder.of(OxidizerBlockEntity::new,
                        BlockRegistration.OXIDIZER.get()).build(null));

    public static void register (IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

}
