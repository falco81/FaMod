package net.falco81.famod.items;

import net.falco81.famod.FaMod;
import net.falco81.famod.lib.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TreeAxe extends ItemAxe {
     public TreeAxe(int itemId, EnumToolMaterial material) {
        super(itemId, material);
        setCreativeTab(FaMod.tabsFaMod);
        
        if(material.name() == "EMERALD") {
            setUnlocalizedName("axeEmerald");
        } else {
            setUnlocalizedName("axeUnknown");
        }
    }
    
     @Override
     public boolean onBlockStartBreak(ItemStack itemstack, int x, int y, int z, EntityPlayer player) {
         World world = player.worldObj;
         Material material = world.getBlockMaterial(x, y, z);
         Material materialchop = material;
         for (int i = x - 1; i <= x + 1; i++) {
             for (int j = y - 1; j <= y + 1; j++) {
                 for (int k = z - 1; k <= z + 1; k++) {
                     material = world.getBlockMaterial(i, j, k);
                     if ((material == Material.wood) && (materialchop == Material.wood)) {
                         world.destroyBlock(i, j, k, true);
                         itemstack.damageItem(1, player);
                     }
                 }
             }
         }
         return false;
     }
     
     @Override
     public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int par3, int par4, int par5, int par6, EntityLiving par7EntityLiving) {
         return true;
     }

    

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister myIcon)
    {
      itemIcon = myIcon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().toLowerCase());
    }   
}

