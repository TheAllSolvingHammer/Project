package sit.tu_varna.bg.project.menu;

import sit.tu_varna.bg.project.file.write.SaveAsFile;

public class SaveAsCommand implements MenuCommand{
    private SaveAsFile file;

    public SaveAsCommand(SaveAsFile file) {
        this.file = file;
    }

    @Override
    public void execute() {
        file.execute();
    }
}
