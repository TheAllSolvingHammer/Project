package sit.tu_varna.bg.project.shapes.polygon;

import sit.tu_varna.bg.project.colors.NamedColors;
import sit.tu_varna.bg.project.shapes.AbstractShape;

import java.util.List;

public class Polygon extends AbstractShape {
    private List<Integer> arrayOfCoordinates;

    public Polygon(NamedColors fill, double strokeWidth, NamedColors stroke,List<Integer> arrayOfCoordinates) {
        super(fill, strokeWidth, stroke);
        this.arrayOfCoordinates = arrayOfCoordinates;
    }


    @Override
    public String convertIntoString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<polygon ").append(super.convertIntoString());
        sb.append (" points=\"");
        for(int i=1;i<arrayOfCoordinates.size();i+=2){
            sb.append(arrayOfCoordinates.get(i-1)).append(",").append(arrayOfCoordinates.get(i)).append(" ");

        }

        sb.delete(sb.length()-1,sb.length());
        sb.append("\" />");
        return sb.toString();
    }

    public List<Integer> getArrayOfCoordinates() {
        return arrayOfCoordinates;
    }

    public void setArrayOfCoordinates(List<Integer> arrayOfCoordinates) {
        this.arrayOfCoordinates = arrayOfCoordinates;
    }
}
