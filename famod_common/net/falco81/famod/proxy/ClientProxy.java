package net.falco81.famod.proxy;

import net.falco81.famod.multiblocks.GuiShockFurnace;
import net.falco81.famod.tileentity.TileEntityShockFurnaceCore;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ClientProxy extends CommonProxy {
    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world,
            int x, int y, int z) {
        TileEntityShockFurnaceCore tileEntity = (TileEntityShockFurnaceCore) world
                .getBlockTileEntity(x, y, z);

        if (tileEntity != null)
            return new GuiShockFurnace(player.inventory, tileEntity);

        return null;
    }

}
