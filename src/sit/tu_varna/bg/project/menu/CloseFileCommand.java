package sit.tu_varna.bg.project.menu;

import sit.tu_varna.bg.project.enums.CommandEnum;
import sit.tu_varna.bg.project.file.FileWorker;

public class CloseFileCommand implements MenuCommand{
    private FileWorker worker;
    private String command;

    public CloseFileCommand(FileWorker worker, String command) {
        this.worker = worker;
        this.command = command;
    }

    @Override
    public void execute() {
        if(command.equalsIgnoreCase("close")) {
            worker.close();
        }
    }
}
