package org.filesystem.strategy;

import org.filesystem.manager.BlockManager;

/**
 * Interface defining the strategy for block allocation.
 */
public interface AllocationStrategy {
    /**
     * Allocates a block using the strategy.
     *
     * @param blockManager Reference to the BlockManager.
     * @return Allocated block index.
     * @throws Exception If allocation fails.
     */
    int allocate(BlockManager blockManager) throws Exception;
}

