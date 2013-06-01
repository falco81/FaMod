package net.falco81.famod.proxy;

import net.falco81.famod.lib.Blockids;
import net.falco81.famod.lib.FaModTileEntity;
import net.falco81.famod.models.ItemRenderShockFurnace;
import net.falco81.famod.models.TitleEntityRenderShockFurnace;


import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ClientProxy extends CommonProxy {
    
    @Override
    public void InitRendering() {
        
        
        GameRegistry.registerTileEntity(FaModTileEntity.class, "FaModTileEntity");
        ClientRegistry.bindTileEntitySpecialRenderer(FaModTileEntity.class, new TitleEntityRenderShockFurnace());
        MinecraftForgeClient.registerItemRenderer(Blockids.FAMODSHOCKFURNACE, new ItemRenderShockFurnace() );

        
    }


}
