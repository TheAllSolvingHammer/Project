package sit.tu_varna.bg.project.readers.line;


import sit.tu_varna.bg.project.readers.ReaderAbstractShape;

import java.util.Scanner;
/**
 * Клас четец на линия, наследяващ абстрактния клас ReaderAbstractShape
 */
public class LineReaderShape extends ReaderAbstractShape {
    private String shapeString;
    /**
     * Конструктор реализиращ класа
     * @param shapeString низ съответстващ на фигурата
     */
    public LineReaderShape(String shapeString) {
        this.shapeString = shapeString;
    }

    /**
     * Метод за превърщане на фигурата в лесно четим за хората начин
     * @return низ предствляващ фигурата
     */
    @Override
    public String convertShapeToUserReadable() {
        Scanner scanner = new Scanner(shapeString);
        scanner.useDelimiter("[=\" ]+");

        scanner.next();

        StringBuilder formattedString = new StringBuilder();
        formattedString.append("line ");

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

        if (scanner.hasNext("x1")) {
            scanner.next();
            if (scanner.hasNextInt()) {
                formattedString.append(scanner.nextInt()).append(" ");
            } else {
                System.out.println("Error: 'x1' attribute is not an integer.");
                return null;
            }
        } else {
            System.out.println("Error: 'x1' attribute not found.");
            return null;
        }

        if (scanner.hasNext("y1")) {
            scanner.next();
            if (scanner.hasNextInt()) {
                formattedString.append(scanner.nextInt()).append(" ");
            } else {
                System.out.println("Error: 'y1' attribute is not an integer.");
                return null;
            }
        } else {
            System.out.println("Error: 'y1' attribute not found.");
            return null;
        }

        if (scanner.hasNext("x2")) {
            scanner.next();
            if (scanner.hasNextInt()) {
                formattedString.append(scanner.nextInt()).append(" ");
            } else {
                System.out.println("Error: 'x2' attribute is not an integer.");
                return null;
            }
        } else {
            System.out.println("Error: 'x2' attribute not found.");
            return null;
        }

        if (scanner.hasNext("y2")) {
            scanner.next();
            if (scanner.hasNextInt()) {
                formattedString.append(scanner.nextInt());
            } else {
                System.out.println("Error: 'y2' attribute is not an integer.");
                return null;
            }
        } else {
            System.out.println("Error: 'y2' attribute not found.");
            return null;
        }

        scanner.close();
        return formattedString.toString();
    }
}
