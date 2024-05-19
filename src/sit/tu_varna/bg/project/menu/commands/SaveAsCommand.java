package sit.tu_varna.bg.project.menu.commands;

import sit.tu_varna.bg.project.complete.ParseIntoText;
import sit.tu_varna.bg.project.contracts.FileManage;
import sit.tu_varna.bg.project.contracts.MenuCommand;
import sit.tu_varna.bg.project.contracts.Parser;
import sit.tu_varna.bg.project.file.FileWorker;
import sit.tu_varna.bg.project.file.write.SaveAsFile;
import sit.tu_varna.bg.project.shapes.ShapeManager;

import java.util.Scanner;

public class SaveAsCommand implements MenuCommand {


    @Override
    public void execute(String command) {
        if(command==null || command.isEmpty()){
            System.out.println("command is empty");
            return;
        }
        ShapeManager manageShape = ShapeManager.getInstance();
        FileWorker worker = FileWorker.getInstance();
        Scanner scanner = new Scanner(command);
        scanner.useDelimiter(" ");
        if(!scanner.hasNext()){
            System.out.println("Not enough args");
            return;
        }
        String s1= scanner.next();
        if(!s1.equalsIgnoreCase("saveas")){
            System.out.println("unknown command");
           return;
        }
        if(!scanner.hasNext()){
            System.out.println("not enough args");
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
