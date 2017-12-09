package com.Falco81.FaMod.blocks;

import java.awt.List;
import java.util.Random;

import com.Falco81.FaMod.FaMod;
import com.Falco81.FaMod.init.ModItems;

import cofh.core.util.helpers.DamageHelper.DamageSourceCryotheum;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class ShockCoalOre extends Block {
	protected String name;
	private String oreName;
	
	public ShockCoalOre(String name, String oreName) {
		
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
	public ShockCoalOre setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(FaMod.creativeTab);
		return this;
	}
	
	 @SideOnly(Side.CLIENT)
	    public void addInformation(ItemStack par1ItemStack,
	            EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
	        par3List.add("Warning...");
	    }
	
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
		player.attackEntityFrom(DamageSource.GENERIC, 5);
		super.onBlockHarvested(worldIn, pos, state, player);
	} 
	 
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ModItems.coalShock;
	}
	 
	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
		  if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped((IBlockState)this.getBlockState().getValidStates().iterator().next(), random, fortune))
	        {
	            int var3 = random.nextInt(fortune + 2) - 1;

	            if (var3 < 0)
	            {
	                var3 = 0;
	            }

	            return this.quantityDropped(random) * (var3 + 1);
	        }
	        else
	        {
	            return this.quantityDropped(random);
	        }
	}
}
