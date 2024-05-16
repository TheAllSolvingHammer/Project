package sit.tu_varna.bg.project.menu;

import sit.tu_varna.bg.project.file.FileWorker;

public class CloseFileCommand implements MenuCommand{
    private FileWorker worker;
    private String command;

    public CloseFileCommand(FileWorker worker) {
        this.worker = worker;
    }

    @Override
    public void execute() {
        worker.close();
    }
}
