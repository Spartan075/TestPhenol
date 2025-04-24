package net.spartan075.phenoltest.blocks.SugoiRefinery;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class SugoiRefineryBlock extends Block implements EntityBlock {

    //Constructor giving it basic properties
    public SugoiRefineryBlock() {
        super(BlockBehaviour.Properties.of()
                .strength(1F)
                .requiresCorrectToolForDrops()
                .sound(SoundType.METAL));

    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) { return new SugoiRefineryEntity(pos, state); }

}
