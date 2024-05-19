package sit.tu_varna.bg.project.shapes.circle;

import sit.tu_varna.bg.project.contracts.ReaderShape;
import sit.tu_varna.bg.project.enums.NamedColors;
import sit.tu_varna.bg.project.readers.circle.CircleReaderShape;
import sit.tu_varna.bg.project.regions.CircleRegion;
import sit.tu_varna.bg.project.regions.RectangleRegion;
import sit.tu_varna.bg.project.shapes.AbstractShape;

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
     */
    public Circle(NamedColors fill, int strokeWidth, NamedColors stroke,int centerX, int centerY, int radius) {
        super(fill, strokeWidth, stroke);
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
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
    public void translateX(int sx) {
        setCenterX(getCenterX()+sx);
    }

    /**
     * Транслира фигура по У кординат
     * @param sy - изместване по У ординатата
     */
    @Override
    public void translateY(int sy) {
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

    public int getCenterX() {
        return centerX;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }


}
