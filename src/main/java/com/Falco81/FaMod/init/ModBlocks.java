package com.Falco81.FaMod.init;

import com.Falco81.FaMod.blocks.ManganBlock;
import com.Falco81.FaMod.blocks.ManganOre;
import com.Falco81.FaMod.blocks.ShockCoalBlock;
import com.Falco81.FaMod.blocks.ShockCoalOre;
import com.Falco81.FaMod.blocks.ShockFurnace;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {
	public static ManganOre oreMangan = new ManganOre("ore_mangan", "oreMangan").setCreativeTab(CreativeTabs.MATERIALS);
	public static ManganBlock blockMangan = new ManganBlock("block_mangan", "blockMangan").setCreativeTab(CreativeTabs.MATERIALS);
	public static ShockCoalOre oreShockCoal = new ShockCoalOre("ore_shockcoal", "oreShockCoal").setCreativeTab(CreativeTabs.MATERIALS);
	public static ShockCoalBlock blockShockCoal = new ShockCoalBlock("block_shockcoal").setCreativeTab(CreativeTabs.MATERIALS);
	public static ShockFurnace blockShockFurnace = new ShockFurnace("block_shockfurnace").setCreativeTab(CreativeTabs.MATERIALS);
	
	public static void register(IForgeRegistry<Block> registry) {
		registry.registerAll(oreMangan);
		registry.registerAll(oreShockCoal);
		registry.registerAll(blockShockCoal);
		registry.registerAll(blockShockFurnace);
		registry.registerAll(blockMangan);
	}
	
	public static void registerItemBlocks(IForgeRegistry<Item> registry) {
		registry.registerAll(oreMangan.createItemBlock());
		registry.registerAll(oreShockCoal.createItemBlock());
		registry.registerAll(blockShockCoal.createItemBlock());
		registry.registerAll(blockShockFurnace.createItemBlock());
		registry.registerAll(blockMangan.createItemBlock());
	}
	
	public static void registerModels() {
		oreMangan.registerItemModel(Item.getItemFromBlock(oreMangan));
		oreShockCoal.registerItemModel(Item.getItemFromBlock(oreShockCoal));
		blockShockCoal.registerItemModel(Item.getItemFromBlock(blockShockCoal));
		blockShockFurnace.registerItemModel(Item.getItemFromBlock(blockShockFurnace));
		blockMangan.registerItemModel(Item.getItemFromBlock(blockMangan));
	}
}
