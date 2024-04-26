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
    public String convertToText() {
        if(shapes.isEmpty()){
            System.out.println("You can not parse 0 amount of figures");
            return null;
        }
        else{
            StringBuilder sb=new StringBuilder();
            for(Shape s: shapes){
                sb.append(s.convertIntoString());
                sb.append("\n");
            }
            sb.delete(sb.length()-1,sb.length());
            return sb.toString();
        }

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
