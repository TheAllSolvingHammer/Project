package sit.tu_varna.bg.project.menu.commands;

import sit.tu_varna.bg.project.contracts.MenuCommand;
import sit.tu_varna.bg.project.shapes.ShapeManager;

import java.util.Scanner;

public class TranslateCommand implements MenuCommand {

    @Override
    public void execute(String command) {
        if(command==null || command.isEmpty()){
            return;
        }
        ShapeManager manageShape =ShapeManager.getInstance();
        Scanner scanner = new Scanner(command);
        if(!scanner.hasNext()){
            return;
        }
        String command1= scanner.next();
        if(!command1.equalsIgnoreCase("translate")){
            return;
        }
        int x,y;
        if(!scanner.hasNextInt()){
            return;
        }
        x=scanner.nextInt();
        if(!scanner.hasNextInt()){
            return;
        }
        y= scanner.nextInt();
        if(!scanner.hasNextInt()){
            manageShape.translate(x,y);
            return;
        }
        manageShape.translate(x,y,scanner.nextInt());
    }
}
