package com.Falco81.FaMod.items;

import com.Falco81.FaMod.FaMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

public class ManganRefinedIngot extends Item {
	protected String name;
	private String oreName;

	public ManganRefinedIngot(String name, String oreName) {
		this.name = name;
		this.oreName = oreName;
		setUnlocalizedName(name);
		setRegistryName(name);
	}
	
	public void initOreDict() {
		OreDictionary.registerOre(oreName, this);
	}
	
	public void registerItemModel() {
		FaMod.proxy.registerItemRenderer(this, 0, name);
	}
	
	@Override
	public ManganRefinedIngot setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(FaMod.creativeTab);
		return this;
	}

}
