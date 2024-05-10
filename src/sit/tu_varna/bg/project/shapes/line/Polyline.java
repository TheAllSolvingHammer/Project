package sit.tu_varna.bg.project.shapes.line;

import sit.tu_varna.bg.project.enums.NamedColors;
import sit.tu_varna.bg.project.shapes.AbstractShape;

import java.util.List;

public class Polyline extends AbstractShape {


    // moje da se nareche polygon no bez da svurzvame kraishtata mu
    // zashtoto polygon e zatvoren uchastuk
    //ima opciq za fill no ne svurzva dvata kraq
    private List<Integer> arrayOfCoordinates;

    public Polyline(NamedColors fill, double strokeWidth, NamedColors stroke,List<Integer> arrayOfCoordinates) {
        super(fill, strokeWidth, stroke);
        this.arrayOfCoordinates = arrayOfCoordinates;
    }


    @Override
    public String convertIntoString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<polyline ").append(super.convertIntoString());
        sb.append (" points=\"");
        for(int i=0;i<arrayOfCoordinates.size();i+=2){
            sb.append(arrayOfCoordinates.get(i)).append(",").append(arrayOfCoordinates.get(i+1)).append(" ");

        }

        sb.delete(sb.length()-1,sb.length());
        sb.append("\" />");
        return sb.toString();
    }

    @Override
    public void translateX(int sx) {
        for(int i=0;i<arrayOfCoordinates.size();i+=2){
            arrayOfCoordinates.set(i,arrayOfCoordinates.get(i)+sx);
        }
    }

    @Override
    public void translateY(int sy) {
        for(int i=1;i<arrayOfCoordinates.size();i+=2){
            arrayOfCoordinates.set(i,arrayOfCoordinates.get(i)+sy);
        }
    }

    public List<Integer> getArrayOfCoordinates() {
        return arrayOfCoordinates;
    }

    public void setArrayOfCoordinates(List<Integer> arrayOfCoordinates) {
        this.arrayOfCoordinates = arrayOfCoordinates;
    }
}
