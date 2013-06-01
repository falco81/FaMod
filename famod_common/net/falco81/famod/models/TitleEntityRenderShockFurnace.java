package net.falco81.famod.models;

import net.falco81.famod.lib.FaModTileEntity;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class TitleEntityRenderShockFurnace extends TileEntitySpecialRenderer {
    private ModelShockFurnace modelShockFurnace = new ModelShockFurnace();

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick)
    {
        modelShockFurnace.render((FaModTileEntity)tileEntity, x, y, z);
    }

}
