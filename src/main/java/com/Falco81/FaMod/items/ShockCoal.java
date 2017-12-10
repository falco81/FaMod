package com.Falco81.FaMod.items;

import java.awt.Color;
import java.awt.List;

import com.Falco81.FaMod.FaMod;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
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
	 @Override
	 public void addInformation(ItemStack stack, World worldIn, java.util.List<String> tooltip, ITooltipFlag flagIn) {
		 tooltip.add(TextFormatting.RED + "Warning: Very Hot!!!");
		 super.addInformation(stack, worldIn, tooltip, flagIn);
	 }
}
