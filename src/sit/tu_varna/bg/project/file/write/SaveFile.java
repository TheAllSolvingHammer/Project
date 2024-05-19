package sit.tu_varna.bg.project.file.write;

import sit.tu_varna.bg.project.contracts.FileManage;
import sit.tu_varna.bg.project.file.FileWorker;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveFile implements FileManage {
    private String filePath;
    private  String content;

    public SaveFile(String filePath, String content) {
        this.filePath = filePath;
        this.content = content;
    }

    @Override
    public void execute(){
        FileWorker f1=FileWorker.getInstance();
        if(!f1.isOpened()){
            System.out.println("no opened file");
            return;
        }
        if(!isSvgExtension()){
            System.out.println("File is not svg");
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

    @Override
    public boolean isSvgExtension() {
        String s1 = filePath;
        int index = s1.lastIndexOf(".");
        if(index==-1){
            return false;
        }
        String s2=s1.substring(index+1);
        return s2.equals("svg");
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
