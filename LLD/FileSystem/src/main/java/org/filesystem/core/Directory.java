package org.filesystem.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class representing a Directory in the file system.
 */

public class Directory extends Inode {
    private Map<String, Integer> entries;

    public Directory(String name) {
        super(name, true);
        this.entries = new HashMap<>();
    }

    public Map<String, Integer> getEntries() {
        return entries;
    }

    public void setEntries(Map<String, Integer> entries) {
        this.entries = entries;
    }

    /**
     * Adds a new entry to the directory.
     *
     * @param name        Name of the entry.
     * @param inodeNumber Inode number of the entry.
     */
    public void addEntry(String name, int inodeNumber) {
        entries.put(name, inodeNumber);
        setModifiedTime(System.currentTimeMillis());
    }

    /**
     * Removes an entry from the directory.
     *
     * @param name Name of the entry to remove.
     */
    public void removeEntry(String name) {
        entries.remove(name);
        setModifiedTime(System.currentTimeMillis());
    }

    /**
     * Lists all entries in the directory.
     *
     * @return List of entry names.
     */
    public List<String> listEntries() {
        return new ArrayList<>(entries.keySet());
    }
}