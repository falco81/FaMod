package net.falco81.famod.items;

import net.falco81.famod.lib.Itemids;
import net.falco81.famod.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModItems {
    public static Sickle FaModSickleWooden, FaModSickleStone, FaModSickleIron, FaModSickleGolden, FaModSickleEmerald;
    public static TreeAxe FaModTreeAxe;

    public static void init() {

        FaModSickleWooden = new Sickle(Itemids.FAMODSICKLEWOODEN, EnumToolMaterial.WOOD);
        FaModSickleStone = new Sickle(Itemids.FAMODSICKLESTONE, EnumToolMaterial.STONE);
        FaModSickleIron = new Sickle(Itemids.FAMODSICKLEIRON, EnumToolMaterial.IRON);
        FaModSickleGolden = new Sickle(Itemids.FAMODSICKLEGOLDEN, EnumToolMaterial.GOLD);
        FaModSickleEmerald = new Sickle(Itemids.FAMODSICKLEEMERALD, EnumToolMaterial.EMERALD);

        LanguageRegistry.addName(new ItemStack(FaModSickleWooden, 1), Strings.FAMODSICKLEWOODEN_DISNAME);
        GameRegistry.registerItem(FaModSickleWooden, Strings.FAMODSICKLEWOODEN_NAME);
        
        LanguageRegistry.addName(new ItemStack(FaModSickleStone, 1), Strings.FAMODSICKLESTONE_DISNAME);
        GameRegistry.registerItem(FaModSickleStone, Strings.FAMODSICKLESTONE_NAME);
        
        LanguageRegistry.addName(new ItemStack(FaModSickleIron, 1), Strings.FAMODSICKLEIRON_DISNAME);
        GameRegistry.registerItem(FaModSickleIron, Strings.FAMODSICKLEIRON_NAME);
        
        LanguageRegistry.addName(new ItemStack(FaModSickleGolden, 1), Strings.FAMODSICKLEGOLDEN_DISNAME);
        GameRegistry.registerItem(FaModSickleGolden, Strings.FAMODSICKLEGOLDEN_NAME);
        
        LanguageRegistry.addName(new ItemStack(FaModSickleEmerald, 1), Strings.FAMODSICKLEEMERALD_DISNAME);
        GameRegistry.registerItem(FaModSickleEmerald, Strings.FAMODSICKLEEMERALD_NAME);
        
        
        FaModTreeAxe = new TreeAxe(Itemids.FAMODTREEAXE, EnumToolMaterial.EMERALD);
        
        LanguageRegistry.addName(new ItemStack(FaModTreeAxe, 1), Strings.FAMODTREEAXE_DISNAME);
        GameRegistry.registerItem(FaModTreeAxe, Strings.FAMODTREEAXE_NAME);
        
        initItemRecipes();

    }
    
    private static void initItemRecipes() {

        GameRegistry.addRecipe(new ItemStack(FaModSickleWooden),
                new Object[] { " # ", "  #", "I# ", Character.valueOf('#'), Block.planks,
                        Character.valueOf('I'), Item.stick });
        GameRegistry.addRecipe(new ItemStack(FaModSickleStone),
                new Object[] { " # ", "  #", "I# ", Character.valueOf('#'),
                        Block.cobblestone, Character.valueOf('I'), Item.stick });
        GameRegistry.addRecipe(new ItemStack(FaModSickleIron),
                new Object[] { " # ", "  #", "I# ", Character.valueOf('#'),
                        Item.ingotIron, Character.valueOf('I'), Item.stick });
        GameRegistry.addRecipe(new ItemStack(FaModSickleGolden),
                new Object[] { " # ", "  #", "I# ", Character.valueOf('#'),
                        Item.ingotGold, Character.valueOf('I'), Item.stick });
        GameRegistry.addRecipe(new ItemStack(FaModSickleEmerald),
                new Object[] { " # ", "  #", "I# ", Character.valueOf('#'), Item.emerald,
                        Character.valueOf('I'), Item.stick });
        
        GameRegistry.addRecipe(new ItemStack(FaModTreeAxe),
                new Object[] { "## ", "#I ", " I ", Character.valueOf('#'), Item.emerald,
                        Character.valueOf('I'), Item.stick });

       
    }
}
