package net.falco81.famod.bolcks;

import net.falco81.famod.lib.Blockids;
import net.falco81.famod.lib.Strings;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModBlocks {

    public static Block FaModSand;
    public static Block FaModBedrock;
    public static Block FaModMangan;
    public static Block FaModManganBlock;
    
    public static void init() {

        FaModSand = new Sand(Blockids.FAMODSAND);
        FaModBedrock = new Bedrock(Blockids.FAMODBEDROCK);
        FaModMangan = new Mangan(Blockids.FAMODMANGAN);
        FaModManganBlock = new ManganBlock(Blockids.FAMODMANGANBLOCK);
        
        LanguageRegistry.addName(FaModSand, Strings.FAMODSAND_DISNAME);
        GameRegistry.registerBlock(FaModSand, Strings.FAMODSAND_NAME);

        LanguageRegistry.addName(FaModBedrock, Strings.FAMODBEDROCK_DISNAME);
        GameRegistry.registerBlock(FaModBedrock, Strings.FAMODBEDROCK_NAME);
      
        LanguageRegistry.addName(FaModMangan, Strings.FAMODMANGAN_DISNAME);
        GameRegistry.registerBlock(FaModMangan, Strings.FAMODMANGAN_NAME);
        
        LanguageRegistry.addName(FaModManganBlock, Strings.FAMODMANGANBLOCK_DISNAME);
        GameRegistry.registerBlock(FaModManganBlock, Strings.FAMODMANGANBLOCK_NAME);
      
      
    }

}
