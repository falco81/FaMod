package com.Falco81.FaMod.items;

import java.util.Set;

import com.Falco81.FaMod.FaMod;
import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.oredict.OreDictionary;

public class SmeltingEye extends ItemTool {
		protected String name;
		
		public SmeltingEye(ToolMaterial material, String name) {
		    super(0.0F, 0.0F, material, Sets.newHashSet(new Block[]{Blocks.COBBLESTONE}));
		    final int WOOD_HARDNESS_LEVEL = 0;
		    final int STONE_HARDNESS_LEVEL = 0;
		    this.setHarvestLevel("axe", WOOD_HARDNESS_LEVEL);  // default.  can also be set when creating the block instance, which is typically what vanilla does
		    this.setHarvestLevel("pickaxe", STONE_HARDNESS_LEVEL);  // can add hardness level for as many or few ToolClasses as you want; new ToolClasses also possible
			this.name = name;
			setRegistryName(name);
			setUnlocalizedName(name);
		  }		
		

	public void registerItemModel() {
		FaMod.proxy.registerItemRenderer(this, 0, name);
	}
	
	@Override
	public SmeltingEye setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(FaMod.creativeTab);
		return this;
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
	
		Block blocktype = player.world.getBlockState(pos).getBlock();
		ItemStack itemstack = player.getHeldItem(hand);
		//player.sendMessage(new TextComponentTranslation("Block: " + blocktype + " x:"+pos.getX()+" y: "+pos.getY()+" z: "+pos.getZ(), new Object[0]));
		
		if (!player.isSneaking()) {
			if (blocktype == Blocks.COBBLESTONE) {
				//player.sendMessage(new TextComponentTranslation("Transmute..", new Object[0]));
			     for (int i = pos.getX() - 1; i <= pos.getX() + 1; i++) {
		                for (int j = pos.getY() - 1; j <= pos.getY() + 1; j++) {
		                    for (int k = pos.getZ() - 1; k <= pos.getZ() + 1; k++) {
		                    	Block blocktypec = player.world.getBlockState(new BlockPos(i,j,k)).getBlock();
		                    	if (blocktypec == Blocks.COBBLESTONE) {
		                        	player.world.setBlockState(new BlockPos(i,j,k), Blocks.STONE.getDefaultState());
		                        	itemstack.damageItem(1, player);
		                       

		                        }
		                    }
		                }

		            }
			     worldIn.playSound(player, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
			     player.swingArm(hand);
		         return EnumActionResult.SUCCESS;         
		        }

		        else {
		        	return EnumActionResult.FAIL;
		        }

			
		}else
		{
			if (blocktype == Blocks.COBBLESTONE) {
				//player.sendMessage(new TextComponentTranslation("Transmute..", new Object[0]));
				player.world.setBlockState(pos, Blocks.STONE.getDefaultState());
				itemstack.damageItem(1, player);
				worldIn.playSound(player, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
			    player.swingArm(hand);
				return EnumActionResult.SUCCESS;
			}
			else {
	        	return EnumActionResult.FAIL;
	        }
		}

	}	
}
