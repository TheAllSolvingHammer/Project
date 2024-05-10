package sit.tu_varna.bg.project.file.read;

import sit.tu_varna.bg.project.contracts.FileManage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFile implements FileManage {
    private String filePath;

    public ReadFromFile(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void execute() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
            throw e;
        }
    }
}
