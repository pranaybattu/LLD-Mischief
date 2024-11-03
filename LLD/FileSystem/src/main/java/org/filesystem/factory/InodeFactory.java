package org.filesystem.factory;

import org.filesystem.core.Directory;
import org.filesystem.core.File;
import org.filesystem.core.Inode;

/**
 * Factory class for creating Inode instances.
 */
public class InodeFactory {
    /**
     * Creates an Inode instance based on the type.
     *
     * @param name        Name of the inode.
     * @param isDirectory True if creating a directory, false for a file.
     * @return Inode instance.
     */
    public static Inode createInode(String name, boolean isDirectory) {
        if (isDirectory) {
            return new Directory(name);
        } else {
            return new File(name);
        }
    }
}