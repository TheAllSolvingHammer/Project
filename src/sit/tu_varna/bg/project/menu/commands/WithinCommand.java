package sit.tu_varna.bg.project.menu.commands;

import sit.tu_varna.bg.project.contracts.MenuCommand;
import sit.tu_varna.bg.project.contracts.Shape;
import sit.tu_varna.bg.project.exceptions.RegionException;
import sit.tu_varna.bg.project.regions.CircleRegion;
import sit.tu_varna.bg.project.regions.RectangleRegion;
import sit.tu_varna.bg.project.shapes.ShapeManager;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Клас за командата Within
 */
public class WithinCommand implements MenuCommand {
    /**
     * Метод обработващ командата
     * @param command командата която се подава
     */
    @Override
    public void execute(String command) {
        try {
            ShapeManager manageShape = ShapeManager.getInstance();
            List<Shape> list = new ArrayList<>();
            Scanner scanner = new Scanner(command);
            scanner.next();
            String type = scanner.next();
            if (type.equalsIgnoreCase("circle")) {
                int x, y, r;
                x = scanner.nextInt();
                y = scanner.nextInt();
                r = scanner.nextInt();
                CircleRegion region = new CircleRegion(x, y, r);
                list = manageShape.within(region);
            } else if (type.equalsIgnoreCase("rectangle")) {
                int x, y, w, h;
                x = scanner.nextInt();
                y = scanner.nextInt();
                w = scanner.nextInt();
                h = scanner.nextInt();
                RectangleRegion region = new RectangleRegion(x, y, w, h);
                list = manageShape.within(region);
            }
            for (Shape shape : list) {
                System.out.println(shape.toUser());
            }
        }catch (NoSuchElementException e) {
            System.out.println("No elements");
        }catch (RegionException e){
            System.out.println(e.getMessage());
        }


    }
}
