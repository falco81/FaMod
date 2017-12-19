package com.Falco81.FaMod.utils;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import com.Falco81.FaMod.init.ModBlocks;
import com.Falco81.FaMod.init.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class DrawBlockHighlightEventHandler {
	
	@SubscribeEvent
    public void onDrawBlockHighlightEvent(DrawBlockHighlightEvent event) {
		Color col = Color.RED;
		float alpha = 0.5F;
		
        ItemStack held = event.getPlayer().getHeldItemMainhand();
        if (held == null || ModItems.smeltingEye != held.getItem())
            return;

        if (event.getTarget().getBlockPos() == null)
            return;

        EntityPlayer entityPlayer = event.getPlayer();
        World world = event.getPlayer().getEntityWorld();
        BlockPos blockpos = event.getTarget().getBlockPos();
        if (blockpos == null)
            return;

        /**
         * Dont highlight if we are actually targetting a air block
         */
        IBlockState state = world.getBlockState(event.getTarget().getBlockPos());
        if (state.getBlock().isAir(state, world, event.getTarget().getBlockPos()))
            return;

        
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.glLineWidth(2.0F);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask(false);
        IBlockState iblockstate = world.getBlockState(blockpos);

        if (world.getWorldBorder().contains(blockpos))
        {
        	double dx = entityPlayer.lastTickPosX + (entityPlayer.posX - entityPlayer.lastTickPosX) * (double)event.getPartialTicks();
            double dy = entityPlayer.lastTickPosY + (entityPlayer.posY - entityPlayer.lastTickPosY) * (double)event.getPartialTicks();
            double dz = entityPlayer.lastTickPosZ + (entityPlayer.posZ - entityPlayer.lastTickPosZ) * (double)event.getPartialTicks();
            if (entityPlayer.isSneaking()) {
            	AxisAlignedBB bb = iblockstate.getSelectedBoundingBox(entityPlayer.getEntityWorld(), blockpos).expand(0.0020000000949949026D, 0.0020000000949949026D, 0.0020000000949949026D).offset(-dx, -dy, -dz);
            	RenderGlobal.drawSelectionBoundingBox(bb, col.getRed() / 255f, col.getGreen() / 255f, col.getBlue() / 255f, alpha);    
                RenderGlobal.renderFilledBox(bb, col.getRed() / 255f, col.getGreen() / 255f, col.getBlue() / 255f, alpha);
            } else
            {
            	AxisAlignedBB bb = iblockstate.getSelectedBoundingBox(entityPlayer.getEntityWorld(), blockpos).expand(2.0020000000949949026D, 0.0020000000949949026D, 2.0020000000949949026D).offset(-dx-1, -dy, -dz-1);
            	RenderGlobal.drawSelectionBoundingBox(bb, col.getRed() / 255f, col.getGreen() / 255f, col.getBlue() / 255f, alpha);    
                RenderGlobal.renderFilledBox(bb, col.getRed() / 255f, col.getGreen() / 255f, col.getBlue() / 255f, alpha);
            }
        }
    

        GlStateManager.depthMask(true);
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();

        event.setCanceled(true);
    }
	
}