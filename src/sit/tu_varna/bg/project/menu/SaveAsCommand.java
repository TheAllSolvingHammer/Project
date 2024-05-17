package sit.tu_varna.bg.project.menu;

import sit.tu_varna.bg.project.complete.ParseIntoText;
import sit.tu_varna.bg.project.contracts.FileManage;
import sit.tu_varna.bg.project.contracts.ManageShape;
import sit.tu_varna.bg.project.contracts.Parser;
import sit.tu_varna.bg.project.file.FileWorker;
import sit.tu_varna.bg.project.file.write.SaveAsFile;
import sit.tu_varna.bg.project.file.write.SaveFile;

import java.util.Scanner;

public class SaveAsCommand implements MenuCommand{
    private String command;
    private ManageShape manageShape;
    private FileWorker worker;

    public SaveAsCommand(String command, ManageShape manageShape, FileWorker worker) {
        this.command = command;
        this.manageShape = manageShape;
        this.worker = worker;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(command);
        scanner.useDelimiter(" ");
        if(!scanner.hasNext()){
            return;
        }
        String s1= scanner.next();
        if(!s1.equalsIgnoreCase("saveas")){
           return;
        }
        if(!scanner.hasNext()){
            return;
        }
        String argument=scanner.next();
        String path = worker.getPath();
        Parser p1 = new ParseIntoText(manageShape);
        String content = p1.parseText();
        FileManage saver= new SaveAsFile(path,argument,content);
        saver.execute();

    }
}
