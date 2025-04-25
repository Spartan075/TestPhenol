package net.spartan075.phenoltest.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.spartan075.phenoltest.PhenolTest;
import net.spartan075.phenoltest.block.BlockRegistration;
import net.spartan075.phenoltest.item.ItemRegistration;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    private static final List<ItemLike> PHENA_SMELTABLES = List.of(ItemRegistration.RAW_PHENA.get(), BlockRegistration.PHENA_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        oreBlasting(pWriter, PHENA_SMELTABLES, RecipeCategory.MISC, ItemRegistration.PHENA_INGOT.get(), 0.25f, 200, "phena");
        oreSmelting(pWriter, PHENA_SMELTABLES, RecipeCategory.MISC, ItemRegistration.PHENA_INGOT.get(), 0.25f, 100, "phena");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockRegistration.PHENA_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ItemRegistration.PHENA_INGOT.get())
                .unlockedBy(getHasName(ItemRegistration.PHENA_INGOT.get()), has(ItemRegistration.PHENA_INGOT.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistration.PHENA_INGOT.get(), 9)
                .requires(BlockRegistration.PHENA_BLOCK.get())
                .unlockedBy(getHasName(BlockRegistration.PHENA_BLOCK.get()), has(BlockRegistration.PHENA_BLOCK.get()))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  PhenolTest.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
