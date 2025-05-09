package net.spartan075.phenoltest.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.IGeneratedBlockState;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.spartan075.phenoltest.PhenolTest;
import net.spartan075.phenoltest.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {


    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, PhenolTest.MODID, exFileHelper);
    }



    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.PHENA_BLOCK);
        blockWithItem(ModBlocks.PHENA_ORE);


        simpleBlockWithItem(ModBlocks.OXIDIZER.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/oxidizer")));

        simpleBlockWithItem(ModBlocks.REFINERY_BLOCK.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/refinery")));

        horizontalBlock(ModBlocks.PHENOL_CONVERTER.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/phenol_converter")));

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
