package net.falco81.famod.items;

import net.falco81.famod.FaMod;
import net.falco81.famod.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PickAxe extends ItemPickaxe {
    public PickAxe(int itemId, EnumToolMaterial material){
        super(itemId, material);
        setCreativeTab(FaMod.tabsFaMod);
        if (material.name() == "MANGAN") {
            setUnlocalizedName("manganpickaxe");
         } else {
            setUnlocalizedName("unknownpickaxe");
        }      
    }
    
    
    @Override
    public float getStrVsBlock(ItemStack itemstack, Block block) {
        if(block == Block.obsidian){
            return 200F;
        }
        return 12.0F;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister myIcon)
    {
      itemIcon = myIcon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().toLowerCase());
    }   
}
