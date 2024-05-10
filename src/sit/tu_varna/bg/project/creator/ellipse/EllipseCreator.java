package sit.tu_varna.bg.project.creator.ellipse;

import sit.tu_varna.bg.project.contracts.Shape;
import sit.tu_varna.bg.project.creator.AbstractCreator;
import sit.tu_varna.bg.project.enums.NamedColors;
import sit.tu_varna.bg.project.shapes.elipse.Ellipse;

import java.util.Locale;
import java.util.Scanner;

public class EllipseCreator extends AbstractCreator {
    public EllipseCreator(String parameters) {
        super(parameters);
    }

    @Override
    public Shape createShape() {
        Scanner scanner = new Scanner(getParameters());
        if (!scanner.hasNext()) {
            System.out.println("Not enough arguments!");
            return null;
        }
        String fillColor = scanner.next();
        if (!validColor(fillColor)) {
            System.out.println("Fill color is not valid!");
            return null;
        }
        NamedColors fill = NamedColors.valueOf(fillColor.toUpperCase(Locale.ROOT));
        if (!scanner.hasNext()) {
            System.out.println("Not enough arguments!");
            return null;
        }
        String strokeColor = scanner.next();
        if (!validColor(strokeColor)) {
            System.out.println("Stroke color is not valid!");
            return null;
        }
        NamedColors stroke = NamedColors.valueOf(strokeColor.toUpperCase(Locale.ROOT));
        if (!scanner.hasNextInt()) {
            System.out.println("Passed value for stroke width is not a real number!");
            return null;
        }
        int strokeWidth = scanner.nextInt();
        if (!scanner.hasNextInt()) {
            System.out.println("Passed value for X coordinate is not a real number!");
            return null;
        }
        int initialX = scanner.nextInt();
        if (!scanner.hasNextInt()) {
            System.out.println("Passed value for Y coordinate is not a real number!");
            return null;
        }
        int initialY = scanner.nextInt();
        if (!scanner.hasNextInt()) {
            System.out.println("Passed value for radius is not a real number!");
            return null;
        }
        int radiusX = scanner.nextInt();
        if (!scanner.hasNextInt()) {
            System.out.println("Passed value for radius is not a real number!");
            return null;
        }
        int radiusY = scanner.nextInt();
        return new Ellipse(fill,strokeWidth,stroke,initialX,initialY,radiusX,radiusY);
    }
}
