package sit.tu_varna.bg.project.shapes.polygon;

import sit.tu_varna.bg.project.colors.NamedColors;
import sit.tu_varna.bg.project.shapes.AbstractShape;

public class Polygon extends AbstractShape {
    private double[] arrayOfCoordinates;


    public Polygon(String name, NamedColors fill, double strokeWidth, NamedColors stroke,double[] arrayOfCoordinates ){
        super(name, fill, strokeWidth, stroke);
        this.arrayOfCoordinates=arrayOfCoordinates;
    }
}
