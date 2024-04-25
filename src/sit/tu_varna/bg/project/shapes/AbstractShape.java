package sit.tu_varna.bg.project.shapes;

import sit.tu_varna.bg.project.colors.NamedColors;

public abstract class AbstractShape implements Shape{
    private String name;
    private NamedColors fill;
    private double strokeWidth;
    private NamedColors stroke;

    public AbstractShape(String name, NamedColors fill, double strokeWidth, NamedColors stroke) {
        this.name = name;
        this.fill = fill;
        this.strokeWidth = strokeWidth;
        this.stroke = stroke;
    }

    @Override
    public String convertIntoString() {
        return "name=\""+name+"\" fill=\""+fill+"\" stroke=\""+stroke+"\" stroke-width=\""+strokeWidth+"\"";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
