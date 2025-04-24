package net.spartan075.phenoltest;

import net.spartan075.phenoltest.Fluids.ModFluids;
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
import net.spartan075.phenoltest.items.PhenolCreativeModeTabs;
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

        Registration.init(modEventBus);
        PhenolCreativeModeTabs.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(Registration::addCreative);
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

            // Set the oil fluid to be translucent
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_OIL.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_OIL.get(), RenderType.translucent());

        }
    }
}
