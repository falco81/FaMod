package com.Falco81.FaMod.init;

import com.Falco81.FaMod.utils.ModChecker;
import com.Falco81.FaMod.utils.ThermalExpansion;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class ModRecipes {
	public static void init() {
		// vanila Smelting
		GameRegistry.addSmelting(ModBlocks.oreMangan, new ItemStack(ModItems.ingotMangan), 0.7f);
		GameRegistry.addSmelting(ModItems.dustMangan, new ItemStack(ModItems.ingotMangan), 0.7f);

		// Crafting recipes
		ResourceLocation famodRecipes = new ResourceLocation("famodRecipes");
		GameRegistry.addShapedRecipe(new ResourceLocation("famod:mangan_axe_recipe"), famodRecipes, new ItemStack(ModItems.manganAxe), new Object[]{
		            "DD ",
		            "DE ",
		            " E ",
		            'D', ModItems.ingotMangan,
		            'E', Items.STICK     // note carefully - 'E' not "E" !
					});
		
		GameRegistry.addShapedRecipe(new ResourceLocation("famod:mangan_pickaxe_recipe"), famodRecipes, new ItemStack(ModItems.manganPickaxe), new Object[]{
	            "DDD",
	            " E ",
	            " E ",
	            'D', ModItems.ingotMangan,
	            'E', Items.STICK     // note carefully - 'E' not "E" !
				});
			
		
		GameRegistry.addShapedRecipe(new ResourceLocation("famod:smelting_eye_recipe"), famodRecipes, new ItemStack(ModItems.smeltingEye), new Object[]{
	            "DDD",
	            "DED",
	            "DDD",
	            'D', ModItems.ingotMangan,
	            'E', Items.ENDER_EYE     // note carefully - 'E' not "E" !
				});
		
		// Thermal Expansion
		if(ModChecker.isThermalExpansionLoaded) {
		 ThermalExpansion.init();
		}

	}
}
