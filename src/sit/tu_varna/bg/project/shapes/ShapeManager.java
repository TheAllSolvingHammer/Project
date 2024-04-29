package sit.tu_varna.bg.project.shapes;


import sit.tu_varna.bg.project.contracts.ManageShape;
import sit.tu_varna.bg.project.contracts.Shape;

import java.util.ArrayList;
import java.util.List;


public class ShapeManager implements ManageShape {
    private List<Shape> shapes;

    public ShapeManager() {
        shapes= new ArrayList<>();
    }


    @Override
    public List<Shape> getShapes() {
        return shapes;
    }

    @Override
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    @Override
    public void removeShape(int index) {
        if(index<0 || index>shapes.size()){
            return;
        }
        if(shapes.isEmpty()){
            return;
        }
        shapes.remove(index);
    }

    @Override
    public List<Shape> within(double x,double y,double sideOne,double sideTwo) {
        for(Shape s: shapes){

        }
        return null;
    }

    @Override
    public List<Shape> within(double x, double y, double radius) {
        return null;
    }

}
