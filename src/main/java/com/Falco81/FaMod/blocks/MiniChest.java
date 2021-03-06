package com.Falco81.FaMod.blocks;

import com.Falco81.FaMod.FaMod;
import com.Falco81.FaMod.MiniChest.GuiHandlerMiniChest;
import com.Falco81.FaMod.MiniChest.TileInventoryMiniChest;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MiniChest extends BlockContainer {
	protected String name;
	
	public MiniChest(String name) {
		
		super(Material.WOOD);
		
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
	public MiniChest setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(FaMod.creativeTab);
		return this;
	}
	
	@Override
	  public TileEntity createNewTileEntity(World worldIn, int meta) {
	    return new TileInventoryMiniChest();
	  }

	  // not needed if your block implements ITileEntityProvider (in this case implemented by BlockContainer), but it
	  //  doesn't hurt to include it anyway...
		@Override
		public boolean hasTileEntity(IBlockState state)
		{
			return true;
		}

		// Called when the block is right clicked
		// In this block it is used to open the blocks gui when right clicked by a player
		@Override
		public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand,
																		EnumFacing side, float hitX, float hitY, float hitZ) {
			// Uses the gui handler registered to your mod to open the gui for the given gui id
			// open on the server side only  (not sure why you shouldn't open client side too... vanilla doesn't, so we better not either)
			if (worldIn.isRemote) return true;

			playerIn.openGui(FaMod.instance, GuiHandlerMiniChest.getGuiID(), worldIn, pos.getX(), pos.getY(), pos.getZ());
			return true;
		}

		// This is where you can do something when the block is broken. In this case drop the inventory's contents
		@Override
		public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {

			IInventory inventory = worldIn.getTileEntity(pos) instanceof IInventory ? (IInventory)worldIn.getTileEntity(pos) : null;

			if (inventory != null){
				// For each slot in the inventory
				for (int i = 0; i < inventory.getSizeInventory(); i++){
					// If the slot is not empty
					if (!inventory.getStackInSlot(i).isEmpty())  // isEmpty
					{
						// Create a new entity item with the item stack in the slot
						EntityItem item = new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, inventory.getStackInSlot(i));

						// Apply some random motion to the item
						float multiplier = 0.1f;
						float motionX = worldIn.rand.nextFloat() - 0.5f;
						float motionY = worldIn.rand.nextFloat() - 0.5f;
						float motionZ = worldIn.rand.nextFloat() - 0.5f;

						item.motionX = motionX * multiplier;
						item.motionY = motionY * multiplier;
						item.motionZ = motionZ * multiplier;

						// Spawn the item in the world
						worldIn.spawnEntity(item);
					}
				}

				// Clear the inventory so nothing else (such as another mod) can do anything with the items
				inventory.clear();
			}

			// Super MUST be called last because it removes the tile entity
			super.breakBlock(worldIn, pos, state);
		}

		//---------------------------------------------------------

		// the block is smaller than a full cube, specify dimensions here
		@Override
		public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
			return new AxisAlignedBB(1/16.0F, 0, 1/16.0F, 15/16.0F, 8/16.0F, 15/16.0F);
		}

		// the block will render in the SOLID layer.  See http://greyminecraftcoder.blogspot.co.at/2014/12/block-rendering-18.html for more information.
		@SideOnly(Side.CLIENT)
		public BlockRenderLayer getBlockLayer()
		{
			return BlockRenderLayer.SOLID;
		}

		// used by the renderer to control lighting and visibility of other blocks.
		// set to false because this block doesn't fill the entire 1x1x1 space
		@Override
		public boolean isOpaqueCube(IBlockState state)
		{
			return false;
		}

		// used by the renderer to control lighting and visibility of other blocks, also by
		// (eg) wall or fence to control whether the fence joins itself to this block
		// set to false because this block doesn't fill the entire 1x1x1 space
		@Override
		public boolean isFullCube(IBlockState state)
		{
			return false;
		}

	  // render using a BakedModel (mbe30_inventory_basic.json --> mbe30_inventory_basic_model.json)
	  // required because the default (super method) is INVISIBLE for BlockContainers.
	  @Override
	  public EnumBlockRenderType getRenderType(IBlockState iBlockState) {
	    return EnumBlockRenderType.MODEL;
	  }

}
