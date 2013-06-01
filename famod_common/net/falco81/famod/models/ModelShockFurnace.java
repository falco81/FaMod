package net.falco81.famod.models;

import net.falco81.famod.lib.FaModTileEntity;
import net.minecraft.client.model.ModelBase;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelShockFurnace extends ModelBase {
    private IModelCustom modelShockFurnace;
   
      
    public ModelShockFurnace()
    {
        
         //modelTutBox = AdvancedModelLoader.loadModel("/mods/famod/models/TutBox.obj");
        AdvancedModelLoader.registerModelHandler(new TechneModelLoader());
        modelShockFurnace = AdvancedModelLoader.loadModel("/mods/famod/models/Block.tcn");
         
         
                 
    }
    
       
    public void render()
    {
        modelShockFurnace.renderAll();
    }

    public void render(FaModTileEntity box, double x, double y, double z)
    {
        // Push a blank matrix onto the stack
        GL11.glPushMatrix();
     
        // Move the object into the correct position on the block (because the OBJ's origin is the center of the object)
        GL11.glTranslatef((float)x+0.5f,(float)y+0.965f,(float)z+0.5f);
     
        // Scale our object to about half-size in all directions (the OBJ file is a little large)
        GL11.glScalef(0.0625f, 0.0625f, 0.0625f);
     
        // Bind the texture, so that OpenGL properly textures our block.
        //FMLClientHandler.instance().getClient().renderEngine.bindTexture("/mods/famod/textures/blocks/blocktutbox.png");
     
        // Render the object, using modelTutBox.renderAll();
        this.render();
     
        // Pop this matrix from the stack.
        GL11.glPopMatrix();
    }


}
