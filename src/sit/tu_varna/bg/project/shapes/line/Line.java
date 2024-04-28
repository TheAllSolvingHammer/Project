package sit.tu_varna.bg.project.shapes.line;

import sit.tu_varna.bg.project.enums.NamedColors;
import sit.tu_varna.bg.project.contracts.Shape;

public class Line implements Shape {
    private double startX;
    private double startY;
    private double endX;
    private double endY;
    private double strokeWidth;
    private NamedColors color;



    public Line(double startX, double startY, double endX, double endY, double strokeWidth, NamedColors color) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.strokeWidth = strokeWidth;
        this.color = color;

    }

    @Override
    public String convertIntoString() {
            return "<line stroke-width=\""+strokeWidth+"\" stroke=\""+color+"\" x1=\""+startX+"\" y1=\""+startY+"\" x2=\""+endX+"\" y2=\""+endY+"\" />";
    }

}
