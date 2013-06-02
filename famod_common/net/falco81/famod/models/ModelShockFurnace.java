package net.falco81.famod.models;

import net.falco81.famod.lib.FaModTileEntity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelShockFurnace extends ModelBase {
    //private IModelCustom modelShockFurnace;
    
    public ModelRenderer Shape1;
    public ModelRenderer Shape2;
    public ModelRenderer Shape3;    
      
    public ModelShockFurnace()
    {
        
         //modelTutBox = AdvancedModelLoader.loadModel("/mods/famod/models/TutBox.obj");
       // AdvancedModelLoader.registerModelHandler(new TechneModelLoader());
       // modelShockFurnace = AdvancedModelLoader.loadModel("/mods/famod/models/ShockFurnace.tcn");
         
        textureWidth = 64;
        textureHeight = 128;
        
          Shape1 = new ModelRenderer(this, 0, 0);
          Shape1.addBox(0F, 0F, 0F, 16, 16, 2);
          Shape1.setRotationPoint(-8F, 8F, 6F);
          Shape1.setTextureSize(64, 128);
          Shape1.mirror = true;
          setRotation(Shape1, 0F, 0F, 0F);
          Shape2 = new ModelRenderer(this, 0, 20);
          Shape2.addBox(0F, 0F, 0F, 16, 16, 2);
          Shape2.setRotationPoint(-8F, 8F, -8F);
          Shape2.setTextureSize(64, 128);
          Shape2.mirror = true;
          setRotation(Shape2, 0F, 0F, 0F);
          Shape3 = new ModelRenderer(this, 0, 41);
          Shape3.addBox(0F, 0F, 0F, 10, 10, 12);
          Shape3.setRotationPoint(-5F, 11F, -6F);
          Shape3.setTextureSize(64, 128);
          Shape3.mirror = true;
          setRotation(Shape3, 0F, 0F, 0F);     
                 
    }
    
    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
    }
     
       
    public void render()
    {
        //modelShockFurnace.renderAll();
        Shape1.render( 0.0625f);
        Shape2.render( 0.0625f);
        Shape3.render( 0.0625f);
    }

    public void render(FaModTileEntity box, double x, double y, double z)
    {
        // Push a blank matrix onto the stack
        GL11.glPushMatrix();
     
        // Move the object into the correct position on the block (because the OBJ's origin is the center of the object)
        GL11.glTranslatef((float)x+0.5f,(float)y-0.5f,(float)z+0.5f);
     
        // Scale our object to about half-size in all directions (the OBJ file is a little large)
        //GL11.glScalef(0.0625f, 0.0625f, 0.0625f);
     
        // Bind the texture, so that OpenGL properly textures our block.
        FMLClientHandler.instance().getClient().renderEngine.bindTexture("/mods/famod/models/ShockFurnace.png");
                
     
        // Render the object, using modelTutBox.renderAll();
        this.render();
     
        // Pop this matrix from the stack.
        GL11.glPopMatrix();
    }


}
