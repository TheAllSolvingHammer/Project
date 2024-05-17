package sit.tu_varna.bg.project.menu;

import sit.tu_varna.bg.project.enums.CommandEnum;
import sit.tu_varna.bg.project.file.FileWorker;

import java.util.Scanner;

public class CloseFileCommand implements MenuCommand{
    private String command;

    public CloseFileCommand(String command) {
        this.command = command;
    }

    @Override
    public void execute() {
        if(command==null || command.isEmpty()){
            return;
        }
        FileWorker worker =FileWorker.getInstance();
        Scanner scanner = new Scanner(command);
        scanner.useDelimiter(" ");
        if(!scanner.hasNext()){
            return;
        }
        String commandToRead= scanner.next();
        if(commandToRead.equalsIgnoreCase("close")) {
            worker.close();
        }
    }
}
