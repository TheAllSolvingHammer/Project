package sit.tu_varna.bg.project.creator.rectangle;

import sit.tu_varna.bg.project.colors.NamedColors;
import sit.tu_varna.bg.project.contracts.Creator;
import sit.tu_varna.bg.project.contracts.Shape;
import sit.tu_varna.bg.project.shapes.rectangle.Rectangle;

import java.util.Locale;
import java.util.Scanner;

public class RectangleCreator implements Creator {
    private String parameters;

    public RectangleCreator(String parameters) {
        this.parameters = parameters;
    }

    @Override
    public Shape createShape() {
        Scanner scanner = new Scanner(parameters);
        if (!scanner.hasNext()) {
            System.out.println("Not enough arguments!");
            return null;
        }
        String fillColor = scanner.next();
        if (!isValidColor(fillColor)) {
            System.out.println("Fill color is not valid!");
            return null;
        }
        NamedColors fill = NamedColors.valueOf(fillColor.toUpperCase(Locale.ROOT));
        if (!scanner.hasNext()) {
            System.out.println("Not enough arguments!");
            return null;
        }
        String strokeColor = scanner.next();
        if (!isValidColor(strokeColor)) {
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
        double width = scanner.nextDouble();
        if (!scanner.hasNextDouble()) {
            System.out.println("Passed value for height is not a real number!");
            return null;
        }
        double height = scanner.nextDouble();
        int roundCornerX = 0;
        int roundCornerY = 0;
        if (scanner.hasNextInt()) {
            roundCornerX = scanner.nextInt();
        }
        if (scanner.hasNextInt()) {
            roundCornerY = scanner.nextInt();
        }
        if (roundCornerY == 0 || roundCornerX == 0) {
            return new Rectangle(fill, strokeWidth, stroke, initialX, initialY, width, height);
        } else {
            return new Rectangle(fill, strokeWidth, stroke, initialX, initialY, width, height, roundCornerX, roundCornerY);
        }
    }

    @Override
    public boolean isValidColor(String color) {
        for (NamedColors namedColor : NamedColors.values()) {
            if (namedColor.name().equalsIgnoreCase(color)) {
                return true;
            }
        }
        return false;
    }

}