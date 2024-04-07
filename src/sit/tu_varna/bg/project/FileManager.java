package sit.tu_varna.bg.project;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class FileManager {
    private static FileManager instance;
    private Set<File> openFiles;

    private FileManager() {
        openFiles = new HashSet<>();
    }

    public static synchronized FileManager getInstance() {
        if (instance == null) {
            instance = new FileManager();
        }
        return instance;
    }

    public synchronized boolean isOpen(File file) {
        return openFiles.contains(file);
    }

    public synchronized void openFile(File file) {
        openFiles.add(file);
        System.out.println("File " + file.getName() + " opened.");
    }

    public synchronized void closeFile(File file) {
        openFiles.remove(file);
        System.out.println("File " + file.getName() + " closed.");
    }

}

