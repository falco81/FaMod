package net.falco81.famod.models;

import net.falco81.famod.lib.FaModTileEntity;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class TitleEntityRenderTuBox extends TileEntitySpecialRenderer {
    private ModelTuBoxBlock modelTutBox = new ModelTuBoxBlock();

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick)
    {
        modelTutBox.render((FaModTileEntity)tileEntity, x, y, z);
    }

}
