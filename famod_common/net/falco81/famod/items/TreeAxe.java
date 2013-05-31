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

        if (material.name() == "EMERALD") {
            setUnlocalizedName("axeEmerald");
        } else {
            setUnlocalizedName("axeUnknown");
        }
    }

    private void Chop(int xc, int yc, int zc, EntityPlayer playerc,
            ItemStack itemstackc) {

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                for (int k = -1; k <= 1; k++) {

                    if (playerc.worldObj.getBlockMaterial(xc + i, yc + j, zc
                            + k) == Material.wood) {
                        Chop(xc + i, yc + j, zc + k, playerc, itemstackc);

                    } else {

                        playerc.worldObj.destroyBlock(xc, yc, zc, true);
                        itemstackc.damageItem(1, playerc);

                    }
                }
            }
        }

    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, int x, int y, int z,
            EntityPlayer player) {

        Chop(x, y, z, player, itemstack);

        return false;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World,
            int par3, int par4, int par5, int par6,
            EntityLiving par7EntityLiving) {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister myIcon) {
        itemIcon = myIcon.registerIcon(Reference.MOD_ID.toLowerCase() + ":"
                + this.getUnlocalizedName().toLowerCase());
    }
}
