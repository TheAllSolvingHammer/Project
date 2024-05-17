package sit.tu_varna.bg.project.menu;

import sit.tu_varna.bg.project.file.FileWorker;

import java.io.File;
import java.util.Scanner;

public class OpenFileCommand implements MenuCommand{
    private String command;

    public OpenFileCommand(String command) {
        this.command = command;
    }

    @Override
    public void execute() {
        Scanner scanner=new Scanner(command);
        if(!scanner.hasNext()){
            return;
        }
        String s1=scanner.next();
        if(!s1.equalsIgnoreCase("open")){
            return;
        }
        if(!scanner.hasNext()){
            return;
        }
        FileWorker worker= FileWorker.getInstance(scanner.next());
        worker.open();
        worker.read();
        System.out.println(worker.getContent());
    }
}
