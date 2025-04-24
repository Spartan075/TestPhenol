package net.spartan075.phenoltest.Fluids;

import net.spartan075.phenoltest.Registration;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.RegistryObject;
import org.joml.Vector3f;

public class ModFluidTypes {
    public static final ResourceLocation WATER_STILL_RL = ResourceLocation.parse("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = ResourceLocation.parse("block/water_flow");
    public static final ResourceLocation OIL_OVERLAY_RL = ResourceLocation.parse("block/water_still");



    public static RegistryObject<FluidType> fluidRegister(String name, FluidType.Properties properties) {
        return Registration.FLUID_TYPES.register(name, () -> new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, OIL_OVERLAY_RL, 0xA1202020,
                new Vector3f(20f / 255f, 20f / 255f, 20f / 255f), properties));
    }
}
