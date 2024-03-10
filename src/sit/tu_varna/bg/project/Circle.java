package sit.tu_varna.bg.project;

public class Circle extends Shape implements InvalidEntriesForShapes{
    private double centerX;
    private double centerY;
    private double radius;

    public Circle(double centerX, double centerY, double radius, String name) {
        super(name);
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
    public boolean isShapeValid() {
        return !(radius <= 0);
    }
}
