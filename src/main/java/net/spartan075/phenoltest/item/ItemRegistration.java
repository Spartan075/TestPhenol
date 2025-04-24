package net.spartan075.phenoltest.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.spartan075.phenoltest.PhenolTest;
import net.spartan075.phenoltest.item.custom.PhenaDetectorItem;


import java.util.Locale;
import java.util.Properties;

import static net.spartan075.phenoltest.block.BlockRegistration.SUGOI_REFINERY_BLOCK;

public class ItemRegistration {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PhenolTest.MODID);

    public static final RegistryObject<Item> MIKAN = ITEMS.register("mikan",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(2).build())));

    public static final RegistryObject<Item> PHENA = ITEMS.register("phena",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PHENA_DETECTOR = ITEMS.register("phena_detector",
            () -> new PhenaDetectorItem(new Item.Properties().durability(100)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
