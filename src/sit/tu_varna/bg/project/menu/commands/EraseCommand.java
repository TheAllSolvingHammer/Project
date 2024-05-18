package sit.tu_varna.bg.project.menu.commands;

import sit.tu_varna.bg.project.contracts.MenuCommand;
import sit.tu_varna.bg.project.shapes.ShapeManager;

import java.util.Scanner;

public class EraseCommand implements MenuCommand {
    private String command;

    public EraseCommand(String command) {
        this.command = command;
    }

    @Override
    public void execute() {
        if(command==null || command.isEmpty()){
            return;
        }
        ShapeManager manageShape= ShapeManager.getInstance();
        Scanner scanner = new Scanner(command);
        int index;
        scanner.useDelimiter(" ");
        if(!scanner.hasNext()) {
            System.out.println("empty instructions");
            return;
        }
        String s1=scanner.next();
        if(!s1.equals("erase")){
            System.out.println("Wrong arguments");
            return;
        }
        if(!scanner.hasNextInt()){
            System.out.println("Wrong arguments");
            return;
        }
        index= scanner.nextInt();
        if(index<0){
            System.out.println("Wrong index");
            return;
        }
        manageShape.removeShape(index);
    }
}
