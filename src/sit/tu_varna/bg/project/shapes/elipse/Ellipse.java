package sit.tu_varna.bg.project.shapes.elipse;

import sit.tu_varna.bg.project.enums.NamedColors;
import sit.tu_varna.bg.project.regions.CircleRegion;
import sit.tu_varna.bg.project.regions.RectangleRegion;
import sit.tu_varna.bg.project.shapes.AbstractShape;

public class Ellipse extends AbstractShape {

    private int centerX;
    private int centerY;
    private int aAxis;
    private int bAxis;

    /**
     * Конструктор за елипса
     * @param fill - цвят на запълване
     * @param strokeWidth - дебелина на линията описваща елипсата
     * @param stroke - цвят на линията
     * @param centerX - Х център на елипсата
     * @param centerY У център на елипсата
     * @param aAxis - главна ос на елипсата
     * @param bAxis - второстепенна ос на елипсата
     */
    public Ellipse(NamedColors fill, int strokeWidth, NamedColors stroke,int centerX, int centerY, int aAxis, int bAxis) {
        super(fill, strokeWidth, stroke);
        this.centerX = centerX;
        this.centerY = centerY;
        this.aAxis = aAxis;
        this.bAxis = bAxis;
    }

    /**
     * Методът конвертира обекта в стрингова репрезентация като запазва полетата на обеката във вид:
     * <superMethod резултат>  <cx>  <cy> <a> <b>
     * Методът не използва параметри
     * @return Низ презентиращ SVG команда за генериране на елипса по указани параметри
     */
    @Override
    public String convertIntoString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<ellipse ").append(super.convertIntoString())
                .append(" cx=\"").append(centerX).append("\"")
                .append(" cy=\"").append(centerY).append("\"")
                .append(" rx=\"").append(aAxis).append("\"")
                .append(" ry=\"").append(bAxis).append("\" />");
        return sb.toString();

    }
    /**
     * Транслира/Измества фигура по Х кординат
     * @param sx - > изместване по Х абцисата
     */
    @Override
    public void translateX(int sx) {
        setCenterX(getCenterX()+sx);
    }
    /**
     * Транслира/Измества фигура по У кординат
     * @param sy - > изместване по У ординатата
     */
    @Override
    public void translateY(int sy) {
        setCenterY(getCenterY()+sy);
    }

    /**
     * Проверява дали дадената фигура ще е попадне в кръгов регион използвайки формула за кръг:
     * (x-x0)^2+(y-y0)^2<=R^2
     * @param region представлява регионът, който методът получава като параметър
     * @return връща дали фигурата е попаднала изцяло в областта
     */
    @Override
    public boolean isWithin(CircleRegion region) {
        double h = region.getX();
        double k = region.getY();
        double r = region.getRadius();
        boolean centerCheck = Math.pow((centerX - h) / aAxis, 2) + Math.pow((centerY - k) / bAxis, 2) <= 1;
        boolean axisCheck = aAxis <= r && bAxis <= r;
        return centerCheck && axisCheck;
    }

    /**
     * Проверява дали дадената фигура ще е попадне в правоъгълен регион
     * @param region представлява регионът, който методът получава като параметър
     * @return връща дали фигурата е попаднала изцяло в областта
     */
    @Override
    public boolean isWithin(RectangleRegion region) {
        double h = region.getX() + region.getWidth() / 2.0;
        double k = region.getY() + region.getHeight() / 2.0;
        boolean centerCheck = Math.pow((centerX - h) / aAxis, 2) + Math.pow((centerY - k) / bAxis, 2) <= 1;
        boolean axisCheck = aAxis <= region.getWidth() / 2.0 && bAxis <= region.getHeight() / 2.0;
        return centerCheck && axisCheck;
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

    public int getaAxis() {
        return aAxis;
    }

    public void setaAxis(int aAxis) {
        this.aAxis = aAxis;
    }

    public int getbAxis() {
        return bAxis;
    }

    public void setbAxis(int bAxis) {
        this.bAxis = bAxis;
    }

}
