package sit.tu_varna.bg.project.menu.commands;

import sit.tu_varna.bg.project.contracts.MenuCommand;
import sit.tu_varna.bg.project.shapes.ShapeManager;

import java.util.Scanner;

public class TranslateCommand implements MenuCommand {
    private String command;

    public TranslateCommand(String command) {
        this.command = command;
    }

    @Override
    public void execute() {
        if(command==null || command.isEmpty()){
            return;
        }
        ShapeManager manageShape =ShapeManager.getInstance();
        Scanner scanner = new Scanner(command);
        if(!scanner.hasNext()){
            return;
        }
        String command= scanner.next();
        if(!command.equalsIgnoreCase("translate")){
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
