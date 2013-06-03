package net.falco81.famod.recipes;

import net.falco81.famod.bolcks.ModBlocks;
import net.falco81.famod.items.ModItems;
import net.falco81.famod.lib.Metadata;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class CraftingRecipes {
    public static void initRecipes() {
      
        
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
        GameRegistry.addRecipe(new ItemStack(ModItems.FaModSickleDiamond),
                new Object[] { " # ", "  #", "I# ", Character.valueOf('#'), Item.diamond,
                        Character.valueOf('I'), Item.stick });
        
        GameRegistry.addRecipe(new ItemStack(ModItems.FaModTreeAxe),
                new Object[] { "## ", "#I ", " I ", Character.valueOf('#'), Item.emerald,
                        Character.valueOf('I'), Item.stick });
        
        GameRegistry.addRecipe(new ItemStack(ModBlocks.FaModManganBlock), new Object[] { "iii", "iii", "iii", Character.valueOf('i'), ModItems.FaModManganIngot });
        GameRegistry.addRecipe(new ItemStack(ModItems.FaModManganIngot, 9), new Object[] { "i", Character.valueOf('i'), ModBlocks.FaModManganBlock });
        
        GameRegistry.addRecipe(new ItemStack(ModItems.FaModManganPickAxe), new Object[] { "iii", " j ", " j ", Character.valueOf('i'), ModItems.FaModManganIngot, Character.valueOf('j'), Item.stick });
        GameRegistry.addRecipe(new ItemStack(ModItems.FaModManganAxe), new Object[] { "ii ", "ij ", " j ", Character.valueOf('i'), ModItems.FaModManganIngot, Character.valueOf('j'), Item.stick });
        GameRegistry.addRecipe(new ItemStack(ModItems.FaModManganSword), new Object[] { "i", "i", "j", Character.valueOf('i'), ModItems.FaModManganIngot, Character.valueOf('j'), Item.stick });
        
        GameRegistry.addRecipe(new ItemStack(ModBlocks.FaModShockCoalBlock), new Object[] { "iii", "iii", "iii", Character.valueOf('i'), ModItems.FaModShockCoal });
        GameRegistry.addRecipe(new ItemStack(ModItems.FaModShockCoal, 9), new Object[] { "i", Character.valueOf('i'), ModBlocks.FaModShockCoalBlock });
       
        
        GameRegistry.addRecipe(new ItemStack(ModBlocks.FaModDecorBlock, 4, Metadata.BASALTBRICK), new Object[] { "ii","ii", Character.valueOf('i'), ModBlocks.FaModBasalt });
        GameRegistry.addRecipe(new ItemStack(ModBlocks.FaModDecorBlock, 4, Metadata.MARBLEBRICK), new Object[] { "ii","ii", Character.valueOf('i'), ModBlocks.FaModMarble });
        GameRegistry.addRecipe(new ItemStack(ModBlocks.FaModDecorBlock, 4, Metadata.BASALTCHISELED), new Object[] { "ii","ii", Character.valueOf('i'), ModBlocks.FaModBasaltBrick });
        GameRegistry.addRecipe(new ItemStack(ModBlocks.FaModDecorBlock, 1, Metadata.BASALTPAVER), new Object[] { "i", Character.valueOf('i'), ModBlocks.FaModBasalt });
        
        GameRegistry.addRecipe(new ItemStack(ModBlocks.FaModDecorBlock, 1, Metadata.BASALTBRICK), new Object[] { "i", Character.valueOf('i'), ModBlocks.FaModBasaltChiseled });
        
        GameRegistry.addRecipe(new ItemStack(ModBlocks.FaModShockFurnace), new Object[] { "iii", "iji", "iii", Character.valueOf('i'), ModBlocks.FaModShockCoalBlock, Character.valueOf('j'), Block.blockDiamond });
        
    }
}