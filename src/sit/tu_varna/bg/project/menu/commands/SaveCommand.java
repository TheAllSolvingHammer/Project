package sit.tu_varna.bg.project.menu.commands;

import sit.tu_varna.bg.project.complete.SvgParseString;
import sit.tu_varna.bg.project.contracts.FileManage;
import sit.tu_varna.bg.project.contracts.MenuCommand;
import sit.tu_varna.bg.project.contracts.Parser;
import sit.tu_varna.bg.project.exceptions.FileWorkerException;
import sit.tu_varna.bg.project.file.FileWorker;
import sit.tu_varna.bg.project.file.write.SaveFile;
import sit.tu_varna.bg.project.shapes.ShapeManager;

/**
 * Клас за командата Save
 */
public class SaveCommand implements MenuCommand {
    /**
     * Метод обработващ командата
     * @param command командата която се подава
     */
    @Override
    public void execute(String command) {
        try {
            ShapeManager manageShape = ShapeManager.getInstance();
            FileWorker worker = FileWorker.getInstance();
            String path = worker.getPath();
            Parser p1 = new SvgParseString(manageShape);
            String content = p1.parseText();
            FileManage saver = new SaveFile(path, content);
            saver.execute();
        }
        catch (FileWorkerException e) {
            System.out.println(e.getMessage());
        }

    }
}
