package net.falco81.famod.bolcks;

import net.falco81.famod.FaMod;
import net.falco81.famod.lib.Strings;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemDecorBlock extends ItemBlock {
    public ItemDecorBlock(int par1) {
        super(par1);
        setHasSubtypes(true);
        setMaxDamage(0);
        setCreativeTab(FaMod.tabsFaMod);
    }


    @Override
    public int getMetadata(int meta) {
        return meta;
    }


    public String getUnlocalizedName(ItemStack is) {
        int meta = is.getItemDamage();
        return getUnlocalizedName() + "." + Strings.DECOR[meta];
    }


}
