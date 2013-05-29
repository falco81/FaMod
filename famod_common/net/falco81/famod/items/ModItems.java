package net.falco81.famod.items;

import net.falco81.famod.lib.Itemids;
import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModItems {
    public static Sickle FaModSickleWooden, FaModSickleStone, FaModSickleIron, FaModSickleGolden, FaModSickleEmerald;

    public static void init() {

        FaModSickleWooden = new Sickle(Itemids.FAMODSICKLEWOODEN, EnumToolMaterial.WOOD);
        FaModSickleStone = new Sickle(Itemids.FAMODSICKLESTONE, EnumToolMaterial.STONE);
        FaModSickleIron = new Sickle(Itemids.FAMODSICKLEIRON, EnumToolMaterial.IRON);
        FaModSickleGolden = new Sickle(Itemids.FAMODSICKLEGOLDEN, EnumToolMaterial.GOLD);
        FaModSickleEmerald = new Sickle(Itemids.FAMODSICKLEEMERALD, EnumToolMaterial.EMERALD);

        LanguageRegistry.addName(new ItemStack(FaModSickleWooden, 1), "FaModSickleWooden");
        GameRegistry.registerItem(FaModSickleWooden, "FaModSickleWooden");
        
        LanguageRegistry.addName(new ItemStack(FaModSickleStone, 1), "FaModSickleStone");
        GameRegistry.registerItem(FaModSickleStone, "FaModSickleStone");
        
        LanguageRegistry.addName(new ItemStack(FaModSickleIron, 1), "FaModSickleIron");
        GameRegistry.registerItem(FaModSickleIron, "FaModSickleIron");
        
        LanguageRegistry.addName(new ItemStack(FaModSickleGolden, 1), "FaModSickleGolden");
        GameRegistry.registerItem(FaModSickleGolden, "FaModSickleGolden");
        
        LanguageRegistry.addName(new ItemStack(FaModSickleEmerald, 1), "FaModSickleEmerald");
        GameRegistry.registerItem(FaModSickleEmerald, "FaModSickleEmerald");
        
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
                new Object[] { " # ", "  #", "I# ", Character.valueOf('#'), Item.diamond,
                        Character.valueOf('I'), Item.stick });
        

       
    }
}
