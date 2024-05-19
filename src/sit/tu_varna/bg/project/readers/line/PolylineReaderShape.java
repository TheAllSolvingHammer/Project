package sit.tu_varna.bg.project.readers.line;

import sit.tu_varna.bg.project.readers.ReaderAbstractShape;

import java.util.Scanner;
/**
 * Клас четец на пречупена линия, наследяващ абстрактния клас ReaderAbstractShape
 */
public class PolylineReaderShape extends ReaderAbstractShape{
    private String shapeString;

    /**
     * Конструктор реализиращ класа
     * @param shapeString низ съответстващ на фигурата
     */
    public PolylineReaderShape(String shapeString) {
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
