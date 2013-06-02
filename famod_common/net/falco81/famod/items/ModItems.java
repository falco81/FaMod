package net.falco81.famod.items;

import net.falco81.famod.lib.Itemids;
import net.falco81.famod.lib.Materials;
import net.falco81.famod.lib.Strings;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModItems {
    public static Sickle FaModSickleWooden, FaModSickleStone, FaModSickleIron, FaModSickleGolden, FaModSickleDiamond;
    public static TreeAxe FaModTreeAxe;
    public static ManganIngot FaModManganIngot;
    public static PickAxe FaModManganPickAxe;
    public static Axe FaModManganAxe;
    public static Sword FaModManganSword;
    public static ShockCoal FaModShockCoal;
    public static ManganDust FaModManganDust;

    public static void init() {

        FaModSickleWooden = new Sickle(Itemids.FAMODSICKLEWOODEN, EnumToolMaterial.WOOD);
        FaModSickleStone = new Sickle(Itemids.FAMODSICKLESTONE, EnumToolMaterial.STONE);
        FaModSickleIron = new Sickle(Itemids.FAMODSICKLEIRON, EnumToolMaterial.IRON);
        FaModSickleGolden = new Sickle(Itemids.FAMODSICKLEGOLDEN, EnumToolMaterial.GOLD);
        FaModSickleDiamond = new Sickle(Itemids.FAMODSICKLEDIAMOND, EnumToolMaterial.EMERALD);
        
        GameRegistry.registerItem(FaModSickleWooden, Strings.FAMODSICKLEWOODEN_NAME);
        LanguageRegistry.addName(new ItemStack(FaModSickleWooden, 1), Strings.FAMODSICKLEWOODEN_DISNAME);

        GameRegistry.registerItem(FaModSickleStone, Strings.FAMODSICKLESTONE_NAME);
        LanguageRegistry.addName(new ItemStack(FaModSickleStone, 1), Strings.FAMODSICKLESTONE_DISNAME);
        
        GameRegistry.registerItem(FaModSickleIron, Strings.FAMODSICKLEIRON_NAME);
        LanguageRegistry.addName(new ItemStack(FaModSickleIron, 1), Strings.FAMODSICKLEIRON_DISNAME);
                
        GameRegistry.registerItem(FaModSickleGolden, Strings.FAMODSICKLEGOLDEN_NAME);
        LanguageRegistry.addName(new ItemStack(FaModSickleGolden, 1), Strings.FAMODSICKLEGOLDEN_DISNAME);
        
        GameRegistry.registerItem(FaModSickleDiamond, Strings.FAMODSICKLEDIAMOND_NAME);
        LanguageRegistry.addName(new ItemStack(FaModSickleDiamond, 1), Strings.FAMODSICKLEDIAMOND_DISNAME);
        
        
        FaModTreeAxe = new TreeAxe(Itemids.FAMODTREEAXE, EnumToolMaterial.EMERALD);
        
        GameRegistry.registerItem(FaModTreeAxe, Strings.FAMODTREEAXE_NAME);
        LanguageRegistry.addName(new ItemStack(FaModTreeAxe, 1), Strings.FAMODTREEAXE_DISNAME);
        
        FaModManganIngot = new ManganIngot(Itemids.FAMODMANGANINGOT);
        FaModManganDust = new ManganDust(Itemids.FAMODMANGANDUST);
        
        GameRegistry.registerItem(FaModManganIngot, Strings.FAMODMANGANINGOT_NAME);
        LanguageRegistry.addName(new ItemStack(FaModManganIngot, 1), Strings.FAMODMANGANINGOT_DISNAME);
        GameRegistry.registerItem(FaModManganDust, Strings.FAMODMANGANDUST_NAME);
        LanguageRegistry.addName(new ItemStack(FaModManganDust, 1), Strings.FAMODMANGANDUST_DISNAME);
                
        FaModManganPickAxe = new PickAxe(Itemids.FAMODMANGANPICKAXE, Materials.MANGAN);
        
        GameRegistry.registerItem(FaModManganPickAxe, Strings.FAMODMANGANPICKAXE_NAME);
        LanguageRegistry.addName(new ItemStack(FaModManganPickAxe, 1), Strings.FAMODMANGANPICKAXE_DISNAME);
                
        FaModManganAxe = new Axe(Itemids.FAMODMANGANAXE, Materials.MANGAN);
        
        GameRegistry.registerItem(FaModManganAxe, Strings.FAMODMANGANAXE_NAME);
        LanguageRegistry.addName(new ItemStack(FaModManganAxe, 1), Strings.FAMODMANGANAXE_DISNAME);
                
        FaModManganSword = new Sword(Itemids.FAMODMANGANSWORD, Materials.MANGAN);
        
        GameRegistry.registerItem(FaModManganSword, Strings.FAMODMANGANSWORD_NAME);
        LanguageRegistry.addName(new ItemStack(FaModManganSword, 1), Strings.FAMODMANGANSWORD_DISNAME);
                
        FaModShockCoal = new ShockCoal(Itemids.FAMODSHOCKCOAL);
        
        GameRegistry.registerItem(FaModShockCoal, Strings.FAMODSHOCKCOAL_NAME);
        LanguageRegistry.addName(new ItemStack(FaModShockCoal, 1), Strings.FAMODSHOCKCOAL_DISNAME);
        
              

    }
}
