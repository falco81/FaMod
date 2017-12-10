package com.Falco81.FaMod.utils;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class Materials {
	public static Item.ToolMaterial manganToolMaterial;
	public static Item.ToolMaterial smeltingeyeMaterial;
		
	public static void registerMaterials() {
		
		// Mangan material
		final int mangan_harvestLevel = 3 ;
		final int mangan_durability = 1561 ;
		final float mangan_miningSpeed = 8.0F ;
		final float mangan_damageVsEntities = 3.0F ;
		final int mangan_enchantability = 22 ;
		manganToolMaterial = EnumHelper.addToolMaterial("MANGAN", mangan_harvestLevel, mangan_durability, mangan_miningSpeed, mangan_damageVsEntities, mangan_enchantability);

		// SmeltingEye material
		final int smeltingeye_harvestLevel = 0 ;
		final int smeltingeye_durability = 64 ;
		final float smeltingeye_miningSpeed = 0.0F ;
		final float smeltingeye_damageVsEntities = 0.0F ;
		final int smeltingeye_enchantability = 0 ;
		smeltingeyeMaterial = EnumHelper.addToolMaterial("SMELTINGEYE", smeltingeye_harvestLevel, smeltingeye_durability, smeltingeye_miningSpeed, smeltingeye_damageVsEntities, smeltingeye_enchantability);
		
	}
}
