package sit.tu_varna.bg.project.contracts;

import java.io.IOException;

public interface FileInterface {
    void open() throws IOException;
    void read() throws IOException;
    void close();
    String getContent();
    boolean isSvgExtension();
}
