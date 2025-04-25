package net.spartan075.phenoltest.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.spartan075.phenoltest.PhenolTest;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> PHENA_DETECTOR_VALUABLES = tag("phena_detector_valuables");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(PhenolTest.MODID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(PhenolTest.MODID, name));
        }
    }
}
