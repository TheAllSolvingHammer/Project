package sit.tu_varna.bg.project.readers.circle;

import sit.tu_varna.bg.project.contracts.ReaderShape;
import sit.tu_varna.bg.project.readers.ReaderAbstractShape;

import java.util.Map;
import java.util.Scanner;

public class CircleReaderShape extends ReaderAbstractShape implements ReaderShape {
    private String shapeString;

    public CircleReaderShape(String shapeString) {
        this.shapeString = shapeString;
    }


    @Override
    public String convertShapeToUserReadable() {
        Map<String, String> attributes = parseAttributes(shapeString);

        StringBuilder sb = new StringBuilder();
        sb.append("circle ");

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

        String cx = attributes.get("cx");
        if (cx != null && isValidInteger(cx)) {
            sb.append(cx).append(" ");
        } else {
            System.out.println("Error: Invalid 'cx' attribute.");
            return null;
        }

        String cy = attributes.get("cy");
        if (cy != null && isValidInteger(cy)) {
            sb.append(cy).append(" ");
        } else {
            System.out.println("Error: Invalid 'cy' attribute.");
            return null;
        }

        String r = attributes.get("r");
        if (r != null && isValidInteger(r)) {
            sb.append(r);
        } else {
            System.out.println("Error: Invalid 'r' attribute.");
            return null;
        }

        return sb.toString();
    }
}
