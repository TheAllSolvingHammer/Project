package sit.tu_varna.bg.project.shapes.rectangle;

import sit.tu_varna.bg.project.enums.NamedColors;
import sit.tu_varna.bg.project.regions.CircleRegion;
import sit.tu_varna.bg.project.regions.RectangleRegion;
import sit.tu_varna.bg.project.shapes.AbstractShape;

public class Rectangle extends AbstractShape {

    private int initialX;
    private int initialY;
    private int width;
    private int height;
    private int roundCornerX=0;
    private int roundCornerY=0;

    /**
     *Конструктор за създаване на правоъгълник
     * @param fill - Параметър за цввта за запълване на фигурата
     * @param strokeWidth - Параметър за дебелина на линията около създадената фигура
     * @param stroke - Параметър за цввта за линията
     * @param initialX - Начален Х кординат
     * @param initialY - Начален У- кординат
     * @param width - Параметър за широчина на фигурата
     * @param height - Параметър за височина на фигурата
     */
    public Rectangle(NamedColors fill, int strokeWidth, NamedColors stroke,int initialX, int initialY, int width, int height) {
        super(fill, strokeWidth, stroke);
        this.initialX = initialX;
        this.initialY = initialY;
        this.width = width;
        this.height = height;
    }

    /**
     * Втори конструктор който ще отговаря за създаването на закръглен правоъгълник
     * @param fill - Параметър за цввта за запълване на фигурата
     * @param strokeWidth - Параметър за дебелина на линията около създадената фигура
     * @param stroke - Параметър за цввта за линията
     * @param initialX - Начален Х кординат
     * @param initialY - Начален У- кординат
     * @param width - Параметър за широчина на фигурата
     * @param height - Параметър за височина на фигурата
     * @param roundCornerX - Параметър за закръгленост по Х абсицата
     * @param roundCornerY - Параметър за закръгленост по У ординатата
     */
    public Rectangle(NamedColors fill, int strokeWidth, NamedColors stroke,int initialX, int initialY, int width, int height,int roundCornerX,int roundCornerY) {
        super(fill, strokeWidth, stroke);
        this.initialX = initialX;
        this.initialY = initialY;
        this.width = width;
        this.height = height;
        this.roundCornerX=roundCornerX;
        this.roundCornerY=roundCornerY;

    }

    /**
     * Методът конвертира обекта в стрингова репрезентация като запазва полетата на обеката във вид:
     * [superMethod резултат]  [x]  [y] [широчина] [дебелина] [закръгленост по Х] [закръгленост по Y]
     * Методът не използва параметри
     * @return Низ презентиращ SVG команда за генериране на правоъгълник по указани параметри
     */
    @Override
    public String convertIntoString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<rect ").append(super.convertIntoString());
        if (roundCornerY > 0 && roundCornerX > 0) {
            sb.append(" x=\"").append(initialX).append("\"")
                    .append(" y=\"").append(initialY).append("\"")
                    .append(" width=\"").append(width).append("\"")
                    .append(" height=\"").append(height).append("\"")
                    .append(" rx=\"").append(roundCornerX).append("\"")
                    .append(" ry=\"").append(roundCornerY).append("\"");
        } else {
            sb.append(" x=\"").append(initialX).append("\"")
                    .append(" y=\"").append(initialY).append("\"")
                    .append(" width=\"").append(width).append("\"")
                    .append(" height=\"").append(height).append("\"");
        }
        sb.append(" />");
        return sb.toString();
    }

    /**
     * Транслира фигура по Х кординат
     * @param sx - изместване по Х абцисата
     */
    @Override
    public void translateX(int sx) {
        setInitialX(getInitialX()+sx);
    }

    /**
     * Транслира фигура по У кординат
     * @param sy - изместване по У ординатата
     */
    @Override
    public void translateY(int sy) {
        setInitialY(getInitialY()+sy);
    }


    /**
     * Проверява дали дадената фигура ще е попадне в кръгов регион използвайки формула за кръг:
     * (x-x0)^2+(y-y0)^2=R^2
     * @param region представлява регионът който методът получава като параметър
     * @return връща дали фигурата е попаднала изцяло в областта
     */
    @Override
    public boolean isWithin(CircleRegion region) {
        double equation1=Math.pow(initialX- region.getX(),2)+Math.pow(initialY- region.getY(),2);
        double equation2=Math.pow(initialX+width- region.getX(),2)+Math.pow(initialY+height- region.getY(),2);
        return(equation1<=Math.pow(region.getRadius(), 2) && equation2<=Math.pow(region.getRadius(), 2));
    }
    /**
     * Проверява дали дадената фигура ще е попадне в правоъгълен регион
     * @param region представлява регионът който методът получава като параметър
     * @return връща дали фигурата е попаднала изцяло в областта
     */
    @Override
    public boolean isWithin(RectangleRegion region) {
        boolean xCheck= (initialX <= region.getX()+ region.getWidth() && initialX>= region.getX());
        boolean yCheck= (initialY<=region.getY()+region.getHeight() && initialY>= region.getY());
        return (xCheck && yCheck);
    }


    public int getInitialX() {
        return initialX;
    }

    public void setInitialX(int initialX) {
        this.initialX = initialX;
    }

    public int getInitialY() {
        return initialY;
    }

    public void setInitialY(int initialY) {
        this.initialY = initialY;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getRoundCornerX() {
        return roundCornerX;
    }

    public void setRoundCornerX(int roundCornerX) {
        this.roundCornerX = roundCornerX;
    }

    public int getRoundCornerY() {
        return roundCornerY;
    }

    public void setRoundCornerY(int roundCornerY) {
        this.roundCornerY = roundCornerY;
    }
}
