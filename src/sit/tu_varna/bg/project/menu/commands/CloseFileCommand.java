package sit.tu_varna.bg.project.menu.commands;

import sit.tu_varna.bg.project.contracts.MenuCommand;
import sit.tu_varna.bg.project.file.FileWorker;

import java.util.Scanner;
/**
 * Клас за командата Close
 */
public class CloseFileCommand implements MenuCommand {
    /**
     * Метод обработващ командата
     * @param command командата която се подава
     */
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
