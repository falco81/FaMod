package com.Falco81.FaMod.init;

import com.Falco81.FaMod.FaMod;
import com.Falco81.FaMod.MiniChest.GuiHandlerMiniChest;
import com.Falco81.FaMod.MiniChest.TileInventoryMiniChest;
import com.Falco81.FaMod.ShockFurnace.GuiHandlerShockFurnace;
import com.Falco81.FaMod.ShockFurnace.TileInventoryShockFurnace;
import com.Falco81.FaMod.utils.GuiHandlerRegistry;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModEntity {

	public static void register() {
		
		GameRegistry.registerTileEntity(TileInventoryShockFurnace.class, "famod_block_inventory_shockfurnace_tile_entity");
		GameRegistry.registerTileEntity(TileInventoryMiniChest.class, "famod_block_inventory_minichest_tile_entity");

		// You need to register a GUIHandler for the container.  However there can be only one handler per mod, so for the purposes
		//   of this project, we create a single GuiHandlerRegistry for all examples.
		// We register this GuiHandlerRegistry with the NetworkRegistry, and then tell the GuiHandlerRegistry about
		//   each example's GuiHandler, in this case GuiHandlerMBE31, so that when it gets a request from NetworkRegistry,
		//   it passes the request on to the correct example's GuiHandler.
		NetworkRegistry.INSTANCE.registerGuiHandler(FaMod.instance, GuiHandlerRegistry.getInstance());
		GuiHandlerRegistry.getInstance().registerGuiHandler(new GuiHandlerShockFurnace(), GuiHandlerShockFurnace.getGuiID());
		GuiHandlerRegistry.getInstance().registerGuiHandler(new GuiHandlerMiniChest(), GuiHandlerMiniChest.getGuiID());
		
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerModels() {
		//ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation("famod:mbe31_block_inventory_furnace", "inventory");
	   // final int DEFAULT_ITEM_SUBTYPE = 0;
	   // ModelLoader.setCustomModelResourceLocation(ModBlocks.blockShockFurnace, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);
	}
}
