package net.falco81.famod.items;

import java.util.List;

import net.falco81.famod.FaMod;
import net.falco81.famod.lib.Reference;
import net.falco81.famod.lib.Strings;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StringTranslate;
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
                        // itemstackc.damageItem(1, playerc);

                    }
                }
            }
        }

    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, int x, int y, int z,
            EntityPlayer player) {

        if (player.worldObj.getBlockMaterial(x, y, z) == Material.wood) {
            Chop(x, y, z, player, itemstack);
            itemstack.damageItem(10, player);
        }

        return false;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World,
            int par3, int par4, int par5, int par6,
            EntityLiving par7EntityLiving) {
        return true;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @SideOnly(Side.CLIENT)
    /**
     * allows items to add custom lines of information to the mouseover description
     */
    public void addInformation(ItemStack par1ItemStack,
            EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        par3List.add(Strings.FAMODTREEAXE_DISNAME_LINE2);

    }

    public String getItemDisplayName(ItemStack par1ItemStack) {
        return ("" + StringTranslate.getInstance().translateNamedKey(
                this.getLocalizedName(par1ItemStack))).trim();
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack) {
        return par1ItemStack.isItemEnchanted();
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister myIcon) {
        itemIcon = myIcon.registerIcon(Reference.MOD_ID.toLowerCase() + ":"
                + this.getUnlocalizedName().toLowerCase());
    }
}
