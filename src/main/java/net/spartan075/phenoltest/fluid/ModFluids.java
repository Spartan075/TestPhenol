package net.spartan075.phenoltest.fluid;

import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.spartan075.phenoltest.PhenolTest;
import net.spartan075.phenoltest.block.ModBlocks;
import net.spartan075.phenoltest.item.ModItems;

public class ModFluids {
    public static DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, PhenolTest.MODID);



    public static final RegistryObject<FlowingFluid> SOURCE_OIL = FLUIDS.register("oil_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.OIL_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid>  FLOWING_OIL = FLUIDS.register("flowing_oil_fluid",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.OIL_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties OIL_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.OIL_FLUID_TYPE,SOURCE_OIL , FLOWING_OIL)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.OIL_BLOCK)
            .bucket(ModItems.OIL_BUCKET);



    public static void register(IEventBus modEventBus) { FLUIDS.register(modEventBus); }
}
