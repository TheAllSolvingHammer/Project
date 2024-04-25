package sit.tu_varna.bg.project.shapes.rectangle;

import sit.tu_varna.bg.project.colors.NamedColors;
import sit.tu_varna.bg.project.shapes.AbstractShape;

public class Rectangle extends AbstractShape {
    private double initialX;
    private double initialY;
    private double width;
    private double height;
    private boolean rounded;
    private double roundCornerX=0;
    private double roundCornerY=0;

    public Rectangle(String name, NamedColors fill, double strokeWidth, NamedColors stroke,double initialX, double initialY, double width, double height) {
        super(name, fill, strokeWidth, stroke);
        this.initialX = initialX;
        this.initialY = initialY;
        this.width = width;
        this.height = height;
        rounded=false;
    }

    public Rectangle(String name, NamedColors fill, double strokeWidth, NamedColors stroke,double initialX, double initialY, double width, double height,double roundCornerX,double roundCornerY) {
        super(name, fill, strokeWidth, stroke);
        this.initialX = initialX;
        this.initialY = initialY;
        this.width = width;
        this.height = height;
        this.roundCornerX=roundCornerX;
        this.roundCornerY=roundCornerY;
        rounded=false;
    }


    public double getInitialX() {
        return initialX;
    }

    public void setInitialX(double initialX) {
        this.initialX = initialX;
    }

    public double getInitialY() {
        return initialY;
    }

    public void setInitialY(double initialY) {
        this.initialY = initialY;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getRoundCornerX() {
        return roundCornerX;
    }

    public void setRoundCornerX(double roundCornerX) {
        this.roundCornerX = roundCornerX;
    }

    public double getRoundCornerY() {
        return roundCornerY;
    }

    public void setRoundCornerY(double roundCornerY) {
        this.roundCornerY = roundCornerY;
    }
}
