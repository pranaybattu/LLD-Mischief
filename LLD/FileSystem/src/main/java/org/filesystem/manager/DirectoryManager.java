package org.filesystem.manager;

import org.filesystem.core.Directory;
import org.filesystem.core.FileSystem;
import org.filesystem.core.Inode;
import org.filesystem.exceptions.FileSystemException;

/**
 * Class handling directory-specific operations.
 */
public class DirectoryManager {
    private InodeManager inodeManager;
    private FileSystem fileSystem;

    /**
     * Constructor.
     *
     * @param fs Reference to the FileSystem.
     */
    public DirectoryManager(FileSystem fs) {
        this.inodeManager = InodeManager.getInstance();
        this.fileSystem = fs;
    }

    /**
     * Traverses a given path and returns the corresponding Inode.
     *
     * @param path Path to traverse.
     * @return Inode at the specified path.
     * @throws FileSystemException If path traversal fails.
     */
    public Inode traversePath(String path) throws FileSystemException {
        if (!path.startsWith("/")) {
            throw new FileSystemException("Path must start with '/'");
        }
        String[] parts = path.split("/");
        Inode current = fileSystem.getRoot();
        for (int i = 1; i < parts.length; i++) {
            if (current.isDirectory()) {
                String part = parts[i];
                if (part.isEmpty()) continue;
                Directory dir = (Directory) current;
                Integer childInodeNumber = dir.getEntries().get(part);
                if (childInodeNumber == null) {
                    throw new FileSystemException("Path not found: " + part);
                }
                current = inodeManager.getInode(childInodeNumber);
                if (current == null) {
                    throw new FileSystemException("Inode not found for: " + part);
                }
            } else {
                throw new FileSystemException("Encountered a file in the path before end");
            }
        }
        return current;
    }

    // Additional directory-specific methods can be added here
}
