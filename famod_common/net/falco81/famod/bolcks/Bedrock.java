package net.falco81.famod.bolcks;

import net.falco81.famod.FaMod;
import net.falco81.famod.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Bedrock extends Block {

    public Bedrock (int id) {
        super(id, Material.rock);
        setHardness(3.0F);
        setResistance(5.0F);
        setStepSound(soundStoneFootstep);
        setCreativeTab(FaMod.tabsFaMod);
        setUnlocalizedName("FaModBedrock");

        MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 0);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister myIcon)
    {
     this.blockIcon = myIcon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName2().toLowerCase());
    }

}