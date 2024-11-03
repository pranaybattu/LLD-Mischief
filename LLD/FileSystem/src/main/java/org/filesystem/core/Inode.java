package org.filesystem.core;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Abstract class representing an Inode.
 * Serves as the base class for File and Directory.
 */
public abstract class Inode {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(0);
    private final int inodeNumber;
    private String name;
    private boolean isDirectory;
    private int size;
    private long createdTime;
    private long modifiedTime;

    public Inode(String name, boolean isDirectory) {
        this.inodeNumber = ID_GENERATOR.incrementAndGet();
        this.name = name;
        this.isDirectory = isDirectory;
        this.size = 0;
        this.createdTime = System.currentTimeMillis();
        this.modifiedTime = System.currentTimeMillis();
    }

    public int getInodeNumber() {
        return inodeNumber;
    }
    public String getName() {
        return name;
    }
    public boolean isDirectory() {
        return isDirectory;
    }
    public int getSize() {
        return size;
    }
    public long getCreatedTime() {
        return createdTime;
    }
    public long getModifiedTime() {
        return modifiedTime;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDirectory(boolean isDirectory) {
        this.isDirectory = isDirectory;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }
    public void setModifiedTime(long modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        return "Inode{" +
                "inodeNumber=" + inodeNumber +
                ", name='" + name + '\'' +
                ", isDirectory=" + isDirectory +
                ", size=" + size +
                ", createdTime=" + createdTime +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}

