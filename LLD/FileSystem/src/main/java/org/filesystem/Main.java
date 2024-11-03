package org.filesystem;

import org.filesystem.core.FileSystem;
import org.filesystem.exceptions.FileSystemException;

import java.util.List;

/**
 * Main class to demonstrate the FileSystem functionality.
 */
public class Main {
    public static void main(String[] args) {
        try {
            // Initialize FileSystem with block size 512 bytes and 100 blocks
            FileSystem fs = FileSystem.getInstance(512, 100);

            // Create directories
            fs.create("/home", true);
            fs.create("/home/user", true);
            fs.create("/home/user/docs", true);

            // Create files
            fs.create("/home/user/docs/file1.txt", false);
            fs.create("/home/user/docs/file2.txt", false);

            // Write to files
            fs.writeFile("/home/user/docs/file1.txt", "Hello, World!".getBytes());
            fs.writeFile("/home/user/docs/file2.txt", "Java File System".getBytes());

            // Read from files
            byte[] data1 = fs.readFile("/home/user/docs/file1.txt");
            System.out.println("Content of file1.txt: " + new String(data1));

            byte[] data2 = fs.readFile("/home/user/docs/file2.txt");
            System.out.println("Content of file2.txt: " + new String(data2));

            // List directory contents
            List<String> contents = fs.listDirectory("/home/user/docs");
            System.out.println("Contents of /home/user/docs:");
            for (String name : contents) {
                System.out.println("- " + name);
            }

            // Delete a file
            fs.delete("/home/user/docs/file1.txt");
            System.out.println("Deleted file1.txt");

            // List directory contents after deletion
            contents = fs.listDirectory("/home/user/docs");
            System.out.println("Contents of /home/user/docs after deletion:");
            for (String name : contents) {
                System.out.println("- " + name);
            }

            // Attempt to read deleted file (should throw exception)
            fs.readFile("/home/user/docs/file1.txt");
        } catch (FileSystemException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}