package sit.tu_varna.bg.project.readers.polygon;

import sit.tu_varna.bg.project.contracts.ReaderShape;
import sit.tu_varna.bg.project.readers.ReaderAbstractShape;

import java.util.Map;
import java.util.Scanner;

public class PolygonReaderShape extends ReaderAbstractShape implements ReaderShape {
    private String shapeString;

    public PolygonReaderShape(String shapeString) {
        this.shapeString = shapeString;
    }

    @Override
    public String convertShapeToUserReadable() {
        Map<String, String> attributes = parseAttributes(shapeString);

        StringBuilder sb = new StringBuilder();
        sb.append("polyline ");

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

        String points = attributes.get("points");
        if (points != null) {
            sb.append(points);
        } else {
            System.out.println("Error: 'points' attribute not found.");
            return null;
        }

        return sb.toString();
    }

}
