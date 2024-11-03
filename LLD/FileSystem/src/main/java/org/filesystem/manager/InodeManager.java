package org.filesystem.manager;

import lombok.Getter;
import org.filesystem.core.Inode;

import java.util.HashMap;
import java.util.Map;

/**
 * Singleton class managing Inodes.
 */
public class InodeManager {
    private static InodeManager instance;
    private Map<Integer, Inode> inodeTable;

    /**
     * Private constructor to enforce Singleton pattern.
     */
    private InodeManager() {
        this.inodeTable = new HashMap<>();
    }

    /**
     * Retrieves the single instance of InodeManager.
     *
     * @return Single instance of InodeManager.
     */
    public static synchronized InodeManager getInstance() {
        if (instance == null) {
            instance = new InodeManager();
        }
        return instance;
    }

    public Map<Integer, Inode> getInodeTable() {
        return inodeTable;
    }

    /**
     * Adds an Inode to the inode table.
     *
     * @param inode Inode to add.
     */
    public void addInode(Inode inode) {
        inodeTable.put(inode.getInodeNumber(), inode);
    }

    /**
     * Removes an Inode from the inode table.
     *
     * @param inodeNumber Inode number to remove.
     */
    public void removeInode(int inodeNumber) {
        inodeTable.remove(inodeNumber);
    }

    /**
     * Retrieves an Inode by its inode number.
     *
     * @param inodeNumber Inode number.
     * @return Inode object or null if not found.
     */
    public Inode getInode(int inodeNumber) {
        return inodeTable.get(inodeNumber);
    }
}
