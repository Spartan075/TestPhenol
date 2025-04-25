package net.spartan075.phenoltest.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.spartan075.phenoltest.PhenolTest;
import net.spartan075.phenoltest.block.BlockRegistration;
import net.spartan075.phenoltest.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, PhenolTest.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.PHENA_DETECTOR_VALUABLES)
                .add(BlockRegistration.PHENA_ORE.get()).addTag(Tags.Blocks.ORES)
                .add(BlockRegistration.PHENA_BLOCK.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BlockRegistration.PHENA_BLOCK.get(),
                        BlockRegistration.PHENA_ORE.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(BlockRegistration.PHENA_ORE.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(BlockRegistration.PHENA_BLOCK.get());
    }
}
