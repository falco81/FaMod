package net.falco81.famod.bolcks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.falco81.famod.lib.Blockids;
import net.falco81.famod.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class ModBlocks {

    public static Block FaModSand;
    public static Block FaModBedrock;
    
    public static void init() {

        FaModSand = new Sand(Blockids.FAMODSAND);
        FaModBedrock = new Bedrock(Blockids.FAMODBEDROCK);
        
        LanguageRegistry.addName(FaModSand, Strings.FAMODSAND_NAME);
        GameRegistry.registerBlock(FaModSand, Strings.FAMODSAND_NAME);

        LanguageRegistry.addName(FaModBedrock, Strings.FAMODBEDROCK_NAME);
        GameRegistry.registerBlock(FaModBedrock, Strings.FAMODBEDROCK_NAME);
      
        initBlockRecipes();

    }

    private static void initBlockRecipes() {

        GameRegistry.addRecipe(new ItemStack(FaModBedrock), new Object[] { "ii", "ii", Character.valueOf('i'), FaModSand });
        GameRegistry.addRecipe(new ItemStack(FaModSand, 4), new Object[] { "i", Character.valueOf('i'), FaModBedrock });

        FurnaceRecipes.smelting().addSmelting(FaModSand.blockID ,0, new ItemStack(FaModBedrock), 0.5F);
       
    }

}
