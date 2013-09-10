package net.falco81.famod;

import java.io.File;

import net.falco81.famod.bolcks.ModBlocks;
import net.falco81.famod.configuration.ConfigurationSettings;
import net.falco81.famod.creativetab.CreativeTabFaMod;
import net.falco81.famod.items.ModItems;
import net.falco81.famod.lib.Reference;
import net.falco81.famod.multiblocks.BlockManager;
import net.falco81.famod.proxy.CommonProxy;
import net.falco81.famod.recipes.CraftingRecipes;
import net.falco81.famod.recipes.FuelHandler;
import net.falco81.famod.recipes.IC2;
import net.falco81.famod.recipes.SmeltingRecipes;
import net.falco81.famod.recipes.ThermalExpansion;
import net.falco81.famod.villager.FaModVillager;
import net.falco81.famod.worldgen.WorldGenerator;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@SuppressWarnings("deprecation")
@Mod ( modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION )
@NetworkMod ( clientSideRequired = true, serverSideRequired = false )

public class FaMod {
    @Instance("FaMod")
    public static FaMod instance;
    
   @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
   public static CommonProxy proxy;
    
    public static CreativeTabs tabsFaMod = new CreativeTabFaMod(CreativeTabs.getNextID(), Reference.MOD_ID);
    
       
     
    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        ConfigurationSettings.init(new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + Reference.CHANNEL_NAME + File.separator + Reference.MOD_ID + ".cfg"));
        
        BlockManager.registerBlocks();
        ModBlocks.init();
        ModItems.init();
        CraftingRecipes.initRecipes();
        SmeltingRecipes.initRecipes();
        FaModVillager.init();
        GameRegistry.registerFuelHandler(new FuelHandler());
       
    }
    @Init
    public void init(FMLInitializationEvent event) {   
        
        GameRegistry.registerWorldGenerator(new WorldGenerator());
        
              
        proxy.registerTileEntities();       
        LanguageRegistry.instance().addStringLocalization("multifurnace.container.multifurnace", "Shock-Furnace");
        
        NetworkRegistry.instance().registerGuiHandler(this, proxy);
        
        
        
    }
    @PostInit
    public void postInit(FMLPostInitializationEvent event) {
        ThermalExpansion.initRecipes();
        IC2.initRecipes();
    }
}
