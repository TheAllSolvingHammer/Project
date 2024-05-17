package sit.tu_varna.bg.project.menu;

import sit.tu_varna.bg.project.complete.ParseIntoText;
import sit.tu_varna.bg.project.contracts.FileManage;
import sit.tu_varna.bg.project.contracts.ManageShape;
import sit.tu_varna.bg.project.contracts.Parser;
import sit.tu_varna.bg.project.enums.CommandEnum;
import sit.tu_varna.bg.project.file.FileWorker;
import sit.tu_varna.bg.project.file.write.SaveFile;
import sit.tu_varna.bg.project.shapes.ShapeManager;

public class SaveCommand implements MenuCommand {
    private String command;

    public SaveCommand(String command) {
        this.command = command;
    }

    @Override
    public void execute() {
        if(command==null || command.isEmpty()){
            return;
        }

        if(command.equalsIgnoreCase("save")) {
            ShapeManager manageShape = ShapeManager.getInstance();
            FileWorker worker = FileWorker.getInstance();
            String path = worker.getPath();
            Parser p1 = new ParseIntoText(manageShape);
            String content = p1.parseText();
            FileManage saver= new SaveFile(path,content);
            saver.execute();
        }
    }
}
