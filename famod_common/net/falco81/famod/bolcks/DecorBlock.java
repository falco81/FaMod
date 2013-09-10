package net.falco81.famod.bolcks;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.falco81.famod.FaMod;
import net.falco81.famod.lib.Metadata;
import net.falco81.famod.lib.Reference;
import net.falco81.famod.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraftforge.common.MinecraftForge;

public class DecorBlock extends Block {
    public DecorBlock(int id) {
        super(id, Material.rock);
        setHardness(3.0F);
        setResistance(5.0F);
        setStepSound(soundStoneFootstep);
        setCreativeTab(FaMod.tabsFaMod);
        setUnlocalizedName("FaModBlockDecor");

        MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 0);
    }

    @SideOnly(Side.CLIENT)
    private Icon[] icons;

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister myIcon) {
        icons = new Icon[Strings.DECOR.length];
        for (int i = 0; i < Strings.DECOR.length; i++) {
            icons[i] = myIcon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().toLowerCase().replaceAll("tile.", "")+ Strings.DECOR[i].toLowerCase());
        }
    }
    
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int meta) {
        return icons[meta];
    }
    
    @Override
    public int damageDropped(int meta) {
        if (meta == Metadata.BASALT) {
            return Metadata.BASALTCOBBLE;
        } else {
            return meta;
        }
    }


    @Override
    public int quantityDropped(Random random) {
        return 1;
    }

    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(int par1, CreativeTabs creativetab, List list) {
        for (int i = 0; i < Strings.DECOR.length; i++) {
            list.add(new ItemStack(par1, 1, i));
        }
    }


}
