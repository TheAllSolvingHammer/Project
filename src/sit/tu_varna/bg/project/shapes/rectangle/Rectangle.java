package sit.tu_varna.bg.project.shapes.rectangle;

import sit.tu_varna.bg.project.enums.NamedColors;
import sit.tu_varna.bg.project.shapes.AbstractShape;

public class Rectangle extends AbstractShape {
    private double initialX;
    private double initialY;
    private double width;
    private double height;
    private int roundCornerX=0;
    private int roundCornerY=0;

    public Rectangle(NamedColors fill, double strokeWidth, NamedColors stroke,double initialX, double initialY, double width, double height) {
        super(fill, strokeWidth, stroke);
        this.initialX = initialX;
        this.initialY = initialY;
        this.width = width;
        this.height = height;
    }

    public Rectangle(NamedColors fill, double strokeWidth, NamedColors stroke,double initialX, double initialY, double width, double height,int roundCornerX,int roundCornerY) {
        super(fill, strokeWidth, stroke);
        this.initialX = initialX;
        this.initialY = initialY;
        this.width = width;
        this.height = height;
        this.roundCornerX=roundCornerX;
        this.roundCornerY=roundCornerY;

    }

    @Override
    public String convertIntoString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<rect ").append(super.convertIntoString());
        if(roundCornerY>0 && roundCornerX>0) {
            sb.append(" x=\"" + initialX + "\" y=\"" + initialY + "\" width=\"" + width + "\" height=\""+height+"\" rx=\""+roundCornerX + "\" ry=\""+roundCornerY+"\" />");
        }
        else if(roundCornerY==0 && roundCornerX==0){
            sb.append(" x=\"" + initialX + "\" y=\"" + initialY + "\" width=\"" + width + "\" height=\""+height+"\" />");
        }

        return sb.toString();
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

    public void setRoundCornerX(int roundCornerX) {
        this.roundCornerX = roundCornerX;
    }

    public double getRoundCornerY() {
        return roundCornerY;
    }

    public void setRoundCornerY(int roundCornerY) {
        this.roundCornerY = roundCornerY;
    }
}
