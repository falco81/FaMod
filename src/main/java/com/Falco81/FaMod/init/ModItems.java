package com.Falco81.FaMod.init;

import com.Falco81.FaMod.FaMod;
import com.Falco81.FaMod.items.ManganAxe;
import com.Falco81.FaMod.items.ManganDust;
import com.Falco81.FaMod.items.ManganIngot;
import com.Falco81.FaMod.items.ManganPickaxe;
import com.Falco81.FaMod.items.ShockCoal;
import com.Falco81.FaMod.items.SmeltingEye;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
	
	public static ManganIngot ingotMangan = new ManganIngot("ingot_mangan", "ingotMangan").setCreativeTab(FaMod.creativeTab);
	public static ManganDust dustMangan = new ManganDust("dust_mangan", "dustMangan").setCreativeTab(FaMod.creativeTab);
	public static ManganAxe manganAxe = new ManganAxe(FaMod.manganToolMaterial, "mangan_axe");
	public static ManganPickaxe manganPickaxe = new ManganPickaxe(FaMod.manganToolMaterial, "mangan_pickaxe");
	public static ShockCoal coalShock = new ShockCoal("coal_shock", "coalShock").setCreativeTab(FaMod.creativeTab);
	public static SmeltingEye smeltingEye = new SmeltingEye(FaMod.manganToolMaterial, "smelting_eye").setCreativeTab(FaMod.creativeTab);


	public static void register(IForgeRegistry<Item> registry) {
		registry.registerAll(ingotMangan);
		registry.registerAll(dustMangan);
		registry.registerAll(manganAxe);
		registry.registerAll(manganPickaxe);
		registry.registerAll(coalShock);
		registry.registerAll(smeltingEye);
	}

	public static void registerModels() {
		ingotMangan.registerItemModel();
		dustMangan.registerItemModel();
		manganAxe.registerItemModel();
		manganPickaxe.registerItemModel();
		coalShock.registerItemModel();
		smeltingEye.registerItemModel();
	}
	
}
