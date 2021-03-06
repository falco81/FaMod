package com.Falco81.FaMod.utils;

import com.Falco81.FaMod.init.ModBlocks;
import com.Falco81.FaMod.init.ModItems;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FurnaceFuelBurnTimeEventHandler {
	 public static final FurnaceFuelBurnTimeEventHandler instance = new FurnaceFuelBurnTimeEventHandler();

	  private FurnaceFuelBurnTimeEventHandler() {};

	  // Called whenever fuel is added into a furnace
	  // Allows us to check whether the item added into the fuel slot is burnable.  If it is Wheat, burn it.
	  @SubscribeEvent
	  public void onFurnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event)
	  {
	    ItemStack fuel = event.getItemStack();
	    final int BURN_TIME_SECONDS = 5;
	    final int TICKS_PER_SECOND = 20;
	    final int BLOCK_FORM = 9;
	    final int SHOCKCOAL_BOOSTER = 10;
	    if (fuel.getItem() == ModItems.coalShock) {
	    	event.setBurnTime(BURN_TIME_SECONDS * TICKS_PER_SECOND * SHOCKCOAL_BOOSTER);
	    }
	    if (fuel.getItem() == Item.getItemFromBlock(ModBlocks.blockShockCoal)) {
		    event.setBurnTime(BURN_TIME_SECONDS * TICKS_PER_SECOND * BLOCK_FORM * SHOCKCOAL_BOOSTER);
		    }
	  }
}
