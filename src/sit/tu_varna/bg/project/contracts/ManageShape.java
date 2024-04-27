package sit.tu_varna.bg.project.contracts;

import java.util.Set;

public interface ManageShape {
    Set<Shape> getShapes();
    void addShape(Shape shape);
    void removeShape(Shape shape);

}
