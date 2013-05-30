package net.falco81.famod.items;

import net.falco81.famod.FaMod;
import net.falco81.famod.lib.Itemids;
import net.falco81.famod.lib.Strings;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModItems {
    public static Sickle FaModSickleWooden, FaModSickleStone, FaModSickleIron, FaModSickleGolden, FaModSickleEmerald;
    public static TreeAxe FaModTreeAxe;
    public static ManganIngot FaModManganIngot;
    public static PickAxe FaModManganPickAxe;

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
        
        FaModManganIngot = new ManganIngot(Itemids.FAMODMANGANINGOT);
        
        LanguageRegistry.addName(new ItemStack(FaModManganIngot, 1), Strings.FAMODMANGANINGOT_DISNAME);
        GameRegistry.registerItem(FaModManganIngot, Strings.FAMODMANGANINGOT_NAME);
        
        FaModManganPickAxe = new PickAxe(Itemids.FAMODMANGANPICKAXE, FaMod.MANGAN);
        
        LanguageRegistry.addName(new ItemStack(FaModManganPickAxe, 1), Strings.FAMODMANGANPICKAXE_DISNAME);
        GameRegistry.registerItem(FaModManganPickAxe, Strings.FAMODMANGANPICKAXE_NAME);
              

    }
}
