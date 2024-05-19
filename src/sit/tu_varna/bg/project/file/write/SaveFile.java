package sit.tu_varna.bg.project.file.write;

import sit.tu_varna.bg.project.contracts.FileManage;
import sit.tu_varna.bg.project.file.FileWorker;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Клас за запис на файл със зададен път и съдържание.
 */
public class SaveFile implements FileManage {
    private String filePath; // Пътят към файлът за запазване
    private String content; // Съдържанието на файла

    /**
     * Конструктор за създаване на обект от класа SaveFile със зададен път и съдържание.
     * @param filePath Пътят към файла за записване.
     * @param content Съдържанието, което трябва да бъде записано във файла.
     */
    public SaveFile(String filePath, String content) {
        this.filePath = filePath;
        this.content = content;
    }

    /**
     * Метод, който изпълнява записа на съдържанието във файла.
     */
    @Override
    public void execute() {
        FileWorker f1 = FileWorker.getInstance();
        if (!f1.isOpened()) {
            System.out.println("No opened file");
            return;
        }
        if (!isSvgExtension()) {
            System.out.println("File is not SVG");
            return;
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(content);
            writer.close();
            System.out.println("File saved at: " + filePath);
        } catch (IOException e) {
            System.out.println("Error in saving file: " + e.getMessage());
        }
    }

    /**
     * Метод, който проверява дали файла има SVG разширение.
     * @return Връща true ако файла има SVG разширение, в противен случай връща false.
     */
    @Override
    public boolean isSvgExtension() {
        String s1 = filePath;
        int index = s1.lastIndexOf(".");
        if (index == -1) {
            return false;
        }
        String s2 = s1.substring(index + 1);
        return s2.equalsIgnoreCase("svg");
    }

    /**
     * Метод, който връща пътя към файла.
     * @return Пътят към файла.
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Метод, който задава нов път към файла.
     * @param filePath Новият път към файла.
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Метод, който връща съдържанието на файла.
     * @return Съдържанието на файла.
     */
    public String getContent() {
        return content;
    }

    /**
     * Метод, който задава ново съдържание на файла.
     * @param content Новото съдържание на файла.
     */
    public void setContent(String content) {
        this.content = content;
    }
}

