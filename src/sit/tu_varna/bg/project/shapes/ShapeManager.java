package sit.tu_varna.bg.project.shapes;


import sit.tu_varna.bg.project.contracts.ManageShape;
import sit.tu_varna.bg.project.contracts.Shape;

import java.util.HashSet;
import java.util.Set;


public class ShapeManager implements ManageShape {
    private Set<Shape> shapes;

    public ShapeManager() {
        shapes= new HashSet<>();
    }


    @Override
    public Set<Shape> getShapes() {
        return shapes;
    }

    @Override
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    @Override
    public void removeShape(Shape shape) {
        if(shapes.isEmpty()){
            return;
        }
        shapes.remove(shape);
    }
}
