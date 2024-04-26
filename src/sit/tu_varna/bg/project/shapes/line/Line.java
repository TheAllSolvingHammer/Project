package sit.tu_varna.bg.project.shapes.line;

import sit.tu_varna.bg.project.colors.NamedColors;
import sit.tu_varna.bg.project.shapes.Shape;

public class Line implements Shape {
    private String name;
    private double startX;
    private double startY;
    private double endX;
    private double endY;
    private double strokeWidth;
    private NamedColors color;

    public Line(String name, double startX, double startY, double endX, double endY, double strokeWidth, NamedColors color) {
        this.name = name;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.strokeWidth = strokeWidth;
        this.color = color;
    }

    public Line(double startX, double startY, double endX, double endY, double strokeWidth, NamedColors color) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.strokeWidth = strokeWidth;
        this.color = color;
        this.name=null;
    }

    @Override
    public String convertIntoString() {

        if(name==null || name.isEmpty()){
            return "<line stroke-width=\""+strokeWidth+"\" stroke=\""+color+"\" x1=\""+startX+"\" y1=\""+startY+"\" x2=\""+endX+"\" y2=\""+endY+"\" />";
        }
        else {
            return "<line name=\""+name+"\" stroke-width=\"" + strokeWidth + "\" stroke=\"" + color + "\" x1=\"" + startX + "\" y1=\"" + startY + "\" x2=\"" + endX + "\" y2=\"" + endY + "\" />";
        }


    }

}
