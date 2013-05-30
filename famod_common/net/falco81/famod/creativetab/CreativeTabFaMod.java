package net.falco81.famod.creativetab;

import net.falco81.famod.lib.Blockids;
import net.falco81.famod.lib.Reference;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeTabFaMod extends CreativeTabs {

    public CreativeTabFaMod(int par1, String par2Str) {

        super(par1, par2Str);
        LanguageRegistry.instance().addStringLocalization("itemGroup."+Reference.MOD_ID, Reference.MOD_ID);
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * the itemID for the item to be displayed on the tab
     */
    public int getTabIconItemIndex() {

        return Blockids.FAMODMANGANORE;
    }
    

}
