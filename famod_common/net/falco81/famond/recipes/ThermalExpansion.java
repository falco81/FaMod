package net.falco81.famond.recipes;

import net.falco81.famod.bolcks.ModBlocks;
import net.falco81.famod.items.ModItems;
import net.minecraft.item.ItemStack;
import thermalexpansion.api.crafting.CraftingManagers;
import cpw.mods.fml.common.Loader;

public class ThermalExpansion {
    public static void initRecipes() {
        if (Loader.isModLoaded("ThermalExpansion")) {

            System.out
                    .println("<FaMod>: Thermal Expansion integration was Loaded!");

            try {
                addPulverizerOreToDustRecipe(new ItemStack(
                        ModBlocks.FaModManganOre), new ItemStack(
                        ModItems.FaModManganDust));
                addPulverizerIngotToDustRecipe(new ItemStack(
                        ModItems.FaModManganIngot), new ItemStack(
                        ModItems.FaModManganDust));

            }

            catch (Exception e) {

                System.out
                        .println("<FaMod>: Thermal Expansion integration was "
                                + "unsuccessful - please contact the author of this mod to let them know "
                                + "that the API may have changed.");
            }
        }

    }

    public static boolean addPulverizerOreToDustRecipe(ItemStack inputOre,
            ItemStack outputDust) {

        if (inputOre == null || outputDust == null) {
            return false;
        }

        ItemStack ore = inputOre.copy();
        ore.stackSize = 1;

        ItemStack primaryDust = outputDust.copy();
        primaryDust.stackSize = 2;

        return CraftingManagers.pulverizerManager.addRecipe(400, ore,
                primaryDust);
    }

    public static boolean addPulverizerIngotToDustRecipe(ItemStack inputIngot,
            ItemStack outputDust) {

        if (inputIngot == null || outputDust == null) {
            return false;
        }

        ItemStack ingot = inputIngot.copy();
        ingot.stackSize = 1;

        ItemStack primaryDust = outputDust.copy();
        primaryDust.stackSize = 1;

        return CraftingManagers.pulverizerManager.addRecipe(400, ingot,
                primaryDust);
    }

}
