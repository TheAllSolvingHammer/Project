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
        NamedColors fill;
        NamedColors stroke;
        double strokeWidth;
        double initialX;
        double initialY;
        double width;
        double height;
        int roundCornerX = 0;
        int roundCornerY = 0;
            fill = NamedColors.valueOf(scanner.next().toUpperCase());
            stroke = NamedColors.valueOf(scanner.next().toUpperCase());
            strokeWidth = scanner.nextDouble();
            initialX = scanner.nextDouble();
            initialY = scanner.nextDouble();
            width = scanner.nextDouble();
            height = scanner.nextDouble();

            if (scanner.hasNextInt()) {
                roundCornerX = scanner.nextInt();
                if (scanner.hasNextInt()) {
                    roundCornerY = scanner.nextInt();
                }
            }
            if(roundCornerY==0 || roundCornerX==0){
                return new Rectangle(fill, strokeWidth, stroke, initialX, initialY, width, height);
            }
            else return new Rectangle(fill, strokeWidth, stroke, initialX, initialY, width, height, roundCornerX, roundCornerY);
    }

}
