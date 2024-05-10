package sit.tu_varna.bg.project.shapes.circle;

import sit.tu_varna.bg.project.enums.NamedColors;
import sit.tu_varna.bg.project.shapes.AbstractShape;

public class Circle extends AbstractShape {
    private int centerX;
    private int centerY;
    private int radius;

    public Circle(NamedColors fill, int strokeWidth, NamedColors stroke,int centerX, int centerY, int radius) {
        super(fill, strokeWidth, stroke);
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }



    public int getCenterX() {
        return centerX;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }



    @Override
    public String convertIntoString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<circle ").append(super.convertIntoString());
        sb.append (" cx=\""+centerX+"\" cy=\""+centerY+"\" r=\""+radius+"\" />");

        return sb.toString();
    }

    @Override
    public void translateX(int sx) {
        setCenterX(getCenterX()+sx);
    }

    @Override
    public void translateY(int sy) {
        setCenterY(getCenterY()+sy);
    }

}
