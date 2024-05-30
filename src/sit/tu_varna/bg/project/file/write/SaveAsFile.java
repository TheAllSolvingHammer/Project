package sit.tu_varna.bg.project.file.write;

import sit.tu_varna.bg.project.contracts.FileManage;
import sit.tu_varna.bg.project.exceptions.SaverException;
import sit.tu_varna.bg.project.file.FileWorker;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Клас за запис на файл с нов път и съдържание, като стария файл не се променя.
 */
public class SaveAsFile implements FileManage {
    private final String oldFilePath; // Старият път към файла
    private String newFilePath; // Новият път към файла
    private String content; // Съдържанието на файла

    /**
     * Конструктор за създаване на обект от класа SaveAsFile със стар и нов път и съдържание.
     * @param oldFilePath Старият път към файла.
     * @param newFilePath Новият път към файла.
     * @param content Съдържанието, което трябва да бъде записано в новия файл.
     */
    public SaveAsFile(String oldFilePath, String newFilePath, String content) {
        this.oldFilePath = oldFilePath;
        this.newFilePath = newFilePath;
        this.content = content;
    }

    /**
     * Метод, който изпълнява записа на съдържанието в нов файл с новия път.
     */
    @Override
    public void execute() throws SaverException {
        FileWorker f1 = FileWorker.getInstance();
        if (!f1.isOpened()) {
           throw new SaverException("No file opened!");
        }
        if (!isSvgExtension()) {
            throw new SaverException("Not a Svg file!");
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(newFilePath));
            writer.write(content);
            writer.close();
            System.out.println("Successfully saved " + newFilePath);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Метод, който проверява дали новият файл има SVG разширение.
     * @return Връща true ако новият файл има SVG разширение, в противен случай връща false.
     */
    @Override
    public boolean isSvgExtension() {
        String s1 = newFilePath;
        int index = s1.lastIndexOf(".");
        if (index == -1) {
            return false;
        }
        String s2 = s1.substring(index + 1);
        return s2.equalsIgnoreCase("svg");
    }

    /**
     * Метод, който връща старият път към файла.
     * @return Старият път към файла.
     */
    public String getOldFilePath() {
        return oldFilePath;
    }

    /**
     * Метод, който връща новият път към файла.
     * @return Новият път към файла.
     */
    public String getNewFilePath() {
        return newFilePath;
    }

    /**
     * Метод, който задава новият път към файла.
     * @param newFilePath Новият път към файла.
     */
    public void setNewFilePath(String newFilePath) {
        this.newFilePath = newFilePath;
    }

    /**
     * Метод, който връща съдържанието на файла.
     * @return Съдържанието на файла.
     */
    public String getContent() {
        return content;
    }

    /**
     * Метод, който задава новото съдържание на файла.
     * @param content Новото съдържание на файла.
     */
    public void setContent(String content) {
        this.content = content;
    }
}

