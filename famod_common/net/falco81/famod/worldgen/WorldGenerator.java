package net.falco81.famod.worldgen;

import java.util.Random;

import net.falco81.famod.bolcks.ModBlocks;
import net.falco81.famod.lib.Worldgen;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenerator implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.dimensionId){
        case -1:
            generateNether(world, random, chunkX * 16, chunkZ * 16);
            break;
        case 0:
            generateSurface(world, random, chunkX * 16, chunkZ * 16);
            break;
        case 1:
            generateEnd(world, random, chunkX * 16, chunkZ * 16);
            break;
        }
    }

    private void generateEnd(World world, Random rand, int chunkX, int chunkZ) {}

    private void generateSurface(World world, Random rand, int chunkX, int chunkZ) {
        if (Worldgen.WORLDGENMANGAN)
            this.addOre(ModBlocks.FaModMangan, world, rand, chunkX, chunkZ, 8, 20, 24, 48);
    }

    private void generateNether(World world, Random rand, int chunkX, int chunkZ) {}
    
    
    public void addOre(Block block, World world, Random random, int blockXPos,
            int blockZPos, int clusterSize, int spawnChances, int minY, int maxY) {
        for (int x = 0; x < spawnChances; x++) {
            int posX = blockXPos + random.nextInt(16);
            int posY = minY + random.nextInt(maxY - minY);
            int posZ = blockZPos + random.nextInt(16);
            (new WorldGenMinable(block.blockID, clusterSize, Block.stone.blockID))
                    .generate(world, random, posX, posY, posZ);
        }
    }
}
