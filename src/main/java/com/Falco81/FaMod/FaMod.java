package com.Falco81.FaMod;





import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.Falco81.FaMod.init.CreativeTab;
import com.Falco81.FaMod.init.ModBlocks;
import com.Falco81.FaMod.init.ModEntity;
import com.Falco81.FaMod.init.ModItems;
import com.Falco81.FaMod.init.ModRecipes;
import com.Falco81.FaMod.init.OreDictionary;
import com.Falco81.FaMod.init.WorldGen;
import com.Falco81.FaMod.proxy.CommonProxy;
import com.Falco81.FaMod.utils.FurnaceFuelBurnTimeEventHandler;
import com.Falco81.FaMod.utils.Materials;
import com.Falco81.FaMod.utils.ModChecker;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;
 

@Mod(modid = FaMod.modId, name = FaMod.name, version = FaMod.version, acceptedMinecraftVersions = FaMod.accepted_versions)
public class FaMod {

	public static final String modId = "famod";
	public static final String name = "FaMod";
	public static final String version = "1.0.0";
	public static final String accepted_versions = "[1.12.2]";
	public static final CreativeTab creativeTab = new CreativeTab();
//	public static final Item.ToolMaterial manganToolMaterial = EnumHelper.addToolMaterial("MANGAN", 3, 1561, 8, 3, 22);
//	public static final Item.ToolMaterial smeltingeyeMaterial = EnumHelper.addToolMaterial("SMELTINGEYE", 0, 59, 1, 0, 0);
	public static final Logger logger = LogManager.getFormatterLogger(modId);
		
	@Mod.Instance(modId)
	public static FaMod instance;
	

	@SidedProxy(serverSide = "com.Falco81.FaMod.proxy.CommonProxy", clientSide = "com.Falco81.FaMod.proxy.ClientProxy")
	public static CommonProxy proxy;
	public static ModChecker modchecker;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println(name + " is loading!");
		GameRegistry.registerWorldGenerator(new WorldGen(), 3);
		modchecker = new ModChecker();
		modchecker.prinSuccessMessage();
		Materials.registerMaterials();
		ModEntity.register();
		MinecraftForge.EVENT_BUS.register(FurnaceFuelBurnTimeEventHandler.instance);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		ModRecipes.init();
		OreDictionary.init();
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
	
	@Mod.EventBusSubscriber
	public static class RegistrationHandler {
		@SubscribeEvent
		public static void registerItems(RegistryEvent.Register<Item> event) {
			ModItems.register(event.getRegistry());
			ModBlocks.registerItemBlocks(event.getRegistry());
		}
		@SubscribeEvent
		public static void registerItems(ModelRegistryEvent event) {
			ModItems.registerModels();
			ModBlocks.registerModels();
		}
		@SubscribeEvent
		public static void registerBlocks(RegistryEvent.Register<Block> event) {
			ModBlocks.register(event.getRegistry());
		}
		}
}