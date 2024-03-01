package sit.tu_varna.bg.project;

public class Rectangle {
    private double initialX;
    private double initialY;
    private double width;
    private double height;
    private double roundCornerX;
    private double roundCornerY;

    public Rectangle(double initialX, double initialY, double width, double height) {
        this.initialX = initialX;
        this.initialY = initialY;
        this.width = width;
        this.height = height;
        roundCornerX=0;
        roundCornerY=0;
    }
    //Veroqtno i drug construktor

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
