package sit.tu_varna.bg.project.readers.ellipse;

import sit.tu_varna.bg.project.contracts.ReaderShape;

import java.util.Scanner;

public class EllipseReaderShape implements ReaderShape {
    private String shapeString;

    public EllipseReaderShape(String shapeString) {
        this.shapeString = shapeString;
    }

    @Override
    public String convertShapeToUserReadable() {
        Scanner scanner = new Scanner(shapeString);
        scanner.useDelimiter("[=\" ]+");

        scanner.next();

        StringBuilder formattedString = new StringBuilder();
        formattedString.append("ellipse ");

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

        if (scanner.hasNext("rx")) {
            scanner.next();
            if (scanner.hasNextInt()) {
                formattedString.append(scanner.nextInt()).append(" ");
            } else {
                System.out.println("Error: 'rx' attribute is not an integer.");
                return null;
            }
        } else {
            System.out.println("Error: 'rx' attribute not found.");
            return null;
        }

        if (scanner.hasNext("ry")) {
            scanner.next();
            if (scanner.hasNextInt()) {
                formattedString.append(scanner.nextInt());
            } else {
                System.out.println("Error: 'ry' attribute is not an integer.");
                return null;
            }
        } else {
            System.out.println("Error: 'ry' attribute not found.");
            return null;
        }

        scanner.close();
        return formattedString.toString();
    }
}
