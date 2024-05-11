package sit.tu_varna.bg.project.readers;

import sit.tu_varna.bg.project.contracts.ReaderShape;

import java.util.Scanner;

public class PolygonReaderShape implements ReaderShape {
    private String shapeString;

    public PolygonReaderShape(String shapeString) {
        this.shapeString = shapeString;
    }

    @Override
    public String convertShapeToUserReadable() {
        Scanner scanner = new Scanner(shapeString);
        scanner.useDelimiter("[=\" ]+");

        scanner.next();

        StringBuilder formattedString = new StringBuilder();
        formattedString.append("polygon ");

        if (scanner.hasNext("fill")) {
            scanner.next();
            formattedString.append(scanner.next()).append(" ");
        } else {
            System.out.println("Error: 'fill' attribute not found.");
            return null;
        }

        if (scanner.hasNext("stroke")) {
            scanner.next();
            formattedString.append(scanner.next()).append(" ");
        } else {
            System.out.println("Error: 'stroke' attribute not found.");
            return null;
        }

        if (scanner.hasNext("stroke-width")) {
            scanner.next();
            if (scanner.hasNextDouble()) {
                formattedString.append(scanner.nextDouble()).append(" ");
            } else {
                System.out.println("Error: 'stroke-width' attribute is not a double.");
                return null;
            }
        } else {
            System.out.println("Error: 'stroke-width' attribute not found.");
            return null;
        }

        if (scanner.hasNext("points")) {
            scanner.next();
            formattedString.append(scanner.next());
        } else {
            System.out.println("Error: 'points' attribute not found.");
            return null;
        }

        scanner.close();
        return formattedString.toString();
    }
}
