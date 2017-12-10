package com.Falco81.FaMod.blocks;

import javax.annotation.Nullable;

import com.Falco81.FaMod.FaMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class ShockFurnace extends Block {
	protected String name;
	
	public ShockFurnace(String name) {
		
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
	public ShockFurnace setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(FaMod.creativeTab);
		return this;
	}
}
