package net.falco81.famod.bolcks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.falco81.famod.FaMod;
import net.falco81.famod.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class ShockCoalBlock extends Block{
    public ShockCoalBlock (int id) {
        super(id, Material.rock);
        setHardness(3.0F);
        setResistance(5.0F);
        setStepSound(soundStoneFootstep);
        setCreativeTab(FaMod.tabsFaMod);
        setUnlocalizedName("FaModShockCoalBlock");

        MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 4);
    }
    
    @Override
    public void onBlockHarvested(World par1World, int par2, int par3, int par4,
            int par5, EntityPlayer par6EntityPlayer) {
        //par6EntityPlayer.setEntityHealth(par6EntityPlayer.getHealth()-19);
        par6EntityPlayer.attackEntityFrom(DamageSource.generic, 5);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister myIcon)
    {
      blockIcon = myIcon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().toLowerCase().replaceAll("tile.", ""));
    }

}
