package net.spartan075.phenoltest;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.spartan075.phenoltest.block.entity.EntityRegistration;
import net.spartan075.phenoltest.fluid.FluidRegistration;
import net.spartan075.phenoltest.fluid.ModFluids;
import com.mojang.logging.LogUtils;
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
import net.spartan075.phenoltest.block.BlockRegistration;
import net.spartan075.phenoltest.item.ItemRegistration;
import net.spartan075.phenoltest.item.PhenolCreativeModeTabs;
import net.spartan075.phenoltest.screen.ModMenuTypes;
import net.spartan075.phenoltest.screen.OxidizerScreen;
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

        ItemRegistration.register(modEventBus);
        BlockRegistration.register(modEventBus);
        FluidRegistration.register(modEventBus);
        EntityRegistration.register(modEventBus);
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

            MenuScreens.register(ModMenuTypes.OXIDIZER_MENU.get(), OxidizerScreen::new);
        }
    }
}
