package sit.tu_varna.bg.project.shapes.circle;

import sit.tu_varna.bg.project.colors.NamedColors;
import sit.tu_varna.bg.project.shapes.AbstractShape;

public class Circle extends AbstractShape {
    private double centerX;
    private double centerY;
    private double radius;

    public Circle(NamedColors fill, double strokeWidth, NamedColors stroke,double centerX, double centerY, double radius) {
        super(fill, strokeWidth, stroke);
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }



    public double getCenterX() {
        return centerX;
    }

    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }



    @Override
    public String convertIntoString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<circle ").append(super.convertIntoString());
        sb.append (" cx=\""+centerX+"\" cy=\""+centerY+"\" r=\""+radius+"\" />");

        return sb.toString();
    }
}
