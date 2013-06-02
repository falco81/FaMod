package net.falco81.famod.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.falco81.famod.FaMod;
import net.falco81.famod.lib.Reference;
import net.falco81.famod.lib.Strings;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ShockCoal extends Item {
    public ShockCoal(int id) {
        super(id);

        maxStackSize = 64;
        setCreativeTab(FaMod.tabsFaMod);
        setUnlocalizedName("shockcoal");
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack,
            EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        par3List.add(Strings.FAMODSHOCKCOAL_DISNAME_LINE2);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister myIcon) {
        itemIcon = myIcon.registerIcon(Reference.MOD_ID.toLowerCase() + ":"
                + this.getUnlocalizedName().toLowerCase());
    }

}
