package sit.tu_varna.bg.project.menu.commands;

import sit.tu_varna.bg.project.contracts.MenuCommand;
import sit.tu_varna.bg.project.file.FileWorker;
import sit.tu_varna.bg.project.readers.SvgReader;

import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 * Клас за командата Open
 */
public class OpenFileCommand implements MenuCommand {
    /**
     * Метод обработващ командата
     * @param command командата която се подава
     */
    @Override
    public void execute(String command) {
        Scanner scanner=new Scanner(command);
        scanner.next();
        FileWorker worker= FileWorker.getInstance();
        try {
            worker.setPath(scanner.next());
            worker.open();
            worker.read();
            SvgReader svgReader = new SvgReader(worker.getContent());
            svgReader.readAllItems();
        }
        catch (NullPointerException e) {
            System.out.println("Nothing is read!");

        }catch (NoSuchElementException e){
            System.out.println("Error in reading file!");
        }
    }
}
