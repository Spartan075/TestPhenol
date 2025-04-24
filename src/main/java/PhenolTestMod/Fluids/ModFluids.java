package PhenolTestMod.Fluids;

import PhenolTestMod.Registration;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {

    public static final RegistryObject<FlowingFluid> SOURCE_OIL = Registration.FLUIDS.register("oil_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.OIL_FLUID_PROPERTIES));

    public static final RegistryObject<FlowingFluid>  FLOWING_OIL = Registration.FLUIDS.register("flowing_oil",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.OIL_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties OIL_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            Registration.OIL_FLUID_TYPE, SOURCE_OIL, FLOWING_OIL)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(Registration.OIL_BLOCK).bucket(Registration.OIL_BUCKET);

}
