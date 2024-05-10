package sit.tu_varna.bg.project.shapes.rectangle;

import sit.tu_varna.bg.project.enums.NamedColors;
import sit.tu_varna.bg.project.shapes.AbstractShape;

public class Rectangle extends AbstractShape {
    private int initialX;
    private int initialY;
    private int width;
    private int height;
    private int roundCornerX=0;
    private int roundCornerY=0;

    public Rectangle(NamedColors fill, int strokeWidth, NamedColors stroke,int initialX, int initialY, int width, int height) {
        super(fill, strokeWidth, stroke);
        this.initialX = initialX;
        this.initialY = initialY;
        this.width = width;
        this.height = height;
    }

    public Rectangle(NamedColors fill, int strokeWidth, NamedColors stroke,int initialX, int initialY, int width, int height,int roundCornerX,int roundCornerY) {
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

    @Override
    public void translateX(int sx) {
        setInitialX(getInitialX()+sx);
    }

    @Override
    public void translateY(int sy) {
        setInitialY(getInitialY()+sy);
    }


    public int getInitialX() {
        return initialX;
    }

    public void setInitialX(int initialX) {
        this.initialX = initialX;
    }

    public int getInitialY() {
        return initialY;
    }

    public void setInitialY(int initialY) {
        this.initialY = initialY;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getRoundCornerX() {
        return roundCornerX;
    }

    public void setRoundCornerX(int roundCornerX) {
        this.roundCornerX = roundCornerX;
    }

    public int getRoundCornerY() {
        return roundCornerY;
    }

    public void setRoundCornerY(int roundCornerY) {
        this.roundCornerY = roundCornerY;
    }
}
