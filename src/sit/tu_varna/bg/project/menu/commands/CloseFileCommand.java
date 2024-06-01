package sit.tu_varna.bg.project.menu.commands;

import sit.tu_varna.bg.project.contracts.MenuCommand;
import sit.tu_varna.bg.project.exceptions.FileWorkerException;
import sit.tu_varna.bg.project.file.FileWorker;


/**
 * Клас за командата Close
 */
public class CloseFileCommand implements MenuCommand {
    /**
     * Метод обработващ командата
     * @param command командата която се подава
     * Опитва се да хване грешката изхвърлена от класа FileWorker при затваряне
     */
    @Override
    public void execute(String command) {

        FileWorker worker =FileWorker.getInstance();
        try {
            worker.close();
        } catch (FileWorkerException e) {
            System.out.println(e.getMessage());
        }
    }
}
