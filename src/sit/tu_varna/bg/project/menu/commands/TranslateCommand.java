package sit.tu_varna.bg.project.menu.commands;

import sit.tu_varna.bg.project.contracts.MenuCommand;
import sit.tu_varna.bg.project.exceptions.ManagerException;
import sit.tu_varna.bg.project.shapes.ShapeManager;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 * Клас за командата Translate
 */
public class TranslateCommand implements MenuCommand {
    /**
     * Метод обработващ командата
     * @param command командата която се подава
     */
    @Override
    public void execute(String command) {
        try {
        ShapeManager manageShape =ShapeManager.getInstance();
        Scanner scanner = new Scanner(command);
        scanner.next();
        int x,y;
        x=scanner.nextInt();
        y= scanner.nextInt();
        if(!scanner.hasNextInt()){
            manageShape.translate(x,y);
        }
        else
            manageShape.translate(x,y,scanner.nextInt());
        } catch (ManagerException e) {
            System.out.println(e.getMessage());
        }catch (InputMismatchException e){
            System.out.println("Value is not int");
        }catch (NoSuchElementException e){
            System.out.println("No elements");
        }
    }
}
