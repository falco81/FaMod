package net.falco81.famod.bolcks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.falco81.famod.lib.Blockids;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class ModBlocks {

    public static Block FaModSand;
    public static Block FaModBedrock;
    
    public static void init() {

        FaModSand = new Sand(Blockids.FAMODSAND);
        FaModBedrock = new Bedrock(Blockids.FAMODBEDROCK);
        
        LanguageRegistry.addName(FaModSand, "FaModSand");
        GameRegistry.registerBlock(FaModSand, "FaModSand");

        LanguageRegistry.addName(FaModBedrock, "FaModBedrock");
        GameRegistry.registerBlock(FaModBedrock, "FaModBedrock");
      
        initBlockRecipes();

    }

    private static void initBlockRecipes() {

        GameRegistry.addRecipe(new ItemStack(FaModBedrock), new Object[] { "ii", "ii", Character.valueOf('i'), FaModSand });
//        FurnaceRecipes.smelting().addSmelting(Sand., Metadata.TIN,ModItems.ingotTin, 0.5F);
       
    }

}
