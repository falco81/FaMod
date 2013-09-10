package net.falco81.famod.villager;

import java.util.Random;

import net.falco81.famod.items.ModItems;
import net.falco81.famod.lib.Reference;
import net.falco81.famod.lib.Villagers;
import net.falco81.famod.multiblocks.BlockManager;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;

public class FaModVillager implements IVillageTradeHandler {
    @SuppressWarnings("unchecked")
    public void manipulateTradesForVillager(EntityVillager villager,
            MerchantRecipeList recipes, Random random) {
        // Trade 4 emeralds and 3 apples for a diamond axe
        recipes.add(new MerchantRecipe(new ItemStack(Item.emerald, 10),
                new ItemStack(ModItems.FaModManganRefinedIngot, 1, 0)));
        recipes.add(new MerchantRecipe(new ItemStack(Item.emerald, 64),
                new ItemStack(BlockManager.ShockFurnaceCore, 1, 0)));
    }

    @SuppressWarnings("static-access")
    public static void init() {
           
        VillagerRegistry.instance().registerVillagerId(Villagers.FAMODVILLAGER);
        VillagerRegistry.instance().registerVillagerSkin(Villagers.FAMODVILLAGER, new ResourceLocation(Reference.MOD_ID.toLowerCase() + ":" +"/mobs/villager.png"));
            
        FaModVillager FaModmyVillager = new FaModVillager();
        VillagerRegistry.instance().registerVillageTradeHandler(Villagers.FAMODVILLAGER, FaModmyVillager);
        
        VillagerRegistry.instance().getRegisteredVillagers();
    }
}
