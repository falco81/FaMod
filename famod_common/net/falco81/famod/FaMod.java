package net.falco81.famod;

import java.io.File;

import net.falco81.famod.bolcks.ModBlocks;
import net.falco81.famod.configuration.ConfigurationSettings;
import net.falco81.famod.creativetab.CreativeTabFaMod;
import net.falco81.famod.items.ModItems;
import net.falco81.famod.lib.Reference;
import net.falco81.famod.worldgen.WorldGenerator;
import net.falco81.famond.recipes.Recipes;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.EnumHelper;

@Mod ( modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION )
@NetworkMod ( clientSideRequired = true, serverSideRequired = false )

public class FaMod {
    @Instance("FaMod")
    public static FaMod instance;
    
   // @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
   // public static CommonProxy proxy;
    
    public static CreativeTabs tabsFaMod = new CreativeTabFaMod(CreativeTabs.getNextID(), Reference.MOD_ID);
    
    public static EnumToolMaterial MANGAN = EnumHelper.addToolMaterial("MANGAN", 3, 1556, 12.0F, 4, 22);
    
     
    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        ConfigurationSettings.init(new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + Reference.CHANNEL_NAME + File.separator + Reference.MOD_ID + ".cfg"));
        ModBlocks.init();
        ModItems.init();
        Recipes.initRecipes();
       
    }
    @Init
    public void init(FMLInitializationEvent event) {   
        
        GameRegistry.registerWorldGenerator(new WorldGenerator());
        
    }
    @PostInit
    public void postInit(FMLPostInitializationEvent event) {
        
    }
}
