package org.filesystem.exceptions;

/**
 * Exception thrown when an Inode is not found.
 */
public class InodeNotFoundException extends FileSystemException {
    public InodeNotFoundException(String message) {
        super(message);
    }
}

