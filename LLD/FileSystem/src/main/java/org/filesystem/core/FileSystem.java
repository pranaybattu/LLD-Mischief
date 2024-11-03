package org.filesystem.core;

import org.filesystem.exceptions.DirectoryNotEmptyException;
import org.filesystem.exceptions.FileSystemException;
import org.filesystem.factory.InodeFactory;
import org.filesystem.manager.BlockManager;
import org.filesystem.manager.DirectoryManager;
import org.filesystem.manager.InodeManager;
import org.filesystem.util.Logger;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Singleton class representing the File System.
 * Acts as the main interface for all file system operations.
 */
public class FileSystem {
    private static FileSystem instance;
    private Directory root;
    private InodeManager inodeManager;
    private BlockManager blockManager;
    private DirectoryManager directoryManager;


    /**
     * Private constructor to enforce Singleton pattern.
     *
     * @param blockSize   Size of each block in bytes.
     * @param totalBlocks Total number of blocks in the file system.
     */
    private FileSystem(int blockSize, int totalBlocks) {
        this.inodeManager = InodeManager.getInstance();
        this.blockManager = BlockManager.getInstance(blockSize, totalBlocks);
        this.directoryManager = new DirectoryManager(this);
        // Initialize root directory
        this.root = (Directory) InodeFactory.createInode("/", true);
        inodeManager.addInode(root);
        Logger.log("Initialization", "Root directory created");
    }

    /**
     * Retrieves the single instance of FileSystem.
     *
     * @param blockSize   Size of each block in bytes.
     * @param totalBlocks Total number of blocks in the file system.
     * @return Single instance of FileSystem.
     */
    public static synchronized FileSystem getInstance(int blockSize, int totalBlocks) {
        if (instance == null) {
            instance = new FileSystem(blockSize, totalBlocks);
        }
        return instance;
    }

    public Directory getRoot() {
        return root;
    }

    /**
     * Creates a new file or directory at the specified path.
     *
     * @param path        Path where the file/directory will be created.
     * @param isDirectory True if creating a directory, false for a file.
     * @throws FileSystemException If creation fails.
     */
    public void create(String path, boolean isDirectory) throws FileSystemException {
        if (path.equals("/")) {
            throw new FileSystemException("Root directory already exists");
        }
        int lastSlash = path.lastIndexOf('/');
        String parentPath = (lastSlash == 0) ? "/" : path.substring(0, lastSlash);
        String name = path.substring(lastSlash + 1);
        Inode parent = directoryManager.traversePath(parentPath);
        if (!parent.isDirectory()) {
            throw new FileSystemException("Parent is not a directory");
        }
        Directory dir = (Directory) parent;
        if (dir.getEntries().containsKey(name)) {
            throw new FileSystemException("File or directory already exists");
        }
        Inode newInode = InodeFactory.createInode(name, isDirectory);
        inodeManager.addInode(newInode);
        dir.getEntries().put(name, newInode.getInodeNumber());
        dir.setModifiedTime(System.currentTimeMillis());
        Logger.log("Create", (isDirectory ? "Directory" : "File") + " created at path: " + path);
    }

    /**
     * Writes data to the specified file.
     *
     * @param path Path of the file.
     * @param data Data to write.
     * @throws FileSystemException If writing fails.
     */
    public void writeFile(String path, byte[] data) throws FileSystemException {
        Inode file = directoryManager.traversePath(path);
        if (file.isDirectory()) {
            throw new FileSystemException("Cannot write to a directory");
        }
        File f = (File) file;
        // Clear existing blocks
        for (int block : f.getDataBlocks()) {
            blockManager.freeBlock(block);
        }
        f.getDataBlocks().clear();
        // Write new data
        int bytesWritten = 0;
        while (bytesWritten < data.length) {
            int block;
            try {
                block = blockManager.allocateBlock();
            } catch (Exception e) {
                throw new FileSystemException("Failed to allocate block: " + e.getMessage());
            }
            int length = Math.min(blockManager.getBlockSize(), data.length - bytesWritten);
            byte[] blockData = Arrays.copyOfRange(data, bytesWritten, bytesWritten + length);
            try {
                blockManager.writeBlock(block, blockData);
            } catch (Exception e) {
                throw new FileSystemException("Failed to write to block: " + block + " - " + e.getMessage());
            }
            f.getDataBlocks().add(block);
            bytesWritten += length;
        }
        f.setSize(data.length);
        f.setModifiedTime(System.currentTimeMillis());
        Logger.log("Write", "Written data to file: " + path);
    }

    /**
     * Reads data from the specified file.
     *
     * @param path Path of the file.
     * @return Data read from the file.
     * @throws FileSystemException If reading fails.
     */
    public byte[] readFile(String path) throws FileSystemException {
        Inode file = directoryManager.traversePath(path);
        if (file.isDirectory()) {
            throw new FileSystemException("Cannot read a directory");
        }
        File f = (File) file;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        for (int block : f.getDataBlocks()) {
            baos.write(blockManager.readBlock(block), 0, Math.min(blockManager.getBlockSize(), f.getSize()));
        }
        byte[] fullData = baos.toByteArray();
        Logger.log("Read", "Read data from file: " + path);
        return Arrays.copyOf(fullData, f.getSize()); // Trim to actual size
    }

    /**
     * Lists all entries within the specified directory.
     *
     * @param path Path of the directory.
     * @return List of entry names.
     * @throws FileSystemException If listing fails.
     */
    public List<String> listDirectory(String path) throws FileSystemException {
        Inode dirInode = directoryManager.traversePath(path);
        if (!dirInode.isDirectory()) {
            throw new FileSystemException("Not a directory");
        }
        Directory dir = (Directory) dirInode;
        Logger.log("ListDirectory", "Listed contents of: " + path);
        return new ArrayList<>(dir.getEntries().keySet());
    }

    /**
     * Deletes a file or directory at the specified path.
     *
     * @param path Path of the file/directory to delete.
     * @throws FileSystemException If deletion fails.
     */
    public void delete(String path) throws FileSystemException {
        if (path.equals("/")) {
            throw new FileSystemException("Cannot delete root directory");
        }
        int lastSlash = path.lastIndexOf('/');
        String parentPath = (lastSlash == 0) ? "/" : path.substring(0, lastSlash);
        String name = path.substring(lastSlash + 1);
        Inode parent = directoryManager.traversePath(parentPath);
        if (!parent.isDirectory()) {
            throw new FileSystemException("Parent is not a directory");
        }
        Directory dir = (Directory) parent;
        Integer targetInodeNumber = dir.getEntries().get(name);
        if (targetInodeNumber == null) {
            throw new FileSystemException("File or directory does not exist");
        }
        Inode target = inodeManager.getInode(targetInodeNumber);
        if (target.isDirectory()) {
            Directory targetDir = (Directory) target;
            if (!targetDir.getEntries().isEmpty()) {
                throw new DirectoryNotEmptyException("Directory is not empty");
            }
        } else {
            File f = (File) target;
            for (int block : f.getDataBlocks()) {
                blockManager.freeBlock(block);
            }
        }
        inodeManager.removeInode(targetInodeNumber);
        dir.getEntries().remove(name);
        dir.setModifiedTime(System.currentTimeMillis());
        Logger.log("Delete", (target.isDirectory() ? "Directory" : "File") + " deleted at path: " + path);
    }

    // Additional methods like move, rename can be implemented similarly
}
