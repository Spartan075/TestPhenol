package net.spartan075.phenoltest.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.spartan075.phenoltest.PhenolTest;
import net.spartan075.phenoltest.fluid.ModFluids;
import net.spartan075.phenoltest.item.custom.PhenaDetectorItem;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PhenolTest.MODID);

    // Simple Items go here (do nothing by themselves)
    public static final RegistryObject<Item> RAW_PHENA = ITEMS.register("raw_phena",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SULFUR = ITEMS.register("sulfur",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SULFURIC_ACID = ITEMS.register("sulfuric_acid",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PHENA_INGOT = ITEMS.register("phena_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SOLID_PHENOL = ITEMS.register("solid_phenol",
            () -> new Item(new Item.Properties()));

    // Complex Items go here (do something)
    public static final RegistryObject<Item> MIKAN = ITEMS.register("mikan",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(2).build())));

    public static final RegistryObject<Item> PHENA_DETECTOR = ITEMS.register("phena_detector",
            () -> new PhenaDetectorItem(new Item.Properties().durability(100)));

    // Fluid-related Items go here
    public static final RegistryObject<Item> OIL_BUCKET = ITEMS.register("oil_bucket",
            () -> new BucketItem(ModFluids.SOURCE_OIL, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
