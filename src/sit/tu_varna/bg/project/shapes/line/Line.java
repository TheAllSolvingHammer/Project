package sit.tu_varna.bg.project.shapes.line;

import sit.tu_varna.bg.project.enums.NamedColors;
import sit.tu_varna.bg.project.contracts.Shape;
import sit.tu_varna.bg.project.regions.CircleRegion;
import sit.tu_varna.bg.project.regions.RectangleRegion;

/**
 * Клас за създаване на линия
 */
public class Line implements Shape {
    private int strokeWidth;
    private NamedColors color;
    private int startX;
    private int startY;
    private int endX;
    private int endY;


    /**
     * Линията се приема като самостоятелна единица без да бъде наследяване от абстрактен клас AbstractShape, защото в някои случаи не се
     * преглежда като фигура
     * @param strokeWidth - Дебелина на линията
     * @param color - Цвят на линията
     * @param startX - начален Х кординат
     * @param startY - начален У кординат
     * @param endX - краен Х кординат
     * @param endY - краен У кординат
     */
    public Line(int strokeWidth, NamedColors color,int startX, int startY, int endX, int endY) {
        this.strokeWidth = strokeWidth;
        this.color = color;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;

    }
    /**
     * Методът конвертира обекта в стрингова репрезентация като запазва полетата на обеката във вид:
     * line [strokeWidth] [stroke] [xStart] [yStart] [xEnd] [yEnd]
     * Методът не използва параметри
     * @return Низ представляваш SVG команда за създаването на линия
     */
    @Override
    public String convertIntoString() {
            return "<line stroke-width=\""+strokeWidth+"\" stroke=\""+color+"\" x1=\""+startX+"\" y1=\""+startY+"\" x2=\""+endX+"\" y2=\""+endY+"\" />";
    }
    /**
     * Транслира линията по Х кординат
     * @param sx -  изместване по Х абцисата
     */
    @Override
    public void translateX(int sx) {
        setStartX(getStartX()+sx);
        setEndX(getEndX()+sx);
    }
    /**
     * Транслира линия по У кординат
     * @param sy -  изместване по У ординатата
     */
    @Override
    public void translateY(int sy) {
        setStartY(getStartY()+sy);
        setEndY(getEndY()+sy);

    }

    /**
     * Проверява дали дадената линия ще е попадне в кръгов регион използвайки формула за кръг:
     * (x-x0)^2+(y-y0)^2=R^2
     * @param region представлява регионът, който методът получава като параметър
     * @return връща дали линия е попаднала изцяло в областта
     */
    @Override
    public boolean isWithin(CircleRegion region) {
        double equation1=Math.pow(startX- region.getX(),2)+Math.pow(startY- region.getY(),2);
        double equation2=Math.pow(endX- region.getX(),2)+Math.pow(endY- region.getY(),2);
        return(equation1<=Math.pow(region.getRadius(), 2) && equation2<=Math.pow(region.getRadius(), 2));
    }
    /**
     * Проверява дали дадената линия ще е попадне в правоъгълен регион
     * @param region представлява регионът, който методът получава като параметър
     * @return връща дали линия е попаднала изцяло в областта
     */
    @Override
    public boolean isWithin(RectangleRegion region) {
        boolean xCheck= (startX <= region.getX()+ region.getWidth() && startX>= region.getX());
        boolean yCheck= (startY<=region.getY()+region.getHeight() && startY>= region.getY());
        boolean xCheck2= (endX <= region.getX()+ region.getWidth() && endX>= region.getX());
        boolean yCheck2= (endY<=region.getY()+region.getHeight() && endY>= region.getY());
        return (xCheck && yCheck && xCheck2 && yCheck2);
    }

    /**
     * Превръща атрибутите на класа, лесно четими за потребителя
     * @return Низ представляваш лесно прочитаема команда от окото на потребителя
     */
    @Override
    public String toUser() {
        StringBuilder sb1 = new StringBuilder();
        sb1.append("line ").append(strokeWidth).append(" ").append(color.toString())
                .append(" ").append(startX).append(" ").append(startY).append(" ").append(endX).append(" ").append(endY);
        return sb1.toString();
    }

    /**
     * Метод за получаване на дебелината на линията.
     * @return дебелината на линията
     */
    public int getStrokeWidth() {
        return strokeWidth;
    }

    /**
     * Метод за задаване на дебелината на линията.
     * @param strokeWidth - новата дебелина на линията
     */
    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    /**
     * Метод за получаване на цвета на линията.
     * @return цвета на линията
     */
    public NamedColors getColor() {
        return color;
    }

    /**
     * Метод за задаване на цвета на линията.
     * @param color - новият цвят на линията
     */
    public void setColor(NamedColors color) {
        this.color = color;
    }

    /**
     * Метод за получаване на началната X координата на линията.
     * @return началната X координата
     */
    public int getStartX() {
        return startX;
    }

    /**
     * Метод за задаване на началната X координата на линията.
     * @param startX - новата начална X координата
     */
    public void setStartX(int startX) {
        this.startX = startX;
    }

    /**
     * Метод за получаване на началната Y координата на линията.
     * @return началната Y координата
     */
    public int getStartY() {
        return startY;
    }

    /**
     * Метод за задаване на началната Y координата на линията.
     * @param startY - новата начална Y координата
     */
    public void setStartY(int startY) {
        this.startY = startY;
    }

    /**
     * Метод за получаване на крайната X координата на линията.
     * @return крайната X координата
     */
    public int getEndX() {
        return endX;
    }

    /**
     * Метод за задаване на крайната X координата на линията.
     * @param endX - новата крайна X координата
     */
    public void setEndX(int endX) {
        this.endX = endX;
    }

    /**
     * Метод за получаване на крайната Y координата на линията.
     * @return крайната Y координата
     */
    public int getEndY() {
        return endY;
    }

    /**
     * Метод за задаване на крайната Y координата на линията.
     * @param endY - новата крайна Y координата
     */
    public void setEndY(int endY) {
        this.endY = endY;
    }

}
