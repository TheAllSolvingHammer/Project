package sit.tu_varna.bg.project.shapes;

import sit.tu_varna.bg.project.enums.NamedColors;
import sit.tu_varna.bg.project.contracts.Shape;

import java.util.Locale;


public abstract class AbstractShape implements Shape {


    private NamedColors fill;
    private int strokeWidth;
    private NamedColors stroke;

    /**
     * Конструктор на абстрактен клас AbstractShape
     * @param fill - запълване на дадената фигура
     * @param strokeWidth - дебелина на линията описваща фигурата
     * @param stroke - цвят на линията
     */
    public AbstractShape(NamedColors fill, int strokeWidth, NamedColors stroke) {

        this.fill = fill;
        this.strokeWidth = strokeWidth;
        this.stroke = stroke;
    }

    /**
     * Метод който връща низ, представляващ атрибутите на всички фигури. Този метод ще бъде използван от
     * класове наследяващи абстрактния
     * @return низ с астрибути
     */
    @Override
    public String convertIntoString() {

            return "fill=\""+fill+"\" stroke=\""+stroke+"\" stroke-width=\""+strokeWidth+"\"";
    }

    @Override
    public String toUser() {
        StringBuilder sb1= new StringBuilder();
        sb1.append(fill.toString().toLowerCase(Locale.ROOT)).append(" ").append(stroke.toString().toLowerCase(Locale.ROOT))
                .append(" ").append(strokeWidth);
        return sb1.toString();
    }


    public NamedColors getFill() {
        return fill;
    }

    public void setFill(NamedColors fill) {
        this.fill = fill;
    }

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public NamedColors getStroke() {
        return stroke;
    }

    public void setStroke(NamedColors stroke) {
        this.stroke = stroke;
    }

}
