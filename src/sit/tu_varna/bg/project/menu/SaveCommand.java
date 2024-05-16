package sit.tu_varna.bg.project.menu;

import sit.tu_varna.bg.project.contracts.FileManage;
import sit.tu_varna.bg.project.enums.CommandEnum;
import sit.tu_varna.bg.project.file.write.SaveFile;

public class SaveCommand implements MenuCommand {
    private SaveFile file;

    public SaveCommand(SaveFile file) {
        this.file = file;
    }

    @Override
    public void execute() {
        file.execute();
    }
}
