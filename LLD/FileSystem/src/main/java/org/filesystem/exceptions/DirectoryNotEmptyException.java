package org.filesystem.exceptions;

/**
 * Exception thrown when attempting to delete a non-empty directory.
 */
public class DirectoryNotEmptyException extends FileSystemException {
    public DirectoryNotEmptyException(String message) {
        super(message);
    }
}

