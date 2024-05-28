package sit.tu_varna.bg.project.shapes;

import sit.tu_varna.bg.project.enums.NamedColors;
import sit.tu_varna.bg.project.contracts.Shape;
import sit.tu_varna.bg.project.exceptions.FigureException;

import java.util.Locale;


public abstract class AbstractShape implements Shape {

    private NamedColors fill;
    private int strokeWidth;
    private NamedColors stroke;

    /**
     * Конструктор на абстрактен клас AbstractShape.
     * @param fill - запълване на дадената фигура
     * @param strokeWidth - дебелина на линията описваща фигурата
     * @param stroke - цвят на линията
     */
    public AbstractShape(NamedColors fill, int strokeWidth, NamedColors stroke) throws FigureException {
        setFill(fill);
        setStrokeWidth(strokeWidth);
        setStroke(stroke);
    }

    /**
     * Метод, който връща низ, представляващ атрибутите на всички фигури.
     * Този метод ще бъде използван от класове, наследяващи абстрактния.
     * @return низ с атрибути
     */
    @Override
    public String convertIntoString() {
        return "fill=\"" + fill + "\" stroke=\"" + stroke + "\" stroke-width=\"" + strokeWidth + "\"";
    }

    /**
     * Метод, който връща низ с атрибутите на фигурата във формат, разбираем за потребителя.
     * @return низ с атрибути за потребителя
     */
    @Override
    public String toUser() {
        StringBuilder sb1 = new StringBuilder();
        sb1.append(fill.toString().toLowerCase(Locale.ROOT))
                .append(" ")
                .append(stroke.toString().toLowerCase(Locale.ROOT))
                .append(" ")
                .append(strokeWidth);
        return sb1.toString();
    }

    /**
     * Метод за получаване на текущия цвят на запълване на фигурата.
     * @return текущия цвят на запълване
     */
    public NamedColors getFill() {
        return fill;
    }

    /**
     * Метод за задаване на цвят на запълване на фигурата.
     * @param fill - новият цвят на запълване
     */
    public void setFill(NamedColors fill) throws IllegalArgumentException {
        if (fill == null) {
            throw new IllegalArgumentException();
        }
        this.fill = fill;
    }

    /**
     * Метод за получаване на текущата дебелина на линията на фигурата.
     * @return текущата дебелина на линията
     */
    public int getStrokeWidth() {
        return strokeWidth;
    }

    /**
     * Метод за задаване на дебелина на линията на фигурата.
     * @param strokeWidth - новата дебелина на линията
     */
    public void setStrokeWidth(int strokeWidth) throws IllegalArgumentException ,FigureException {
        if(strokeWidth<0){
            throw new FigureException("Wrong width for stroke");
        }
        this.strokeWidth = strokeWidth;
    }

    /**
     * Метод за получаване на текущия цвят на линията на фигурата.
     * @return текущия цвят на линията
     */
    public NamedColors getStroke() {
        return stroke;
    }

    /**
     * Метод за задаване на цвят на линията на фигурата.
     * @param stroke - новият цвят на линията
     */
    public void setStroke(NamedColors stroke) throws IllegalArgumentException {
        if(stroke==null){
            throw new IllegalArgumentException("Wrong enum NamedColors");
        }
        this.stroke = stroke;
    }
}
