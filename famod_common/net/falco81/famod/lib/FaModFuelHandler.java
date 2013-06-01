package net.falco81.famod.lib;

import net.falco81.famod.bolcks.ModBlocks;
import net.falco81.famod.items.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class FaModFuelHandler implements IFuelHandler  {
    @Override
    public int getBurnTime(ItemStack fuel) {
        int var1 = fuel.itemID;
        
        if(var1 == Item.book.itemID){
            return 300;
        }else if(var1 == ModItems.FaModShockCoal.itemID){
            return 40000;
        }else if(var1 == ModBlocks.FaModShockCoalBlock.blockID){
            return 360000;
        }else{
            return 0;
        }
    }

}
