package net.falco81.famod.recipes;

import ic2.api.item.Items;
import ic2.api.recipe.Recipes;
import net.falco81.famod.bolcks.ModBlocks;
import net.falco81.famod.items.ModItems;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class IC2 {
    public static void initRecipes() {
        if (Loader.isModLoaded("IC2")) {

            System.out.println("<FaMod>: IC2 integration was Loaded!");

            try {

                addMaceratorOreToDustRecipe(new ItemStack(
                        ModBlocks.FaModManganOre), new ItemStack(
                        ModItems.FaModManganDust));
                addMaceratorIngotToDustRecipe(new ItemStack(
                        ModItems.FaModManganIngot), new ItemStack(
                        ModItems.FaModManganDust));
                
                GameRegistry.addRecipe(new ItemStack(ModBlocks.FaModShockFurnace), new Object[] { "iii", "iji", "iii", Character.valueOf('i'), ModBlocks.FaModShockCoalBlock, Character.valueOf('j'), Items.getItem("mfsUnit") });

            }

            catch (Exception e) {

                System.out
                        .println("<FaMod>: IC2 integration was "
                                + "unsuccessful - please contact the author of this mod to let them know "
                                + "that the API may have changed.");
            }
        }

    }

    public static boolean addMaceratorOreToDustRecipe(ItemStack inputOre,
            ItemStack outputDust) {

        if (inputOre == null || outputDust == null) {
            return false;
        }

        else {

            ItemStack ore = inputOre.copy();
            ore.stackSize = 1;

            ItemStack primaryDust = outputDust.copy();
            primaryDust.stackSize = 2;

            Recipes.macerator.addRecipe(ore, primaryDust);

            return true;
        }
    }

    public static boolean addMaceratorIngotToDustRecipe(ItemStack inputIngot,
            ItemStack outputDust) {

        if (inputIngot == null || outputDust == null) {
            return false;
        } else {

            ItemStack ingot = inputIngot.copy();
            ingot.stackSize = 1;

            ItemStack primaryDust = outputDust.copy();
            primaryDust.stackSize = 1;

            Recipes.macerator.addRecipe(ingot, primaryDust);

            return true;

        }
    }
}
