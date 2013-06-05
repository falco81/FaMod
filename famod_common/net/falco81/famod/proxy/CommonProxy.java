package net.falco81.famod.proxy;

import net.falco81.famod.tileentity.ContainerShockFurnace;
import net.falco81.famod.tileentity.TileEntityShockFurnaceCore;
import net.falco81.famod.tileentity.TileEntityShockFurnaceDummy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy  implements IGuiHandler {
    public void registerTileEntities()
    {
        GameRegistry.registerTileEntity(TileEntityShockFurnaceCore.class, "tileEntityShockFurnaceCore");
        GameRegistry.registerTileEntity(TileEntityShockFurnaceDummy.class, "tileEntityShockFurnaceDummy");
    }
    
    @Override
    public Object getServerGuiElement(int guiID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntityShockFurnaceCore tileEntity = (TileEntityShockFurnaceCore)world.getBlockTileEntity(x, y, z);
        if(tileEntity != null)
            return new ContainerShockFurnace(player.inventory, tileEntity);
        
        return null;
    }
    
    @Override
    public Object getClientGuiElement(int guiID, EntityPlayer player, World world, int x, int y, int z)
    {
        return null;
    }    
   

}
