package net.falco81.famod.worldgen;

import java.util.Random;

import net.falco81.famod.bolcks.ModBlocks;
import net.falco81.famod.lib.Metadata;
import net.falco81.famod.lib.Worldgen;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenerator implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
            IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.dimensionId) {
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

    private void generateEnd(World world, Random rand, int chunkX, int chunkZ) {
    }

    private void generateSurface(World world, Random rand, int chunkX,
            int chunkZ) {
        if (Worldgen.WORLDGENMANGAN)
            this.addOre(ModBlocks.FaModManganOre,0, world, rand, chunkX, chunkZ,
                    8, 5, 24, 48);
        if (Worldgen.WORLDGENSHOCKORE)
            this.addOre(ModBlocks.FaModShockCoalOre,0, world, rand, chunkX,
                    chunkZ, 8, 10, 1, 10);
        if (Worldgen.WORLDGENMARBLE)
            this.addOre(ModBlocks.FaModDecorBlock, Metadata.MARBLE, world,
                    rand, chunkX, chunkZ, 40, 1, 48, 72);
        if (Worldgen.WORLDGENBASALT)
            this.addOre(ModBlocks.FaModDecorBlock, Metadata.BASALT, world,
                    rand, chunkX, chunkZ, 20, 1, 0, 24);

    }

    private void generateNether(World world, Random rand, int chunkX, int chunkZ) {
    }

    public void addOre(Block block, int meta, World world, Random random, int blockXPos,
            int blockZPos, int clusterSize, int spawnChances, int minY, int maxY) {
        for (int x = 0; x < spawnChances; x++) {
            int posX = blockXPos + random.nextInt(16);
            int posY = minY + random.nextInt(maxY - minY);
            int posZ = blockZPos + random.nextInt(16);
            (new WorldGenMinable(block.blockID,meta ,clusterSize,
                    Block.stone.blockID)).generate(world, random, posX, posY,
                    posZ);
        }
    }
}
