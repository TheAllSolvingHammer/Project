package sit.tu_varna.bg.project.menu.commands;

import sit.tu_varna.bg.project.contracts.ManageShape;
import sit.tu_varna.bg.project.contracts.MenuCommand;
import sit.tu_varna.bg.project.contracts.Shape;
import sit.tu_varna.bg.project.regions.CircleRegion;
import sit.tu_varna.bg.project.regions.RectangleRegion;
import sit.tu_varna.bg.project.shapes.ShapeManager;

import java.util.List;
import java.util.Scanner;

public class WithinCommand implements MenuCommand {
    private String command;

    public WithinCommand(String command) {
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
        if(!command.equalsIgnoreCase("within")){
            return;
        }
        if(!scanner.hasNext()){
            return;
        }
        String type= scanner.next();
        if(type.equalsIgnoreCase("circle")) {
            int x, y,r;
            if (!scanner.hasNextInt()) {
                return;
            }
            x = scanner.nextInt();
            if (!scanner.hasNextInt()) {
                return;
            }
            y = scanner.nextInt();
            if (!scanner.hasNextInt()) {
                return;
            }
            r= scanner.nextInt();
            CircleRegion region = new CircleRegion(x,y,r);
            List<Shape>list =manageShape.within(region);
            if(list.isEmpty()){
                System.out.println("No occurrences!");
                return;
            }
            for(Shape shape:list){
                shape.toUser();
            }

        }
        else if(type.equalsIgnoreCase("rectangle")) {
            int x, y,w,h;
            if (!scanner.hasNextInt()) {
                return;
            }
            x = scanner.nextInt();
            if (!scanner.hasNextInt()) {
                return;
            }
            y = scanner.nextInt();
            if (!scanner.hasNextInt()) {
                return;
            }
            w= scanner.nextInt();
            if (!scanner.hasNextInt()) {
                return;
            }
            h= scanner.nextInt();
            RectangleRegion region = new RectangleRegion(x,y,w,h);
            List<Shape> list =manageShape.within(region);
            if(list.isEmpty()){
                System.out.println("No occurrences!");
                return;
            }
            for(Shape shape:list){
                System.out.println(shape.toUser());
            }
        }

    }
}
