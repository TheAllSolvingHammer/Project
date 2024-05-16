package sit.tu_varna.bg.project.menu;

import sit.tu_varna.bg.project.contracts.ManageShape;

import java.util.Locale;
import java.util.Scanner;

public class EraseCommand implements MenuCommand{
    private ManageShape manageShape;
    private String command;

    public EraseCommand(ManageShape manageShape, String command) {
        this.manageShape = manageShape;
        this.command = command;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(command);
        int index=-1;
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
