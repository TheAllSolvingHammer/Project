package sit.tu_varna.bg.project.file.open;

import sit.tu_varna.bg.project.contracts.FileManage;

import java.io.*;


public class OpenFile implements FileManage {
    private final String filePath;
    private String content;

    public OpenFile(String filePath) {
        this.filePath = filePath;
        this.content = null;
    }
    @Override
    public void execute()  {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder stringBuilder = new StringBuilder();
            String line = reader.readLine();
            while (line != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
                line = reader.readLine();
            }
            reader.close();
            content = stringBuilder.toString();
            System.out.println("Successfully opened " + filePath);
        } catch (IOException e) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
                System.out.println("File not found, creating new file: " + filePath);
                writer.close();
                content = null;
            } catch (IOException e1) {
                System.out.println("Error in creating new file " + e1.getMessage());
                System.exit(1);
            }
        }
    }

    public String getFilePath() {
        return filePath;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
