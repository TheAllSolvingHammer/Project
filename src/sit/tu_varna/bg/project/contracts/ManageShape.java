package sit.tu_varna.bg.project.contracts;

import java.util.List;

public interface ManageShape {
    List<Shape> getShapes();
    void addShape(Shape shape);
    void removeShape(Shape shape);

}
