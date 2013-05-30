package net.falco81.famod.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.falco81.famod.FaMod;
import net.falco81.famod.lib.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;

public class Sword extends ItemSword {
    public Sword(int itemId, EnumToolMaterial material) {
        super(itemId, material);
        setCreativeTab(FaMod.tabsFaMod);
        setMaxDamage(20);

        if (material.name() == "MANGAN") {
            setUnlocalizedName("swordMangan");
        } else {
            setUnlocalizedName("swordUnknown");
        }

    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister myIcon) {
        itemIcon = myIcon.registerIcon(Reference.MOD_ID.toLowerCase() + ":"
                + this.getUnlocalizedName().toLowerCase());
    }
}