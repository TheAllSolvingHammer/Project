package sit.tu_varna.bg.project.menu;

import sit.tu_varna.bg.project.complete.ParseIntoText;
import sit.tu_varna.bg.project.contracts.FileManage;
import sit.tu_varna.bg.project.contracts.ManageShape;
import sit.tu_varna.bg.project.contracts.Parser;
import sit.tu_varna.bg.project.enums.CommandEnum;
import sit.tu_varna.bg.project.file.FileWorker;
import sit.tu_varna.bg.project.file.write.SaveFile;

public class SaveCommand implements MenuCommand {
    private String command;
    private ManageShape manageShape;
    private FileWorker worker;

    public SaveCommand(String command, ManageShape manageShape, FileWorker worker) {
        this.command = command;
        this.manageShape = manageShape;
        this.worker = worker;
    }

    @Override
    public void execute() {
        if(command.equalsIgnoreCase("save")) {
            String path = worker.getPath();
            Parser p1 = new ParseIntoText(manageShape);
            String content = p1.parseText();
            FileManage saver= new SaveFile(path,content);
            saver.execute();
        }
    }
}
