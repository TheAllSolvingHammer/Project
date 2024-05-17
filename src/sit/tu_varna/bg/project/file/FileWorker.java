package sit.tu_varna.bg.project.file;

import sit.tu_varna.bg.project.contracts.FileInterface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class FileWorker implements FileInterface {
    private String content;
    private String path;
    private boolean opened;
    private static FileWorker instance;

    private FileWorker() {
        content=null;
        opened=false;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public void open() {
        if(!isSvgExtension()){
            System.out.println("File is not svg");
            return;
        }
        try {
            File file = new File(path);
            if (!file.exists() ) {
                try {
                    if (!file.createNewFile()) {
                        System.out.println("Failed to create a new file");
                    }
                    System.out.println("New empty file created: " + path);
                } catch (IOException e) {
                    System.out.println("Error creating new file: " + e.getMessage());
                    return;
                }
            }
            opened = true;
        } catch (Exception e) {
            System.out.println("Error opening file: " + e.getMessage());

        }

    }

    @Override
    public void read() {
        if(!opened){
            System.out.println("No file is opened!");
            return;
        }
        try  {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            StringBuilder sb1 = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb1.append(line).append("\n");
            }
            content= sb1.toString();
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());

        }
    }

    @Override
    public synchronized void close(){
        if(opened) {
            System.out.println("Closing file!");
            instance=null;
            opened = false;
        }
        else System.out.println("No file is opened to be closed!");
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public boolean isSvgExtension() {
        String s1 = path;
        int index = s1.lastIndexOf(".");
        if(index==-1){
            return false;
        }
        String s2=s1.substring(index+1);
        return s2.equals("svg");
    }

    @Override
    public String getPath() {
        return path;
    }
    public static synchronized FileWorker getInstance() {
        if (instance == null) {
            instance = new FileWorker();
        }
        return instance;
    }

    public boolean isOpened() {
        return opened;
    }
}
