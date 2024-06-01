package sit.tu_varna.bg.project.contracts;

import sit.tu_varna.bg.project.exceptions.FileWorkerException;

import java.io.IOException;

public interface FileInterface {
    void open() throws IOException, FileWorkerException;
    void read() throws IOException, FileWorkerException;
    void close() throws FileWorkerException;
    String getContent();
    boolean isSvgExtension();
    String getPath();

}
