package net.falco81.famod.bolcks;

import net.falco81.famod.lib.Blockids;
import net.falco81.famod.lib.Strings;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModBlocks {

    public static Block FaModManganOre;
    public static Block FaModManganBlock;
    public static Block FaModShockFurnace;
    
    public static void init() {

        FaModManganOre = new ManganOre(Blockids.FAMODMANGANORE);
        FaModManganBlock = new ManganBlock(Blockids.FAMODMANGANBLOCK);
        
        FaModShockFurnace = new ShockFurnaceBlock(Blockids.FAMODSHOCKFURNACE);
        
            
        LanguageRegistry.addName(FaModManganOre, Strings.FAMODMANGANORE_DISNAME);
        GameRegistry.registerBlock(FaModManganOre, Strings.FAMODMANGANORE_NAME);
        
        LanguageRegistry.addName(FaModManganBlock, Strings.FAMODMANGANBLOCK_DISNAME);
        GameRegistry.registerBlock(FaModManganBlock, Strings.FAMODMANGANBLOCK_NAME);
      
        LanguageRegistry.addName(FaModShockFurnace, Strings.FAMODSHOCKFURNACE_DISNAME);
        GameRegistry.registerBlock(FaModShockFurnace, Strings.FAMODSHOCKFURNACE_NAME);
      
    }

}
