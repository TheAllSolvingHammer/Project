package sit.tu_varna.bg.project.menu.commands;

import sit.tu_varna.bg.project.complete.SvgParseString;
import sit.tu_varna.bg.project.contracts.FileManage;
import sit.tu_varna.bg.project.contracts.MenuCommand;
import sit.tu_varna.bg.project.contracts.Parser;
import sit.tu_varna.bg.project.exceptions.SaverException;
import sit.tu_varna.bg.project.file.FileWorker;
import sit.tu_varna.bg.project.file.write.SaveAsFile;
import sit.tu_varna.bg.project.shapes.ShapeManager;

import java.util.Scanner;
/**
 * Клас за командата SaveAs
 */
public class SaveAsCommand implements MenuCommand {
    /**
     * Метод обработващ командата
     * @param command командата която се подава
     */
    @Override
    public void execute(String command) {
        try {
            ShapeManager manageShape = ShapeManager.getInstance();
            FileWorker worker = FileWorker.getInstance();
            Scanner scanner = new Scanner(command);
            scanner.useDelimiter(" ");
            scanner.next();
            String argument = scanner.next();
            String path = worker.getPath();
            Parser p1 = new SvgParseString(manageShape);
            String content = p1.parseText();
            FileManage saver = new SaveAsFile(path, argument, content);
            saver.execute();
        }
        catch (SaverException e) {
            System.out.println(e.getMessage());
        }

    }
}
