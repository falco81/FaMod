package net.falco81.famod.proxy;

import net.falco81.famod.lib.FaModTileEntity;
import net.falco81.famod.models.ItemRenderTuBox;
import net.falco81.famod.models.TitleEntityRenderTuBox;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ClientProxy extends CommonProxy {
    
    @Override
    public void InitRendering() {
        
        
        GameRegistry.registerTileEntity(FaModTileEntity.class, "FaModTileEntity");
        ClientRegistry.bindTileEntitySpecialRenderer(FaModTileEntity.class, new TitleEntityRenderTuBox());
        MinecraftForgeClient.registerItemRenderer(510, new ItemRenderTuBox() );

        
    }


}
