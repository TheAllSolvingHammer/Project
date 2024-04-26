package sit.tu_varna.bg.project.shapes;


import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class ShapeManager implements Shape{
    private Set<Shape> shapes;

    public ShapeManager() {
        shapes= new HashSet<>();
    }
    public void addShapes(Shape shape){
        shapes.add(shape);
    }

    @Override
    public String convertIntoString() {
        if(shapes.isEmpty()){
            System.out.println("You can not parse 0 amout of figures");
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
}
