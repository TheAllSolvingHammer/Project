package sit.tu_varna.bg.project.file.open;

import java.io.File;
import java.io.IOException;

public class OpenFile {
    public void create() throws IOException {
        String dirr = "svgdraw/";
        String fileName = "DataFile.txt";
        File dir = new File(dirr);

        if (!dir.exists()) {
            boolean created = dir.mkdirs();
            if (created) {
                System.out.println("Created");
            } else {
                System.out.println("Failed");
                return;
            }
        }
        File file = new File(dir, fileName);
        if (file.exists()) {
            System.out.println("File already exists.");
            return;
        }
        try {
            if (file.createNewFile()) {
                System.out.println("File created.");
            } else {
                System.out.println("Err");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
