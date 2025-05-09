package net.spartan075.phenoltest.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.spartan075.phenoltest.PhenolTest;
import net.spartan075.phenoltest.block.ModBlocks;

public class PhenolCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PhenolTest.MODID);

    public static final RegistryObject<CreativeModeTab>  PHENOL_TAB = CREATIVE_MODE_TABS.register("phenol_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PHENA_INGOT.get()))
                    .title(Component.translatable("creativetab.phenol_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        // Basic Items here
                        pOutput.accept(ModItems.MIKAN.get());
                        pOutput.accept(ModItems.RAW_PHENA.get());
                        pOutput.accept(ModItems.SULFUR.get());
                        pOutput.accept(ModItems.SULFURIC_ACID.get());
                        pOutput.accept(ModItems.PHENA_INGOT.get());
                        pOutput.accept(ModItems.OIL_BUCKET.get());
                        pOutput.accept(ModItems.SOLID_PHENOL.get());

                        // Basic Blocks here
                        pOutput.accept(ModBlocks.PHENA_BLOCK.get());
                        pOutput.accept(ModBlocks.PHENA_ORE.get());

                        // Advanced Items here
                        pOutput.accept(ModItems.PHENA_DETECTOR.get());

                        // Advanced Blocks(have Block Entity) here
                        pOutput.accept(ModBlocks.OXIDIZER.get());
                        pOutput.accept(ModBlocks.SOUND_BLOCK.get());
                        pOutput.accept(ModBlocks.REFINERY_BLOCK.get());
                        pOutput.accept(ModBlocks.PHENOL_CONVERTER.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
