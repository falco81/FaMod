package net.falco81.famond.recipes;

import net.falco81.famod.bolcks.ModBlocks;
import net.falco81.famod.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {
    public static void initRecipes() {

        GameRegistry.addRecipe(new ItemStack(ModBlocks.FaModBedrock), new Object[] { "ii", "ii", Character.valueOf('i'), ModBlocks.FaModSand });
        GameRegistry.addRecipe(new ItemStack(ModBlocks.FaModSand, 4), new Object[] { "i", Character.valueOf('i'), ModBlocks.FaModBedrock });

        FurnaceRecipes.smelting().addSmelting(ModBlocks.FaModSand.blockID ,0, new ItemStack(ModBlocks.FaModBedrock), 0.5F);
        FurnaceRecipes.smelting().addSmelting(ModBlocks.FaModMangan.blockID ,0, new ItemStack(ModItems.FaModManganIngot), 0.5F);
        
        
        GameRegistry.addRecipe(new ItemStack(ModItems.FaModSickleWooden),
                new Object[] { " # ", "  #", "I# ", Character.valueOf('#'), Block.planks,
                        Character.valueOf('I'), Item.stick });
        GameRegistry.addRecipe(new ItemStack(ModItems.FaModSickleStone),
                new Object[] { " # ", "  #", "I# ", Character.valueOf('#'),
                        Block.cobblestone, Character.valueOf('I'), Item.stick });
        GameRegistry.addRecipe(new ItemStack(ModItems.FaModSickleIron),
                new Object[] { " # ", "  #", "I# ", Character.valueOf('#'),
                        Item.ingotIron, Character.valueOf('I'), Item.stick });
        GameRegistry.addRecipe(new ItemStack(ModItems.FaModSickleGolden),
                new Object[] { " # ", "  #", "I# ", Character.valueOf('#'),
                        Item.ingotGold, Character.valueOf('I'), Item.stick });
        GameRegistry.addRecipe(new ItemStack(ModItems.FaModSickleEmerald),
                new Object[] { " # ", "  #", "I# ", Character.valueOf('#'), Item.emerald,
                        Character.valueOf('I'), Item.stick });
        
        GameRegistry.addRecipe(new ItemStack(ModItems.FaModTreeAxe),
                new Object[] { "## ", "#I ", " I ", Character.valueOf('#'), Item.emerald,
                        Character.valueOf('I'), Item.stick });
        
        GameRegistry.addRecipe(new ItemStack(ModBlocks.FaModManganBlock), new Object[] { "iii", "iii", "iii", Character.valueOf('i'), ModItems.FaModManganIngot });
        GameRegistry.addRecipe(new ItemStack(ModItems.FaModManganIngot, 9), new Object[] { "i", Character.valueOf('i'), ModBlocks.FaModManganBlock });
        
        GameRegistry.addRecipe(new ItemStack(ModItems.FaModManganPickAxe), new Object[] { "iii", " j ", " j ", Character.valueOf('i'), ModItems.FaModManganIngot, Character.valueOf('j'), Item.stick });
       
    }
}
