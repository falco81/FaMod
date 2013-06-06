package net.falco81.famod.multiblocks;

import java.util.Random;

import net.falco81.famod.FaMod;
import net.falco81.famod.bolcks.ModBlocks;
import net.falco81.famod.lib.Reference;
import net.falco81.famod.tileentity.TileEntityShockFurnaceCore;
import net.falco81.famod.tileentity.TileEntityShockFurnaceDummy;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class BlockShockFurnaceDummy extends BlockContainer {
    public BlockShockFurnaceDummy(int blockId) {
        super(blockId, Material.rock);

        setUnlocalizedName("blockShockFurnaceDummy");
        setStepSound(Block.soundStoneFootstep);
        setHardness(3.5f);
        setCreativeTab(FaMod.tabsFaMod);
        
        MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 4);
    }

    @Override
    public int idDropped(int par1, Random par2Random, int par3) {
        return ModBlocks.FaModShockCoalBlock.blockID;
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileEntityShockFurnaceDummy();
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":"+"shockfurnacewall");
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
        TileEntityShockFurnaceDummy dummy = (TileEntityShockFurnaceDummy) world
                .getBlockTileEntity(x, y, z);

        if (dummy != null && dummy.getCore() != null)
            dummy.getCore().invalidateMultiblock();

        super.breakBlock(world, x, y, z, par5, par6);
    }
    
   

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z,
            EntityPlayer player, int par6, float par7, float par8, float par9) {
        if (player.isSneaking())
            return false;

        TileEntityShockFurnaceDummy dummy = (TileEntityShockFurnaceDummy) world
                .getBlockTileEntity(x, y, z);

        if (dummy != null && dummy.getCore() != null) {
            TileEntityShockFurnaceCore core = dummy.getCore();
            return core.getBlockType().onBlockActivated(world, core.xCoord,
                    core.yCoord, core.zCoord, player, par6, par7, par8, par9);
        }

        return true;
    }
}
