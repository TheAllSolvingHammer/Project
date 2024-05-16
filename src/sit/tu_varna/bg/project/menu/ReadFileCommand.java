package sit.tu_varna.bg.project.menu;

import sit.tu_varna.bg.project.file.FileWorker;

public class ReadFileCommand implements MenuCommand{
    private FileWorker worker;

    public ReadFileCommand(FileWorker worker) {
        this.worker = worker;
    }

    @Override
    public void execute() {
        worker.read();
        System.out.println(worker.getContent());
    }
}
