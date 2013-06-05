package net.falco81.famod.bolcks;

import net.falco81.famod.FaMod;
import net.minecraft.block.BlockFurnace;

public class ShockFurnaceBlock extends BlockFurnace {
    
    public ShockFurnaceBlock(int id) {
        // super(id, Material.rock);
        
        super(id, false);

        setUnlocalizedName("shockfurnace");
        setHardness(5f);
        setCreativeTab(FaMod.tabsFaMod);

    }

   

}
