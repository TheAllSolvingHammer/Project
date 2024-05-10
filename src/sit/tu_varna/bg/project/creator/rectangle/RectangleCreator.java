package sit.tu_varna.bg.project.creator.rectangle;

import sit.tu_varna.bg.project.creator.AbstractCreator;
import sit.tu_varna.bg.project.enums.NamedColors;
import sit.tu_varna.bg.project.contracts.Creator;
import sit.tu_varna.bg.project.contracts.Shape;
import sit.tu_varna.bg.project.shapes.rectangle.Rectangle;

import java.util.Locale;
import java.util.Scanner;

public class RectangleCreator extends AbstractCreator {
    private String parameters;

    public RectangleCreator(String parameters) {
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
            System.out.println("Passed value for width is not a real number!");
            return null;
        }
        int width = scanner.nextInt();
        if (!scanner.hasNextInt()) {
            System.out.println("Passed value for height is not a real number!");
            return null;
        }
        int height = scanner.nextInt();
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

}
