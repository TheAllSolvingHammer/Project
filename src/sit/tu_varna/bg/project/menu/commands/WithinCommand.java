package sit.tu_varna.bg.project.menu.commands;

import sit.tu_varna.bg.project.contracts.ManageShape;
import sit.tu_varna.bg.project.contracts.MenuCommand;
import sit.tu_varna.bg.project.contracts.Shape;
import sit.tu_varna.bg.project.regions.CircleRegion;
import sit.tu_varna.bg.project.regions.RectangleRegion;
import sit.tu_varna.bg.project.shapes.ShapeManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WithinCommand implements MenuCommand {
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
        if(!command1.equalsIgnoreCase("within")){
            return;
        }
        if(!scanner.hasNext()){
            return;
        }
        String type= scanner.next();
        if(type.equalsIgnoreCase("circle")) {
            int x, y,r;
            if (!scanner.hasNextInt()) {
                System.out.println("X is not integer");
                return;
            }
            x = scanner.nextInt();
            if (!scanner.hasNextInt()) {
                System.out.println("Y is not integer");
                return;
            }
            y = scanner.nextInt();
            if (!scanner.hasNextInt()) {
                System.out.println("Radius is not an integer");
                return;
            }
            r= scanner.nextInt();
            CircleRegion region = new CircleRegion(x,y,r);
            List<Shape>list = new ArrayList<>(manageShape.within(region));
            if(list.isEmpty()){
                System.out.println("No occurrences!");
                return;
            }
            for(Shape shape:list){
                System.out.println(shape.toUser());
            }

        }
        else if(type.equalsIgnoreCase("rectangle")) {
            int x, y,w,h;
            if (!scanner.hasNextInt()) {
                System.out.println("X is not integer");
                return;
            }
            x = scanner.nextInt();
            if (!scanner.hasNextInt()) {
                System.out.println("Y is not integer");
                return;
            }
            y = scanner.nextInt();
            if (!scanner.hasNextInt()) {
                System.out.println("Width is not integer");
                return;
            }
            w= scanner.nextInt();
            if (!scanner.hasNextInt()) {
                System.out.println("Height is not integer");
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
