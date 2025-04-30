package net.spartan075.phenoltest.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.spartan075.phenoltest.PhenolTest;
import net.spartan075.phenoltest.block.custom.OxidizerBlock;
import net.spartan075.phenoltest.block.custom.SoundBlock;
import net.spartan075.phenoltest.item.ItemRegistration;

import java.util.function.Supplier;

public class BlockRegistration {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, PhenolTest.MODID);

    public static final RegistryObject<Block> SUGOI_REFINERY_BLOCK = registerBlock("sugoi_refinery",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));


    public static final RegistryObject<Block> PHENA_ORE = registerBlock("phena_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));

    public static final RegistryObject<Block> PHENA_BLOCK = registerBlock("phena_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> OXIDIZER = registerBlock(("oxidizer"),
            () -> new OxidizerBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(1f)));

    public static final RegistryObject<Block> SOUND_BLOCK = registerBlock("sound_block",
            () -> new SoundBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    // Set up to make block registry easier. Also calls registerBlockItem to automatically create one.
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    // Set up to register a Block Item more easily for a given block
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ItemRegistration.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
