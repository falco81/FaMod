package com.Falco81.FaMod.items;

import com.Falco81.FaMod.FaMod;
import com.Falco81.FaMod.utils.NBTHelper;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ManganPickaxe extends ItemPickaxe{
	private String name;

	public ManganPickaxe(ToolMaterial material, String name) {
		super(material);
		setRegistryName(name);
		setUnlocalizedName(name);
		this.name = name;
	}
	
	public void registerItemModel() {
		FaMod.proxy.registerItemRenderer(this, 0, name);
	}
	
		
	@Override
	public ManganPickaxe setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(FaMod.creativeTab);
		return this;
	}
	
	@Override
	public float getDestroySpeed(ItemStack stack, IBlockState state) {
		if (state.getBlock() == Blocks.OBSIDIAN) {
			return 150.0F;
		}
		else {
			return super.getDestroySpeed(stack, state);
		}
	}
	
	
}
