package sit.tu_varna.bg.project.file;

import sit.tu_varna.bg.project.contracts.FileInterface;
import sit.tu_varna.bg.project.exceptions.FileWorkerException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Клас оговарящ за работата с файлове
 */
public class FileWorker implements FileInterface {
    private String content;
    private String path;
    private boolean opened;
    private static FileWorker instance;

    /**
     * Конструктор който инициализира параметрите за съдържание и дали файлът е отворен
     */
    private FileWorker() {
        content=null;
        opened=false;
    }

    /**
     * Задава локацията от която файлът ще работи
     * @param path локация в ОС
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Метод който отваря файл, ако разширението му е .svg. Ако не намери такъв файл, създава нов с подаденото име от потребителя
     */
    @Override
    public void open() throws FileWorkerException {
        if(!isSvgExtension()){
            throw new FileWorkerException("File is not svg");
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

    /**
     * Чете отвореният файл, ако той не е отворен ще бъде известен потребителя. Методът е реализиран самостоятелно за да може да ако се използва поотделно
     * да бъде използван самосйтоятелно като мето.
     */
    @Override
    public void read() throws FileWorkerException {
        if(!opened){
            throw new FileWorkerException("No file is opened!");

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

    /**
     * Метод който затваря файла. В същото време изтрива инстанцията на този клас
     */
    @Override
    public synchronized void close() throws FileWorkerException{
        if(!opened) {
            throw new FileWorkerException("No file is opened to be closed!");
        }
        System.out.println("Closing file!");
        instance=null;
        opened = false;
    }

    /**
     * Гетър на съдържанието на файла
     * @return съдържанието от файла
     */
    @Override
    public String getContent() {
        return content;
    }

    /**
     * Проверка дали
     * @return връща дали файлът е във формат SVG
     */
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

    /**
     * Гетър на локацията на файлът
     * @return локацията
     */
    @Override
    public String getPath() {
        return path;
    }

    /**
     * Гетър на инстанцията на този клас, реализиращ сингълтън патерна
     * @return инстанция
     */
    public static synchronized FileWorker getInstance() {
        if (instance == null) {
            instance = new FileWorker();
        }
        return instance;
    }

    /**
     * Проверява дали има отворен файл за да се избегне използването на методите Save и SaveAs без да бъде отворен файл предварително
     * @return истина или лъжа
     */
    public boolean isOpened() {
        return opened;
    }
}
