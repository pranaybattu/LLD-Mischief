package org.filesystem.strategy;

import org.filesystem.manager.BlockManager;

import java.util.BitSet;

/**
 * Implementation of the First-Fit allocation strategy.
 */
public class FirstFitStrategy implements AllocationStrategy {
    @Override
    public int allocate(BlockManager blockManager) throws Exception {
        BitSet freeBlocks = blockManager.getFreeBlocks();
        int freeIndex = freeBlocks.nextSetBit(0);
        if (freeIndex == -1) {
            throw new Exception("No free blocks available");
        }
        freeBlocks.clear(freeIndex);
        return freeIndex;
    }
}