package net.falco81.famod.creativetab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.falco81.famod.lib.Blockids;
import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabFaMod extends CreativeTabs {

    public CreativeTabFaMod(int par1, String par2Str) {

        super(par1, par2Str);
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * the itemID for the item to be displayed on the tab
     */
    public int getTabIconItemIndex() {

        return Blockids.FAMODSAND;
    }

}
