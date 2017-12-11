package com.Falco81.FaMod.blocks;

import com.Falco81.FaMod.FaMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.oredict.OreDictionary;

public class ManganBlock extends Block {
	protected String name;
	private String oreName;
	
	public ManganBlock(String name, String oreName) {
		
		super(Material.ROCK);
		
		setHardness(3f);
		setResistance(5f);
		this.name = name;
		this.oreName = oreName;
	
		setUnlocalizedName(name);
		setRegistryName(name);
	}
	
	public void initOreDict() {
		OreDictionary.registerOre(oreName, this);
	}
	
	public void registerItemModel(Item itemBlock) {
		FaMod.proxy.registerItemRenderer(itemBlock, 0, name);
	}
	
	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}
	
	@Override
	public ManganBlock setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(FaMod.creativeTab);
		return this;
	}
}
