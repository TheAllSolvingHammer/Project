package sit.tu_varna.bg.project.readers.line;

import sit.tu_varna.bg.project.contracts.ReaderShape;

import java.util.Scanner;

public class PolylineReaderShape implements ReaderShape {
    private String shapeString;

    public PolylineReaderShape(String shapeString) {
        this.shapeString = shapeString;
    }

    @Override
    public String convertShapeToUserReadable() {
        Scanner scanner = new Scanner(shapeString);
        scanner.useDelimiter("[=\" ]+");

        scanner.next();

        StringBuilder formattedString = new StringBuilder();
        formattedString.append("polyline ");

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
            if (scanner.hasNextInt()) {
                formattedString.append(scanner.nextInt()).append(" ");
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
