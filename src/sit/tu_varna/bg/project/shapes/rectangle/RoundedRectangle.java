package sit.tu_varna.bg.project.shapes.rectangle;

public class RoundedRectangle extends Rectangle{
    private double rx;
    private double ry;

    public RoundedRectangle(double initialX, double initialY, double width, double height,double rx, double ry) {
        super(initialX, initialY, width, height);
        this.rx=rx;
        this.ry=ry;
    }
}
