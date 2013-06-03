package net.falco81.famod.models;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

public class ItemRenderShockFurnace  implements IItemRenderer {
  
    private ModelShockFurnace modelShockFurnace;
    
    public ItemRenderShockFurnace()
    {
        modelShockFurnace = new ModelShockFurnace();
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type)
    {
        return true;
    }
     
    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
    {
        return true;
    }
     
    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data)
    {
        switch(type)
        {
            case ENTITY:{
                renderShockFurnace(0f, 0f, 0f, 1f);
                return;
            }
             
            case EQUIPPED:{
                renderShockFurnace(0.5f, -0.5f, 0.5f, 1f);
                return;
            }
                 
            case INVENTORY:{
                renderShockFurnace(0f, -1f, 0f, 1f);
                return;
            }
            
            case EQUIPPED_FIRST_PERSON:{
                renderShockFurnace(1f, -0.5f, 0.5f, 1f);
                return;
            }
             
            default:return;
        }
    }
    
    private void renderShockFurnace(float x, float y, float z, float scale)
    {
        GL11.glPushMatrix();
     
        // Disable Lighting Calculations
        GL11.glDisable(GL11.GL_LIGHTING);
         
        GL11.glTranslatef(x,  y,  z);
        GL11.glScalef(scale, scale, scale);
        GL11.glRotatef(90, 0f, 1f, 0f);
         
        FMLClientHandler.instance().getClient().renderEngine.bindTexture("/mods/famod/models/ShockFurnace.png");
                 
        modelShockFurnace.render();
         
        // Re-enable Lighting Calculations
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }


}
