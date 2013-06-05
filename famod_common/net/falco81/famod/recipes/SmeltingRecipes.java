package net.falco81.famod.recipes;

import net.falco81.famod.bolcks.ModBlocks;
import net.falco81.famod.items.ModItems;
import net.falco81.famod.lib.Metadata;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class SmeltingRecipes {
    public static void initRecipes() {
                
        FurnaceRecipes.smelting().addSmelting(ModBlocks.FaModManganOre.blockID ,0, new ItemStack(ModItems.FaModManganIngot), 0.5F);
        FurnaceRecipes.smelting().addSmelting(ModItems.FaModManganDust.itemID ,0, new ItemStack(ModItems.FaModManganIngot), 0.5F);
        
        FurnaceRecipes.smelting().addSmelting(ModBlocks.FaModDecorBlock.blockID ,Metadata.BASALTCOBBLE, ModBlocks.FaModBasalt, 0.5F);
        
                
    }

}
