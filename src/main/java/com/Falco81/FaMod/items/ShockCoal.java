package com.Falco81.FaMod.items;

import java.awt.List;

import com.Falco81.FaMod.FaMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class ShockCoal extends Item  {
	protected String name;
	private String oreName;

	public ShockCoal(String name, String oreName) {
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
	public ShockCoal setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(FaMod.creativeTab);
		return this;
	}
	
	 @SideOnly(Side.CLIENT)
	    public void addInformation(ItemStack par1ItemStack,
	            EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
	        par3List.add("Warning...");
	    }
}
