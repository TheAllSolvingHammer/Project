package sit.tu_varna.bg.project.file.write;

import sit.tu_varna.bg.project.contracts.FileManage;
import sit.tu_varna.bg.project.file.FileWorker;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveAsFile implements FileManage {
    private final String oldFilePath;
    private String newFilePath;
    private String content;

    public SaveAsFile(String oldFilePath, String newFilePath, String content) {
        this.oldFilePath = oldFilePath;
        this.newFilePath = newFilePath;
        this.content = content;
    }

    @Override
    public void execute() {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(newFilePath));
            writer.write(content);
            writer.close();
            System.out.println("Successfully saved " + newFilePath);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public String getOldFilePath() {
        return oldFilePath;
    }

    public String getNewFilePath() {
        return newFilePath;
    }

    public void setNewFilePath(String newFilePath) {
        this.newFilePath = newFilePath;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
