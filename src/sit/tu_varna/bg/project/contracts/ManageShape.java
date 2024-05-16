package sit.tu_varna.bg.project.contracts;

import sit.tu_varna.bg.project.regions.CircleRegion;
import sit.tu_varna.bg.project.regions.RectangleRegion;

import java.util.List;

public interface ManageShape {
    List<Shape> getShapes();
    void addShape(Shape shape);
    void removeShape(int index);
    List<Shape> within(RectangleRegion region);
    List<Shape> within(CircleRegion region);
    void translate(int x, int y);
    String getItemsToUser();

}
