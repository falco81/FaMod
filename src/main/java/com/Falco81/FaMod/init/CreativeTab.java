package com.Falco81.FaMod.init;

import com.Falco81.FaMod.FaMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTab extends CreativeTabs {
	
	public CreativeTab() {
		super(FaMod.modId);
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.ingotMangan);
	}

}
