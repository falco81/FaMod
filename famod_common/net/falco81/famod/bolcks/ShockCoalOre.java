package net.falco81.famod.bolcks;

import java.util.Random;

import net.falco81.famod.FaMod;
import net.falco81.famod.items.ModItems;
import net.falco81.famod.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ShockCoalOre extends Block {
    public ShockCoalOre(int id) {
        super(id, Material.rock);
        setHardness(3.0F);
        setResistance(5.0F);
        setStepSound(soundStoneFootstep);
        setCreativeTab(FaMod.tabsFaMod);
        setUnlocalizedName("FaModShockCoalOre");

        MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 4);
    }

    @Override
    public int idDropped(int par1, Random par2Random, int par3) {
        return ModItems.FaModShockCoal.itemID;

    }

    @Override
    public int quantityDroppedWithBonus(int par1, Random par2Random) {
        int min = 2;
        int max = 4;
        return par2Random.nextInt(max - min + 1) + min;
    }

    @Override
    public void onBlockHarvested(World par1World, int par2, int par3, int par4,
            int par5, EntityPlayer par6EntityPlayer) {
        par6EntityPlayer.setEntityHealth(par6EntityPlayer.getHealth() - 1);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister myIcon) {
        blockIcon = myIcon.registerIcon(Reference.MOD_ID.toLowerCase() + ":"
                + this.getUnlocalizedName2().toLowerCase());
    }

}
