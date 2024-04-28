package sit.tu_varna.bg.project.creator.line;

import sit.tu_varna.bg.project.contracts.Shape;
import sit.tu_varna.bg.project.creator.AbstractCreator;
import sit.tu_varna.bg.project.enums.NamedColors;
import sit.tu_varna.bg.project.shapes.line.Line;


import java.util.Locale;
import java.util.Scanner;

public class LineCreator extends AbstractCreator {
    public LineCreator(String parameters) {
        super(parameters);
    }

    @Override
    public Shape createShape() {
        Scanner scanner = new Scanner(getParameters());
        if (!scanner.hasNextDouble()) {
            System.out.println("Passed value for stroke width is not a real number!");
            return null;
        }
        double strokeWidth = scanner.nextDouble();
        if (!scanner.hasNext()) {
            System.out.println("Not enough arguments!");
            return null;
        }
        String strokeColor = scanner.next();
        if (!validColor(strokeColor)) {
            System.out.println("Fill color is not valid!");
            return null;
        }
        NamedColors stroke = NamedColors.valueOf(strokeColor.toUpperCase(Locale.ROOT));

        if (!scanner.hasNextDouble()) {
            System.out.println("Passed value for X1 coordinate is not a real number!");
            return null;
        }
        double x1 = scanner.nextDouble();
        if (!scanner.hasNextDouble()) {
            System.out.println("Passed value for Y1 coordinate is not a real number!");
            return null;
        }
        double y1 = scanner.nextDouble();
        if (!scanner.hasNextDouble()) {
            System.out.println("Passed value for X2 coordinate is not a real number!");
            return null;
        }
        double x2 = scanner.nextDouble();
        if (!scanner.hasNextDouble()) {
            System.out.println("Passed value for Y2 coordinate is not a real number!");
            return null;
        }
        double y2 = scanner.nextDouble();
        return new Line(strokeWidth,stroke,x1,y1,x2,y2);
    }
}
