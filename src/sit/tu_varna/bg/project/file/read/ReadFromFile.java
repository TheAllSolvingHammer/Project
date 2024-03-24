package sit.tu_varna.bg.project.file.read;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFile {
    public String read() throws IOException {
        String dirr="svgdraw/";
        BufferedReader reader = new BufferedReader(new FileReader(dirr+"DataFile.txt"));
        StringBuilder sb1 = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb1.append(line).append("\n");
        }
        reader.close();
        return sb1.toString();
    }
}
