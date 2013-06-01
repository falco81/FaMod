package net.falco81.famod.items;

import net.falco81.famod.FaMod;
import net.falco81.famod.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PickAxe extends ItemPickaxe {
    public PickAxe(int itemId, EnumToolMaterial material) {
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
        if (block == Block.obsidian) {
            return 200F;
        }
        return 12.0F;
    }

    @Override
    public boolean canHarvestBlock(Block par1Block) {
        return par1Block == Block.obsidian ? this.toolMaterial
                .getHarvestLevel() >= 3
                : (par1Block != Block.blockDiamond
                        && par1Block != Block.oreDiamond ? (par1Block != Block.oreEmerald
                        && par1Block != Block.blockEmerald ? (par1Block != Block.blockGold
                        && par1Block != Block.oreGold ? (par1Block != Block.blockIron
                        && par1Block != Block.oreIron ? (par1Block != Block.blockLapis
                        && par1Block != Block.oreLapis ? (par1Block != Block.oreRedstone
                        && par1Block != Block.oreRedstoneGlowing ? (par1Block.blockMaterial == Material.rock ? true
                        : (par1Block.blockMaterial == Material.iron ? true
                                : par1Block.blockMaterial == Material.anvil))
                        : this.toolMaterial.getHarvestLevel() >= 2)
                        : this.toolMaterial.getHarvestLevel() >= 1)
                        : this.toolMaterial.getHarvestLevel() >= 1)
                        : this.toolMaterial.getHarvestLevel() >= 2)
                        : this.toolMaterial.getHarvestLevel() >= 2)
                        : this.toolMaterial.getHarvestLevel() >= 2);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister myIcon) {
        itemIcon = myIcon.registerIcon(Reference.MOD_ID.toLowerCase() + ":"
                + this.getUnlocalizedName().toLowerCase());
    }
}
