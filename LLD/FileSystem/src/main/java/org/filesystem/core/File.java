package org.filesystem.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a File in the file system.
 */

public class File extends Inode {
    private List<Integer> dataBlocks;

    public File(String name) {
        super(name, false);
        this.dataBlocks = new ArrayList<>();
    }

    public List<Integer> getDataBlocks() {
        return dataBlocks;
    }

    public void setDataBlocks(List<Integer> dataBlocks) {
        this.dataBlocks = dataBlocks;
    }
}

