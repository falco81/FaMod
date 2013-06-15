package net.falco81.famod.items;

import java.util.List;

import net.falco81.famod.FaMod;
import net.falco81.famod.lib.Reference;
import net.falco81.famod.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SmeltingEye extends ItemTool {
    private static Block[] blocksEffectiveAgainst = new Block[] { Block.cobblestone };

    public SmeltingEye(int itemId, EnumToolMaterial material) {
        super(itemId, 1, material, blocksEffectiveAgainst);

        maxStackSize = 64;
        setCreativeTab(FaMod.tabsFaMod);
        if (material.name() == "REFINEDMANGAN") {
            setUnlocalizedName("refinedmangansmeltingeye");
        } else {
            setUnlocalizedName("unknownsmeltingeye");
        }

    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack,
            EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        par3List.add(Strings.FAMODSMELTINGEYE_DISNAME_LINE2);
    }

    @Override
    public boolean onItemUse(ItemStack par1ItemStack,
            EntityPlayer par2EntityPlayer, World par3World, int x, int y,
            int z, int par7, float par8, float par9, float par10) {
        int itemID = par3World.getBlockId(x, y, z);

        if (itemID == Block.cobblestone.blockID) {

            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                    for (int k = z - 1; k <= z + 1; k++) {
                        itemID = par3World.getBlockId(i, j, k);
                        if (itemID == Block.cobblestone.blockID) {
                            par3World.setBlock(i, j, k, Block.stone.blockID);
                            par1ItemStack.damageItem(1, par2EntityPlayer);
                        }
                    }
                }

            }
            FMLClientHandler.instance().getClient().sndManager.playSoundFX("random.click", 1.0F, 1.0F);
            return true;
        }

        else {
            return false;
        }

    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister myIcon) {
        itemIcon = myIcon.registerIcon(Reference.MOD_ID.toLowerCase() + ":"
                + this.getUnlocalizedName().toLowerCase());
    }
}
