package sit.tu_varna.bg.project.menu;

import sit.tu_varna.bg.project.file.FileWorker;

import java.io.File;

public class OpenFileCommand implements MenuCommand{
    private FileWorker worker;

    public OpenFileCommand(FileWorker worker) {
        this.worker = worker;
    }

    @Override
    public void execute() {
        worker.open();
    }
}
