package net.falco81.famond.recipes;

import net.falco81.famod.bolcks.ModBlocks;
import net.falco81.famod.items.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class SmeltingRecipes {
    public static void initRecipes() {
                
        FurnaceRecipes.smelting().addSmelting(ModBlocks.FaModManganOre.blockID ,0, new ItemStack(ModItems.FaModManganIngot), 0.5F);
        
    }

}
