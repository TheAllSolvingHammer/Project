package sit.tu_varna.bg.project.creator.circle;

import sit.tu_varna.bg.project.contracts.Shape;
import sit.tu_varna.bg.project.creator.AbstractCreator;
import sit.tu_varna.bg.project.enums.NamedColors;
import sit.tu_varna.bg.project.shapes.circle.Circle;


import java.util.Locale;
import java.util.Scanner;

public class CircleCreator extends AbstractCreator {
    public CircleCreator(String parameters) {
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
        if (!scanner.hasNextDouble()) {
            System.out.println("Passed value for stroke width is not a real number!");
            return null;
        }
        double strokeWidth = scanner.nextDouble();
        if (!scanner.hasNextDouble()) {
            System.out.println("Passed value for X coordinate is not a real number!");
            return null;
        }
        double initialX = scanner.nextDouble();
        if (!scanner.hasNextDouble()) {
            System.out.println("Passed value for Y coordinate is not a real number!");
            return null;
        }
        double initialY = scanner.nextDouble();
        if (!scanner.hasNextDouble()) {
            System.out.println("Passed value for width is not a real number!");
            return null;
        }
        double radius = scanner.nextDouble();
       return new Circle(fill,strokeWidth,stroke,initialX,initialY,radius);
    }

}
