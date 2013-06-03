package net.falco81.famod.recipes;

import net.falco81.famod.bolcks.ModBlocks;
import net.falco81.famod.items.ModItems;
import net.minecraft.item.ItemStack;
import thermalexpansion.api.crafting.CraftingManagers;
import thermalexpansion.api.item.ItemRegistry;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

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
                
                GameRegistry.addRecipe(new ItemStack(ModBlocks.FaModShockFurnace), new Object[] { "iii", "iji", "iii", Character.valueOf('i'), ModBlocks.FaModShockCoalBlock, Character.valueOf('j'), ItemRegistry.getItem("energyCellFrameFull", 1) });

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
