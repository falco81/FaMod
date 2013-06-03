package net.falco81.famod.bolcks;

import net.falco81.famod.FaMod;
import net.falco81.famod.lib.FaModTileEntity;
import net.minecraft.block.BlockFurnace;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ShockFurnaceBlock extends BlockFurnace {
    
    public ShockFurnaceBlock(int id) {
        // super(id, Material.rock);
        
        super(id, false);

        setUnlocalizedName("shockfurnace");
        setHardness(5f);
        setCreativeTab(FaMod.tabsFaMod);

    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean hasTileEntity(int metadata) {
        return true;
    }

    public TileEntity createNewTileEntity(World par1World) {
        return new FaModTileEntity();
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister myIcon)
    {
        this.blockIcon = null;
        
    }

}
