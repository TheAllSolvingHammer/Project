package sit.tu_varna.bg.project.readers.polygon;


import sit.tu_varna.bg.project.readers.ReaderAbstractShape;

import java.util.Scanner;


/**
 * Клас четец на многоъгълници, наследяващ абстрактния клас ReaderAbstractShape
 */
public class PolygonReaderShape extends ReaderAbstractShape {
    private String shapeString;

    /**
     * Конструктор реализиращ класа
     * @param shapeString низ съответстващ на фигурата
     */
    public PolygonReaderShape(String shapeString) {
        this.shapeString = shapeString;
    }

    /**
     * Метод за превърщане на фигурата в лесно четим за хората начин
     * @return низ предствляващ фигурата
     */
    @Override
    public String convertShapeToUserReadable() {
        Scanner scanner = new Scanner(shapeString);
        scanner.useDelimiter("[ =\"/,<>]+");
        StringBuilder sb = new StringBuilder();
        if (!scanner.hasNext()) {
            return null;
        }

        String s1 = scanner.next();
        if (!s1.equalsIgnoreCase("polygon")) {
            return null;
        }
        sb.append(s1).append(" ");

        while (scanner.hasNext()) {
            String attribute = scanner.next();
            switch (attribute) {
                case "fill":
                    String fill = scanner.next();
                    if (!isValidColor(fill)) {
                        System.out.println("Error: Invalid 'fill' attribute.");
                        return null;
                    }
                    sb.append(fill).append(" ");
                    break;
                case "stroke":
                    String stroke = scanner.next();
                    if (!isValidColor(stroke)) {
                        System.out.println("Error: Invalid 'stroke' attribute.");
                        return null;
                    }
                    sb.append(stroke).append(" ");
                    break;
                case "stroke-width":
                    String strokeWidth = scanner.next();
                    if (!isValidInteger(strokeWidth)) {
                        System.out.println("Error: Invalid 'stroke-width' attribute.");
                        return null;
                    }
                    sb.append(strokeWidth).append(" ");
                    break;
                case "points":

                    while (scanner.hasNextInt()) {
                        sb.append(scanner.nextInt()).append(" ");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append(" ");
                    break;
                default:
                    scanner.next();
                    break;
            }
        }
        return sb.toString();
    }

}
