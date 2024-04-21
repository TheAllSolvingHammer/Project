package sit.tu_varna.bg.project.shapes;

import sit.tu_varna.bg.project.colors.NamedColors;

public class ShapeImpl implements Shape{
    private String name;
    private NamedColors fill;
    private double strokeWidth;
    private NamedColors stroke;

    public ShapeImpl(String name, NamedColors fill, double strokeWidth, NamedColors stroke) {
        this.name = name;
        this.fill = fill;
        this.strokeWidth = strokeWidth;
        this.stroke = stroke;
    }

    @Override
    public String convertIntoString() {
        return "name=\""+this.name+"\"";
    }
}
