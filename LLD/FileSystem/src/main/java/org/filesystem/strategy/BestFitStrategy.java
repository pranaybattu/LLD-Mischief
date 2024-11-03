package org.filesystem.strategy;

import org.filesystem.manager.BlockManager;

import java.util.BitSet;

/**
 * Implementation of the Best-Fit allocation strategy.
 * For simplicity, this uses the same logic as First-Fit.
 * Extend this class with actual Best-Fit logic as needed.
 */
public class BestFitStrategy implements AllocationStrategy {
    @Override
    public int allocate(BlockManager blockManager) throws Exception {
        // Implement Best-Fit logic here
        // For demonstration, using First-Fit
        BitSet freeBlocks = blockManager.getFreeBlocks();
        int freeIndex = freeBlocks.nextSetBit(0);
        if (freeIndex == -1) {
            throw new Exception("No free blocks available");
        }
        freeBlocks.clear(freeIndex);
        return freeIndex;
    }
}