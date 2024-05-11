package sit.tu_varna.bg.project.readers;

import sit.tu_varna.bg.project.contracts.ReaderShape;

import java.util.Scanner;

public class CircleReaderShape implements ReaderShape {
    private String shapeString;

    public CircleReaderShape(String shapeString) {
        this.shapeString = shapeString;
    }


    @Override
    public String convertShapeToUserReadable() {
        // String s1 = "<circle fill=\"BLUE\" stroke=\"GREEN\" stroke-width=\"2\" cx=\"30\" cy=\"20\" r=\"10\" />";

        Scanner scanner = new Scanner(shapeString);
        scanner.useDelimiter("[=\" ]+");

        scanner.next();

        StringBuilder formattedString = new StringBuilder();
        formattedString.append("circle ");

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
                System.out.println("Error: 'stroke-width' attribute is not an integer.");
                return null;
            }
        } else {
            System.out.println("Error: 'stroke-width' attribute not found.");
            return null;
        }

        if (scanner.hasNext("cx")) {
            scanner.next();
            if (scanner.hasNextInt()) {
                formattedString.append(scanner.nextInt()).append(" ");
            } else {
                System.out.println("Error: 'cx' attribute is not an integer.");
                return null;
            }
        } else {
            System.out.println("Error: 'cx' attribute not found.");
            return null;
        }

        if (scanner.hasNext("cy")) {
            scanner.next();
            if (scanner.hasNextInt()) {
                formattedString.append(scanner.nextInt()).append(" ");
            } else {
                System.out.println("Error: 'cy' attribute is not an integer.");
                return null;
            }
        } else {
            System.out.println("Error: 'cy' attribute not found.");
            return null;
        }

        if (scanner.hasNext("r")) {
            scanner.next();
            if (scanner.hasNextInt()) {
                formattedString.append(scanner.nextInt());
            } else {
                System.out.println("Error: 'r' attribute is not an integer.");
                return null;
            }
        } else {
            System.out.println("Error: 'r' attribute not found.");
            return null;
        }

        scanner.close();
        return formattedString.toString();

    }
}
