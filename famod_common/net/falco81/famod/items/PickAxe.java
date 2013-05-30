package net.falco81.famod.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.falco81.famod.FaMod;
import net.falco81.famod.lib.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;

public class PickAxe extends ItemPickaxe {
    public PickAxe(int itemId, EnumToolMaterial material){
        super(itemId, material);
        setCreativeTab(FaMod.tabsFaMod);
        setUnlocalizedName("manganpickaxe");
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister myIcon)
    {
      itemIcon = myIcon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().toLowerCase());
    }   
}
