package sit.tu_varna.bg.project.contracts;

import java.util.List;

public interface ManageShape {
    List<Shape> getShapes();
    void addShape(Shape shape);
    void removeShape(int index);
    List<Shape> within(double x,double y,double sideOne,double sideTwo);
    List<Shape> within(double x,double y,double radius);

}
