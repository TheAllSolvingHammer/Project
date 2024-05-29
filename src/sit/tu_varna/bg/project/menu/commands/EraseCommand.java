package sit.tu_varna.bg.project.menu.commands;

import sit.tu_varna.bg.project.contracts.MenuCommand;
import sit.tu_varna.bg.project.exceptions.ManagerException;
import sit.tu_varna.bg.project.shapes.ShapeManager;

import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 * Клас за командата Еrase
 */
public class EraseCommand implements MenuCommand {
    /**
     * Метод обработващ командата
     * @param command командата която се подава
     */
    @Override
    public void execute(String command) {

        ShapeManager manageShape= ShapeManager.getInstance();
        Scanner scanner = new Scanner(command);
        int index;
        scanner.useDelimiter(" ");
        scanner.next();
        index= scanner.nextInt();
        try {
            manageShape.removeShape(index);
        } catch (ManagerException e) {
            System.out.println(e.getMessage());
        }catch (NoSuchElementException e) {
            System.out.println("No elements");
        }
    }
}
