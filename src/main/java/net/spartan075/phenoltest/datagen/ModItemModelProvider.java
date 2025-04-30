package net.spartan075.phenoltest.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.spartan075.phenoltest.PhenolTest;
import net.spartan075.phenoltest.item.ItemRegistration;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, PhenolTest.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {


        simpleItem(ItemRegistration.MIKAN);
        simpleItem(ItemRegistration.PHENA_INGOT);
        simpleItem(ItemRegistration.RAW_PHENA);
        simpleItem(ItemRegistration.PHENA_DETECTOR);
        simpleItem(ItemRegistration.SULFUR);
        simpleItem(ItemRegistration.SULFURIC_ACID);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(PhenolTest.MODID, "item/" + item.getId().getPath()));
    }
}
