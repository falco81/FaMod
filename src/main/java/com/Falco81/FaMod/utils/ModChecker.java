package com.Falco81.FaMod.utils;

import com.Falco81.FaMod.FaMod;

import net.minecraftforge.fml.common.Loader;

public class ModChecker {
	
	public static boolean isThermalExpansionLoaded; 

	public ModChecker() {
		this.isThermalExpansionLoaded = Loader.isModLoaded("thermalexpansion");
	}
	
	public static void prinSuccessMessage() {
		if(isThermalExpansionLoaded) {
			FaMod.logger.info("ThermalExpansion has been discovered...");
		}
		else {
			FaMod.logger.info("ThermalExpansion has not been discovered...");
		}
	}
}
