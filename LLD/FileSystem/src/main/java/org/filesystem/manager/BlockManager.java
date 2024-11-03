package org.filesystem.manager;

import org.filesystem.strategy.AllocationStrategy;
import org.filesystem.strategy.FirstFitStrategy;

import java.util.Arrays;
import java.util.BitSet;

/**
 * Singleton class managing disk blocks.
 */
public class BlockManager {
    private static BlockManager instance;
    private final int blockSize;
    private final int totalBlocks;
    private final byte[][] blocks;
    private final BitSet freeBlocks;
    private AllocationStrategy allocationStrategy;

    /**
     * Private constructor to enforce Singleton pattern.
     *
     * @param blockSize   Size of each block in bytes.
     * @param totalBlocks Total number of blocks.
     */
    private BlockManager(int blockSize, int totalBlocks) {
        this.blockSize = blockSize;
        this.totalBlocks = totalBlocks;
        this.blocks = new byte[totalBlocks][blockSize];
        this.freeBlocks = new BitSet(totalBlocks);
        this.freeBlocks.set(0, totalBlocks); // All blocks are free initially
        this.allocationStrategy = new FirstFitStrategy(); // Default strategy
    }

    public int getBlockSize() {
        return blockSize;
    }

    public int getTotalBlocks() {
        return totalBlocks;
    }

    public byte[][] getBlocks() {
        return blocks;
    }

    public BitSet getFreeBlocks() {
        return freeBlocks;
    }

    public AllocationStrategy getAllocationStrategy() {
        return allocationStrategy;
    }


    /**
     * Retrieves the single instance of BlockManager.
     *
     * @param blockSize   Size of each block in bytes.
     * @param totalBlocks Total number of blocks.
     * @return Single instance of BlockManager.
     */
    public static synchronized BlockManager getInstance(int blockSize, int totalBlocks) {
        if (instance == null) {
            instance = new BlockManager(blockSize, totalBlocks);
        }
        return instance;
    }

    /**
     * Sets the allocation strategy.
     *
     * @param strategy AllocationStrategy implementation.
     */
    public void setAllocationStrategy(AllocationStrategy strategy) {
        this.allocationStrategy = strategy;
    }

    /**
     * Allocates a block using the current allocation strategy.
     *
     * @return Allocated block index.
     * @throws Exception If allocation fails.
     */
    public synchronized int allocateBlock() throws Exception {
        return allocationStrategy.allocate(this);
    }

    /**
     * Frees a block at the specified index.
     *
     * @param index Block index to free.
     */
    public synchronized void freeBlock(int index) {
        if (index >= 0 && index < totalBlocks) {
            freeBlocks.set(index);
            Arrays.fill(blocks[index], (byte) 0); // Clear the block data
        }
    }

    /**
     * Writes data to a block.
     *
     * @param index Block index.
     * @param data  Data to write.
     * @throws Exception If data exceeds block size.
     */
    public synchronized void writeBlock(int index, byte[] data) throws Exception {
        if (data.length > blockSize) {
            throw new Exception("Data exceeds block size");
        }
        System.arraycopy(data, 0, blocks[index], 0, data.length);
    }

    /**
     * Reads data from a block.
     *
     * @param index Block index.
     * @return Data read from the block.
     */
    public synchronized byte[] readBlock(int index) {
        return blocks[index];
    }
}
