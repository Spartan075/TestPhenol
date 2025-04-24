package net.spartan075.phenoltest.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.spartan075.phenoltest.PhenolTest;
import net.spartan075.phenoltest.block.BlockRegistration;

public class PhenolCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PhenolTest.MODID);

    public static final RegistryObject<CreativeModeTab>  PHENOL_TAB = CREATIVE_MODE_TABS.register("phenol_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ItemRegistration.PHENA.get()))
                    .title(Component.translatable("creativetab.phenol_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ItemRegistration.MIKAN.get());
                        pOutput.accept(ItemRegistration.PHENA_DETECTOR.get());
                        pOutput.accept(BlockRegistration.OXIDIZER.get());

                        pOutput.accept(BlockRegistration.RAW_PHENA_BLOCK.get());

                        pOutput.accept(ItemRegistration.PHENA.get());
                        pOutput.accept(BlockRegistration.PHENA_BLOCK.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
