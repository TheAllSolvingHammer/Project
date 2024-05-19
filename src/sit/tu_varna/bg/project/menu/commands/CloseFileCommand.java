package sit.tu_varna.bg.project.menu.commands;

import sit.tu_varna.bg.project.contracts.MenuCommand;
import sit.tu_varna.bg.project.file.FileWorker;

import java.util.Scanner;

public class CloseFileCommand implements MenuCommand {

    @Override
    public void execute(String command) {
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
