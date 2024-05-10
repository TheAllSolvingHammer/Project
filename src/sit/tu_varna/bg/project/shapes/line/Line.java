package sit.tu_varna.bg.project.shapes.line;

import sit.tu_varna.bg.project.enums.NamedColors;
import sit.tu_varna.bg.project.contracts.Shape;

public class Line implements Shape {
    private int strokeWidth;
    private NamedColors color;
    private int startX;
    private int startY;
    private int endX;
    private int endY;



    public Line(int strokeWidth, NamedColors color,int startX, int startY, int endX, int endY) {
        this.strokeWidth = strokeWidth;
        this.color = color;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;

    }

    @Override
    public String convertIntoString() {
            return "<line stroke-width=\""+strokeWidth+"\" stroke=\""+color+"\" x1=\""+startX+"\" y1=\""+startY+"\" x2=\""+endX+"\" y2=\""+endY+"\" />";
    }

    @Override
    public void translateX(int sx) {
        setStartX(getStartX()+sx);
        setEndX(getEndX()+sx);
    }

    @Override
    public void translateY(int sy) {
        setStartY(getStartY()+sy);
        setEndY(getEndY()+sy);

    }

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public NamedColors getColor() {
        return color;
    }

    public void setColor(NamedColors color) {
        this.color = color;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getEndX() {
        return endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public int getEndY() {
        return endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }
}
