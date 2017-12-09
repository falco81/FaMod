package com.Falco81.FaMod.utils;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.Falco81.FaMod.init.ModBlocks;
import com.Falco81.FaMod.init.ModItems;

import cofh.api.util.ThermalExpansionHelper;

public class ThermalExpansion {
	public static void init() {
		ThermalExpansionHelper.addPulverizerRecipe(2800, new ItemStack(ModBlocks.oreMangan), new ItemStack(ModItems.dustMangan, 1, 16));
	}
}
