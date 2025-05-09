package net.spartan075.phenoltest;

import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.spartan075.phenoltest.block.ModBlocks;
import net.spartan075.phenoltest.block.entity.ModBlockEntities;
import net.spartan075.phenoltest.fluid.ModFluidTypes;
import net.spartan075.phenoltest.fluid.ModFluids;
import net.spartan075.phenoltest.item.ModItems;
import net.spartan075.phenoltest.item.PhenolCreativeModeTabs;
import net.spartan075.phenoltest.screen.ModMenuTypes;
import net.spartan075.phenoltest.screen.OxidizerScreen;
import net.spartan075.phenoltest.screen.PhenolConverterScreen;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(PhenolTest.MODID)
public class PhenolTest {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "phenoltest";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();



    public PhenolTest(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        ModFluidTypes.register(modEventBus);
        ModFluids.register(modEventBus);

        PhenolCreativeModeTabs.register(modEventBus);

        ModMenuTypes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);


    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }



    // Server start events
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }



    // Client start events
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {



        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            event.enqueueWork(() -> {

                MenuScreens.register(ModMenuTypes.OXIDIZER_MENU.get(), OxidizerScreen::new);
                MenuScreens.register(ModMenuTypes.PHENOL_CONVERTER_MENU.get(), PhenolConverterScreen::new);

                ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_OIL.get(), RenderType.solid());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_OIL.get(), RenderType.solid());
            });
        }
    }
}