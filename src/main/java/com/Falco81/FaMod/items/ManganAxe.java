package com.Falco81.FaMod.items;

import java.awt.Color;

import com.Falco81.FaMod.FaMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ManganAxe extends ItemAxe {
	private String name;

	public ManganAxe(ToolMaterial material, String name) {
		super(material, 8f, -3.1f);
		this.name = name;
		setRegistryName(name);
		setUnlocalizedName(name);
	}
	
	public void registerItemModel() {
		FaMod.proxy.registerItemRenderer(this, 0, name);
	}

	private void Chop(int xc, int yc, int zc, EntityPlayer playerc,ItemStack itemstackc) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                for (int k = -1; k <= 1; k++) {
                	if (playerc.world.getBlockState(new BlockPos(xc + i, yc + j, zc + k)).getMaterial() == Material.WOOD) {
                		Chop(xc + i, yc + j, zc + k, playerc, itemstackc);
                		
                    } else {

                        playerc.world.destroyBlock(new BlockPos(xc, yc, zc ), true);
                        // itemstackc.damageItem(1, playerc);

                    }
                }
            }
        }

    }
	
	@Override
	public ManganAxe setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(FaMod.creativeTab);
		return this;
	}
	
	@SideOnly(Side.CLIENT)
    @Override
    public boolean hasEffect(ItemStack stack)
    {
        return true;
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase entityHit, EntityLivingBase player)
    {
        //Damages hammer for 1 tunnel mining use
        stack.damageItem(1, entityHit);
        return true;
    }

    //Overriding this to stop item damage which is handled elsewhere
    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving)
    {
        return true;
    }

    @Override
    public boolean onBlockStartBreak(ItemStack stack, BlockPos pos, EntityPlayer player)
    {
        //Can only mine when the NBT tag isn't true
        //if(NBTHelper.getBoolean(stack, "mining")) return true;
        //return super.onBlockStartBreak(stack, pos, player);
        if (player.world.getBlockState(pos).getMaterial() == Material.WOOD) {
          	Chop(pos.getX(), pos.getY(), pos.getZ(), player, stack);
           	//player.sendMessage(new TextComponentTranslation("Chop x:"+pos.getX()+" y: "+pos.getY()+" z: "+pos.getZ(), new Object[0]));
           	// stack.damageItem(10, player);
           	return true;
        }
        return super.onBlockStartBreak(stack, pos, player);
     }
	
	 @SideOnly(Side.CLIENT)
	 @Override
	 public void addInformation(ItemStack stack, World worldIn, java.util.List<String> tooltip, ITooltipFlag flagIn) {
		 tooltip.add(TextFormatting.RED + "Warning: Wood Destroyer!!!");
		 super.addInformation(stack, worldIn, tooltip, flagIn);  
	 }	
		
	
}
