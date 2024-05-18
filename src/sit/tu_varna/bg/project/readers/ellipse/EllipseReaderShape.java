package sit.tu_varna.bg.project.readers.ellipse;

import sit.tu_varna.bg.project.contracts.ReaderShape;
import sit.tu_varna.bg.project.readers.ReaderAbstractShape;

import java.util.Map;
import java.util.Scanner;

public class EllipseReaderShape extends ReaderAbstractShape implements ReaderShape {
    private String shapeString;

    public EllipseReaderShape(String shapeString) {
        this.shapeString = shapeString;
    }

    @Override
    public String convertShapeToUserReadable() {
        Map<String, String> attributes = parseAttributes(shapeString);

        StringBuilder sb = new StringBuilder();
        sb.append("ellipse ");

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

        String rx = attributes.get("rx");
        if (rx != null && isValidInteger(rx)) {
            sb.append(rx).append(" ");
        } else {
            System.out.println("Error: Invalid 'rx' attribute.");
            return null;
        }

        String ry = attributes.get("ry");
        if (ry != null && isValidInteger(ry)) {
            sb.append(ry);
        } else {
            System.out.println("Error: Invalid 'ry' attribute.");
            return null;
        }

        return sb.toString();
    }

}
