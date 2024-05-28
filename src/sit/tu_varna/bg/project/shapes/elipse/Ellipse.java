package sit.tu_varna.bg.project.shapes.elipse;

import sit.tu_varna.bg.project.enums.NamedColors;
import sit.tu_varna.bg.project.exceptions.FigureException;
import sit.tu_varna.bg.project.regions.CircleRegion;
import sit.tu_varna.bg.project.regions.RectangleRegion;
import sit.tu_varna.bg.project.shapes.AbstractShape;

/**
 * Клас за създаване на елипса
 */
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
    public Ellipse(NamedColors fill, int strokeWidth, NamedColors stroke,int centerX, int centerY, int aAxis, int bAxis) throws FigureException {
        super(fill, strokeWidth, stroke);
        setCenterX(centerX);
        setCenterY(centerY);
        setaAxis(aAxis);
        setbAxis(bAxis);
    }

    /**
     * Методът конвертира обекта в стрингова репрезентация като запазва полетата на обеката във вид:
     * [superMethod] [резултат]  [cx] [cy] [a] [b]
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
     * Транслира фигура по Х кординат
     * @param sx -  изместване по Х абцисата
     */
    @Override
    public void translateX(int sx) throws FigureException {
        setCenterX(getCenterX()+sx);
    }
    /**
     * Транслира фигура по У кординат
     * @param sy -  изместване по У ординатата
     */
    @Override
    public void translateY(int sy) throws FigureException {
        setCenterY(getCenterY()+sy);
    }

    /**
     * Проверява дали дадената фигура ще е попадне в кръгов регион използвайки формула за кръг:
     * (x-x0)^2+(y-y0)^2=R^2
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

    /**
     * Превръща атрибутите на класа, лесно четими за потребителя
     * @return Низ представляваш лесно прочитаема команда от окото на потребителя
     */
    @Override
    public String toUser() {
        StringBuilder sb1 = new StringBuilder();
        sb1.append("ellipse ").append(super.toUser()).append(" ").append(centerX)
                .append(" ").append(centerY).append(" ").append(aAxis).append(" ").append(bAxis);
        return sb1.toString();
    }

    /**
     * Връща координатата X на центъра на елипсата.
     * @return Координатата X на центъра на елипсата.
     */
    public int getCenterX() {
        return centerX;
    }

    /**
     * Задава координатата X на центъра на елипсата.
     * @param centerX Новата координата X на центъра на елипсата.
     */
    public void setCenterX(int centerX) throws FigureException {
        if (centerX < 0) {
            throw new FigureException("The center x should be greater than 0");
        }
        this.centerX = centerX;
    }

    /**
     * Връща координатата Y на центъра на елипсата.
     * @return Координатата Y на центъра на елипсата.
     */
    public int getCenterY() {
        return centerY;
    }

    /**
     * Задава координатата Y на центъра на елипсата.
     * @param centerY Новата координата Y на центъра на елипсата.
     */
    public void setCenterY(int centerY) throws FigureException {
        if (centerY < 0) {
            throw new FigureException("The center y should be greater than 0");
        }
        this.centerY = centerY;
    }

    /**
     * Връща дължината на главната полуос на елипсата.
     * @return Дължината на главната полуос на елипсата.
     */
    public int getaAxis() {
        return aAxis;
    }

    /**
     * Задава дължината на главната полуос на елипсата.
     * @param aAxis Новата дължина на главната полуос на елипсата.
     */
    public void setaAxis(int aAxis) throws FigureException {
        if (aAxis < 0) {
            throw new FigureException("The axis should be greater than 0");
        }
        this.aAxis = aAxis;
    }

    /**
     * Връща дължината на втората полуос (маката ос) на елипсата.
     * @return Дължината на втората полуос (маката ос) на елипсата.
     */
    public int getbAxis() {
        return bAxis;
    }

    /**
     * Задава дължината на втората полуос (маката ос) на елипсата.
     * @param bAxis Новата дължина на втората полуос (маката ос) на елипсата.
     */
    public void setbAxis(int bAxis) throws FigureException {
        if (bAxis < 0) {
            throw new FigureException("The axis should be greater than 0");
        }
        this.bAxis = bAxis;
    }

}
