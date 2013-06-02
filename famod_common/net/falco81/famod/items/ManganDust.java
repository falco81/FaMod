package net.falco81.famod.items;

import net.falco81.famod.FaMod;
import net.falco81.famod.lib.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ManganDust extends Item {
    public ManganDust(int id) {
        super(id);
        
        maxStackSize = 64;
        setCreativeTab(FaMod.tabsFaMod);
        setUnlocalizedName("mangandust");
        }
        
        
        @SideOnly(Side.CLIENT)
        public void registerIcons(IconRegister myIcon)
        {
          itemIcon = myIcon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().toLowerCase());
        }

}
