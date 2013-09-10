package net.falco81.famod.lib;

import net.minecraft.util.ResourceLocation;




public class Texture {
    
    public static final String BLOCK_TEXTURE_LOCATION = "/mods/famod/textures/block/";
    
    public static final String SAND_TEXTURE = BLOCK_TEXTURE_LOCATION + "sand.png";
    public static final String BEDROCK_TEXTURE = BLOCK_TEXTURE_LOCATION + "bedrock.png";
    public static final String GUI_SHEET_LOCATION = "textures/gui/";
    
    public static final ResourceLocation GUI_SHOCKFURNACE = ResourceLocationHelper.getResourceLocation(GUI_SHEET_LOCATION + "furnace.png");
}
