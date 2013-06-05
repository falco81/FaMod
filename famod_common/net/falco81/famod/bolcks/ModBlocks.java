package net.falco81.famod.bolcks;

import net.falco81.famod.lib.Blockids;
import net.falco81.famod.lib.Metadata;
import net.falco81.famod.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModBlocks {

    public static Block FaModManganOre;
    public static Block FaModManganBlock;
    public static Block FaModShockCoalOre;
    public static Block FaModShockCoalBlock;
    public static Block FaModDecorBlock;

    public static ItemStack FaModMarble, FaModBasalt, FaModMarbleBrick,
            FaModBasaltCobble, FaModBasaltBrick, FaModBasaltChiseled,
            FaModBasaltPaver;

    public static void init() {

        FaModManganOre = new ManganOre(Blockids.FAMODMANGANORE);
        FaModManganBlock = new ManganBlock(Blockids.FAMODMANGANBLOCK);
        
        FaModShockCoalOre = new ShockCoalOre(Blockids.FAMODSHOCKCOALORE);
        FaModShockCoalBlock = new ShockCoalBlock(Blockids.FAMODSHOCKCOALBLOCK);
        
                
                
            
        GameRegistry.registerBlock(FaModManganOre, Strings.FAMODMANGANORE_NAME);
        LanguageRegistry.addName(FaModManganOre, Strings.FAMODMANGANORE_DISNAME);
               
        GameRegistry.registerBlock(FaModManganBlock, Strings.FAMODMANGANBLOCK_NAME);
        LanguageRegistry.addName(FaModManganBlock, Strings.FAMODMANGANBLOCK_DISNAME);
      
       
        GameRegistry.registerBlock(FaModShockCoalOre, Strings.FAMODSHOCKCOALORE_NAME);
        LanguageRegistry.addName(FaModShockCoalOre, Strings.FAMODSHOCKCOALORE_DISNAME);
      
        GameRegistry.registerBlock(FaModShockCoalBlock, Strings.FAMODSHOCKCOALBLOCK_NAME);
        LanguageRegistry.addName(FaModShockCoalBlock, Strings.FAMODSHOCKCOALBLOCK_DISNAME);
        
        
        FaModDecorBlock= new DecorBlock(Blockids.FAMODDECORBLOCK);
        
        FaModMarble = new ItemStack(FaModDecorBlock, 1, Metadata.MARBLE);
        FaModBasalt = new ItemStack(FaModDecorBlock, 1, Metadata.BASALT);
        FaModMarbleBrick = new ItemStack(FaModDecorBlock, 1, Metadata.MARBLEBRICK);
        FaModBasaltCobble = new ItemStack(FaModDecorBlock, 1, Metadata.BASALTCOBBLE);
        FaModBasaltBrick = new ItemStack(FaModDecorBlock, 1, Metadata.BASALTBRICK);
        FaModBasaltChiseled = new ItemStack(FaModDecorBlock, 1, Metadata.BASALTCHISELED);
        FaModBasaltPaver = new ItemStack(FaModDecorBlock, 1, Metadata.BASALTPAVER);

        GameRegistry.registerBlock(FaModDecorBlock,ItemDecorBlock.class, Strings.FAMODDECORBLOCK_NAME);
                
        for (int i = 0; i < Strings.DECOR.length; i++) {
            LanguageRegistry.addName(new ItemStack(FaModDecorBlock, 1, i),
                    Strings.DECOR_NAMES[i]);
        }

                
        
    }
}
