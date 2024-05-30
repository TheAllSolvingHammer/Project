package sit.tu_varna.bg.project.shapes.circle;

import sit.tu_varna.bg.project.enums.NamedColors;
import sit.tu_varna.bg.project.exceptions.CreatorException;
import sit.tu_varna.bg.project.exceptions.FigureException;
import sit.tu_varna.bg.project.regions.CircleRegion;
import sit.tu_varna.bg.project.regions.RectangleRegion;
import sit.tu_varna.bg.project.shapes.AbstractShape;

/**
 * Клас за създаването на кръг
 */
public class Circle extends AbstractShape {
    private int centerX;
    private int centerY;
    private int radius;

    /**
     * Конструктор за кръг
     * @param fill -  цвят на запълване на кръга
     * @param strokeWidth - дебелина на линията описваща окръжността
     * @param stroke -цвят на линия описваща окръжността
     * @param centerX - Х център на окръжността
     * @param centerY - У център на окръжността
     * @param radius - радиус на окръжността
     * @throws FigureException изключение в случай че се въведе грешна фигура

     */
    public Circle(NamedColors fill, int strokeWidth, NamedColors stroke,int centerX, int centerY, int radius) throws FigureException {
        super(fill, strokeWidth, stroke);
        setCenterX(centerX);
        setCenterY(centerY);
        setRadius(radius);
    }

    /**
     * Методът конвертира обекта в стрингова репрезентация като запазва полетата на обеката във вид:
     * [superMethod резултат] [cx] [cy] [радиус]
     * Методът не използва параметри
     * @return Низ презентиращ SVG команда за генериране на кръг по указани параметри
     */
    @Override
    public String convertIntoString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<circle ").append(super.convertIntoString())
                .append(" cx=\"").append(centerX).append("\"")
                .append(" cy=\"").append(centerY).append("\"")
                .append(" r=\"").append(radius).append("\" />");
        return sb.toString();
    }

    /**
     * Транслира фигура по Х кординат
     * @param sx - изместване по Х абцисата
     */
    @Override
    public void translateX(int sx) throws FigureException {
        setCenterX(getCenterX()+sx);
    }

    /**
     * Транслира фигура по У кординат
     * @param sy - изместване по У ординатата
     */
    @Override
    public void translateY(int sy) throws FigureException {
        setCenterY(getCenterY()+sy);
    }

    /**
     * Проверява дали дадената фигура ще е попадне в кръгов регион използвайки формула за кръг:
     * (x-x0)^2+(y-y0)^2=R^2
     * @param region представлява регионът който методът получава като параметър
     * @return връща дали фигурата е попаднала изцяло в областта
     */
    @Override
    public boolean isWithin(CircleRegion region) {
        double regionCenterX = region.getX();
        double regionCenterY = region.getY();
        double regionRadius = region.getRadius();
        boolean centerCheck = Math.pow(centerX - regionCenterX, 2) + Math.pow(centerY - regionCenterY, 2) <= Math.pow(regionRadius - radius, 2);
        boolean withinBounds = radius <= regionRadius;

        return centerCheck && withinBounds;
    }

    /**
     * Проверява дали дадената фигура ще е попадне в правоъгълен регион
     * @param region представлява регионът който методът получава като параметър
     * @return връща дали фигурата е попаднала изцяло в областта
     */
    @Override
    public boolean isWithin(RectangleRegion region) {
        return (centerX - radius) >= region.getX() &&
                (centerX + radius) <= (region.getX() + region.getWidth()) &&
                (centerY - radius) >= region.getY() &&
                (centerY + radius) <= (region.getY() + region.getHeight());
    }

    /**
     * Превръща атрибутите на класа, лесно четими за потребителя
     * @return Низ представляваш лесно прочитаема команда от окото на потребителя
     */
    @Override
    public String toUser() {
        StringBuilder sb1 = new StringBuilder();
        sb1.append("circle ").append(super.toUser()).append(" ").append(centerX)
                .append(" ").append(centerY).append(" ").append(radius);
        return sb1.toString();
    }

    /**
     * Връща координатата X на центъра на кръга.
     * @return Координатата X на центъра на кръга.
     */
    public int getCenterX() {
        return centerX;
    }

    /**
     * Задава координатата X на центъра на кръга.
     * @param centerX Новата координата X на центъра на кръга.
     * @throws FigureException изключение за грешен Х кординат
     * @throws IllegalArgumentException изключение за грешен вход
     */
    public void setCenterX(int centerX) throws IllegalArgumentException, FigureException {
        if (centerX < 0) {
            throw new FigureException("Wrong center X");
        }
        this.centerX = centerX;
    }

    /**
     * Връща координатата Y на центъра на кръга.
     * @return Координатата Y на центъра на кръга.
     */
    public int getCenterY() {
        return centerY;
    }

    /**
     * Задава координатата Y на центъра на кръга.
     * @param centerY Новата координата Y на центъра на кръга.
     * @throws FigureException изключение за грешен У кординат
     * @throws IllegalArgumentException изключение за грешен вход
     */
    public void setCenterY(int centerY) throws IllegalArgumentException, FigureException {
        if (centerX < 0) {
            throw new FigureException("Wrong center Y");
        }
        this.centerY = centerY;
    }

    /**
     * Връща радиуса на кръга.
     * @return Радиуса на кръга.
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Задава радиуса на кръга.
     * @param radius Новият радиус на кръга.
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }



}
