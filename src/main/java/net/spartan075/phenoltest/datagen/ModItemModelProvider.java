package net.spartan075.phenoltest.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.spartan075.phenoltest.PhenolTest;
import net.spartan075.phenoltest.block.ModBlocks;
import net.spartan075.phenoltest.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, PhenolTest.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {


        simpleItem(ModItems.MIKAN);
        simpleItem(ModItems.PHENA_INGOT);
        simpleItem(ModItems.RAW_PHENA);
        simpleItem(ModItems.PHENA_DETECTOR);
        simpleItem(ModItems.SULFUR);
        simpleItem(ModItems.SULFURIC_ACID);
        simpleItem(ModItems.OIL_BUCKET);
        simpleItem(ModItems.SOLID_PHENOL);
        complexBlock(ModBlocks.PHENOL_CONVERTER.get());
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(PhenolTest.MODID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder complexBlock(Block block) {
        return withExistingParent(ForgeRegistries.BLOCKS.getKey(block).getPath(), new ResourceLocation(PhenolTest.MODID,
                "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath()));
    }
}
