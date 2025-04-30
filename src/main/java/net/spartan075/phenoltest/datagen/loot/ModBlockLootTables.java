package net.spartan075.phenoltest.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.spartan075.phenoltest.block.BlockRegistration;
import net.spartan075.phenoltest.item.ItemRegistration;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(BlockRegistration.PHENA_BLOCK.get());
        this.dropSelf(BlockRegistration.OXIDIZER.get());
        this.dropSelf(BlockRegistration.SUGOI_REFINERY_BLOCK.get());
        this.dropSelf(BlockRegistration.SOUND_BLOCK.get());
        this.dropSelf(BlockRegistration.OXIDIZER.get());

        this.add(BlockRegistration.PHENA_ORE.get(),
                block -> createPhenaOreDrops(BlockRegistration.PHENA_ORE.get(), ItemRegistration.RAW_PHENA.get()));
    }

    protected LootTable.Builder createPhenaOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                    LootItem.lootTableItem(item).
                        apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected  Iterable<Block> getKnownBlocks() {
        return BlockRegistration.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
