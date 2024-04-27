package sit.tu_varna.bg.project.shapes;

import sit.tu_varna.bg.project.colors.NamedColors;
import sit.tu_varna.bg.project.contracts.Shape;

public abstract class AbstractShape implements Shape {

    private NamedColors fill;
    private double strokeWidth;
    private NamedColors stroke;

    public AbstractShape(NamedColors fill, double strokeWidth, NamedColors stroke) {

        this.fill = fill;
        this.strokeWidth = strokeWidth;
        this.stroke = stroke;
    }

    @Override
    public String convertIntoString() {

            return "fill=\""+fill+"\" stroke=\""+stroke+"\" stroke-width=\""+strokeWidth+"\"";
    }



    public NamedColors getFill() {
        return fill;
    }

    public void setFill(NamedColors fill) {
        this.fill = fill;
    }

    public double getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(double strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public NamedColors getStroke() {
        return stroke;
    }

    public void setStroke(NamedColors stroke) {
        this.stroke = stroke;
    }

}
