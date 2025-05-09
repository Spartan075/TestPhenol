package net.spartan075.phenoltest.fluid;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.spartan075.phenoltest.PhenolTest;
import org.joml.Vector3f;

public class ModFluidTypes {
    public static final ResourceLocation OIL_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation OIL_FLOWING_RL = new ResourceLocation("block/water_flowing");
    public static final ResourceLocation OIL_OVERLAY_RL = new ResourceLocation("block/water_overlay");


    // Register fluids
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, PhenolTest.MODID);

    public static final RegistryObject<FluidType> OIL_FLUID_TYPE = registerFluidType("oil_fluid",
            new BaseFluidType(OIL_STILL_RL, OIL_FLOWING_RL, OIL_OVERLAY_RL, 0xFF202020,
                    new Vector3f(0.8f,0.8f,0.8f),
                    FluidType.Properties.create().lightLevel(2).viscosity(10).density(15)));



    private static RegistryObject<FluidType> registerFluidType(String name, FluidType fluidType) {
        return FLUID_TYPES.register(name, () -> fluidType);
    }



    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }

}
