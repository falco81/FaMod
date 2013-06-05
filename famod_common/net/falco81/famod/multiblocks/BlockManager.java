package net.falco81.famod.multiblocks;

import net.falco81.famod.lib.Multiblocks;
import net.falco81.famod.lib.Strings;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class BlockManager {
    public static Block ShockFurnaceCore = null;
    public static Block ShockFurnaceDummy = null;

    public static void registerBlocks() {
        ShockFurnaceCore = new BlockShockFurnaceCore(
                Multiblocks.BlockIDs.ShockFurnaceCore);
        ShockFurnaceDummy = new BlockShockFurnaceDummy(
                Multiblocks.BlockIDs.ShockFurnaceDummy);

        GameRegistry.registerBlock(ShockFurnaceCore, Strings.SHOCKFURNACECOREBLOCK_NAME);
        GameRegistry.registerBlock(ShockFurnaceDummy, Strings.SHOCKFURNACEDUMMYBLOCK_NAME);

        LanguageRegistry.addName(ShockFurnaceCore, Strings.SHOCKFURNACECOREBLOCK_DISNAME);
        LanguageRegistry.addName(ShockFurnaceDummy, Strings.SHOCKFURNACEDUMMYBLOCK_DISNAME);
    }

    public static void registerCraftingRecipes() {
     //   CraftingManager.getInstance().addRecipe(new ItemStack(ShockFurnaceCore, 1), "XXX", "X X", "XXX", 'X', Block.brick);
    }
}
