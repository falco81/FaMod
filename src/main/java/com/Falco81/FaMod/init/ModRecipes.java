package com.Falco81.FaMod.init;

import com.Falco81.FaMod.utils.ModChecker;
import com.Falco81.FaMod.utils.ThermalExpansion;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class ModRecipes {
	public static void init() {
		// vanila Smelting
		GameRegistry.addSmelting(ModBlocks.oreMangan, new ItemStack(ModItems.ingotMangan), 0.7f);
		GameRegistry.addSmelting(ModItems.dustMangan, new ItemStack(ModItems.ingotMangan), 0.7f);

		// Crafting recipes
		
		// Mangan Axe
		ResourceLocation famodRecipes = new ResourceLocation("famodRecipes");
		GameRegistry.addShapedRecipe(new ResourceLocation("famod:mangan_axe_recipe"), famodRecipes, new ItemStack(ModItems.manganAxe), new Object[]{
		            "DD ",
		            "DE ",
		            " E ",
		            'D', ModItems.ingotMangan,
		            'E', Items.STICK     // note carefully - 'E' not "E" !
					});
		
		// Mangan Pickaxe
		GameRegistry.addShapedRecipe(new ResourceLocation("famod:mangan_pickaxe_recipe"), famodRecipes, new ItemStack(ModItems.manganPickaxe), new Object[]{
	            "DDD",
	            " E ",
	            " E ",
	            'D', ModItems.ingotMangan,
	            'E', Items.STICK     // note carefully - 'E' not "E" !
				});
		
		// Smelting Eye
		GameRegistry.addShapedRecipe(new ResourceLocation("famod:smelting_eye_recipe"), famodRecipes, new ItemStack(ModItems.smeltingEye), new Object[]{
	            "DDD",
	            "DED",
	            "DDD",
	            'D', ModBlocks.blockShockCoal,
	            'E', Items.ENDER_EYE     // note carefully - 'E' not "E" !
				});
		
		//Shock Colal -> Shock Coal Block
		GameRegistry.addShapedRecipe(new ResourceLocation("famod:block_shockcoal_recipe"), famodRecipes, new ItemStack(ModBlocks.blockShockCoal), new Object[]{
	            "EEE",
	            "EEE",
	            "EEE",
	            'E', ModItems.coalShock     // note carefully - 'E' not "E" !
				});
				
		//Shock Colal Block -> Shock Coal
		final int NUMBER_OF_SHOCKCOAL_PRODUCED = 9;
		GameRegistry.addShapelessRecipe(new ResourceLocation("famod:shockcoal_recipe"), famodRecipes, new ItemStack(ModItems.coalShock, NUMBER_OF_SHOCKCOAL_PRODUCED),
				new Ingredient[] {Ingredient.fromStacks(new ItemStack(ModBlocks.blockShockCoal, 1))
         		});
		
		// Thermal Expansion
		if(ModChecker.isThermalExpansionLoaded) {
		 ThermalExpansion.init();
		}

	}
}
