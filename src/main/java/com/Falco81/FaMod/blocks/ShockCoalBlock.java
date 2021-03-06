package com.Falco81.FaMod.blocks;

import java.awt.Color;
import java.awt.List;
import java.util.Random;

import com.Falco81.FaMod.FaMod;
import com.Falco81.FaMod.init.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class ShockCoalBlock extends Block {
	protected String name;
	
	public ShockCoalBlock(String name) {
		
		super(Material.ROCK);
		
		setHardness(3f);
		setResistance(5f);
		this.name = name;
	
		setUnlocalizedName(name);
		setRegistryName(name);
	}
	
		
	public void registerItemModel(Item itemBlock) {
		FaMod.proxy.registerItemRenderer(itemBlock, 0, name);
	}
	
	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}
	
	@Override
	public ShockCoalBlock setCreativeTab(CreativeTabs tab) {
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
