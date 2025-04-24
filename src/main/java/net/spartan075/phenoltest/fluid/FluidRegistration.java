package net.spartan075.phenoltest.fluid;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.SoundAction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.spartan075.phenoltest.PhenolTest;

import static net.spartan075.phenoltest.PhenolTest.MODID;

public class FluidRegistration {

    // Register fluids
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, PhenolTest.MODID);
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS,PhenolTest.MODID);

    // Register the Oil fluid and its block
    public static final RegistryObject<FluidType> OIL_FLUID_TYPE = ModFluidTypes.fluidRegister("oil_fluid",
            FluidType.Properties.create().lightLevel(2).density(15).viscosity(5).sound(SoundAction.get("drink"),
                    SoundEvents.HONEY_DRINK));

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
