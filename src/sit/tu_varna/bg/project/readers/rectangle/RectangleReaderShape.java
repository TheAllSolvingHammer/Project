package sit.tu_varna.bg.project.readers.rectangle;

import sit.tu_varna.bg.project.readers.ReaderAbstractShape;
import java.util.Map;

/**
 * Клас четец на правоъгълници, наследяващ абстрактния клас ReaderAbstractShape
 */
public class RectangleReaderShape extends ReaderAbstractShape {
    private String shapeString;

    /**
     * Конструктор реализиращ класа
     * @param shapeString низ съответстващ на фигурата
     */
    public RectangleReaderShape(String shapeString) {
        this.shapeString = shapeString;
    }

    /**
     * Метод за превърщане на фигурата в лесно четим за хората начин
     * @return низ предствляващ фигурата
     */
    @Override
    public String convertShapeToUserReadable() {
        Map<String, String> attributes = parseAttributes(shapeString);

        StringBuilder sb = new StringBuilder();
        sb.append("rectangle ");

        String fill = attributes.get("fill");
        if (fill != null && isValidColor(fill)) {
            sb.append(fill).append(" ");
        } else {
            System.out.println("Error: Invalid 'fill' attribute.");
            return null;
        }

        String stroke = attributes.get("stroke");
        if (stroke != null && isValidColor(stroke)) {
            sb.append(stroke).append(" ");
        } else {
            System.out.println("Error: Invalid 'stroke' attribute.");
            return null;
        }

        String strokeWidth = attributes.get("stroke-width");
        if (strokeWidth != null && isValidInteger(strokeWidth)) {
            sb.append(strokeWidth).append(" ");
        } else {
            System.out.println("Error: Invalid 'stroke-width' attribute.");
            return null;
        }

        String x = attributes.get("x");
        if (x != null && isValidInteger(x)) {
            sb.append(x).append(" ");
        } else {
            System.out.println("Error: Invalid 'x' attribute.");
            return null;
        }

        String y = attributes.get("y");
        if (y != null && isValidInteger(y)) {
            sb.append(y).append(" ");
        } else {
            System.out.println("Error: Invalid 'y' attribute.");
            return null;
        }

        String width = attributes.get("width");
        if (width != null && isValidInteger(width)) {
            sb.append(width).append(" ");
        } else {
            System.out.println("Error: Invalid 'width' attribute.");
            return null;
        }

        String height = attributes.get("height");
        if (height != null && isValidInteger(height)) {
            sb.append(height);
        } else {
            System.out.println("Error: Invalid 'height' attribute.");
            return null;
        }

        String rx = attributes.get("rx");
        String ry = attributes.get("ry");
        if (rx != null && ry != null && isValidInteger(rx) && isValidInteger(ry)) {
            sb.append(" ").append(rx).append(" ").append(ry);
        }

        return sb.toString();
    }
}
