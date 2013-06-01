package net.falco81.famod.bolcks;

import net.falco81.famod.FaMod;
import net.falco81.famod.lib.FaModTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ShockFurnaceBlock extends Block {

    public ShockFurnaceBlock(int id)
    {
        super(id, Material.rock);
        
        setUnlocalizedName("shockgurnace");
        setHardness(5f);
        setCreativeTab(FaMod.tabsFaMod);
    }
    
    @Override
    public boolean hasTileEntity(int metadata)
    {
        return true;
    }
    
    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer playerEntity, int par6, float par7, float par8, float par9)
    {
        if(playerEntity.isSneaking())
            return false;
        
        playerEntity.setEntityHealth(0);
        return true;
    }
    
    @Override
    public TileEntity createTileEntity(World world, int metadata)
    {
        return new FaModTileEntity();
    }
    
    @Override
    public int getRenderType()
    {
        return -1;
    }

    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister myIcon)
    {
      //blockIcon = myIcon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName2().toLowerCase());
        blockIcon= null;
    }
}
