package sit.tu_varna.bg.project.shapes.elipse;

import sit.tu_varna.bg.project.enums.NamedColors;
import sit.tu_varna.bg.project.shapes.AbstractShape;

public class Ellipse extends AbstractShape {
    /**
     * Всяка елипса съдържа в себе си поне 4 задължителни полета:
     * 1.Х-кординат на центъра
     * 2.У-кординат на центъра
     * 3.Радиус по Х или още 'а', използваме Major Axis
     * 4.Радиус по Y или още 'b', използваме Minor Axis
     *
     * Обща фомула: x^2/a^2+y^2/b^2=1
     */
    private int centerX;
    private int centerY;
    private int aAxis;
    private int bAxis;

    public Ellipse(NamedColors fill, int strokeWidth, NamedColors stroke,int centerX, int centerY, int majorAxis, int bAxis) {
        super(fill, strokeWidth, stroke);
        this.centerX = centerX;
        this.centerY = centerY;
        this.aAxis = majorAxis;
        this.bAxis = bAxis;
    }

    /**
     * convertira
     * @return
     */
    @Override
    public String convertIntoString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<ellipse ").append(super.convertIntoString());
        sb.append (" cx=\""+centerX+"\" cy=\""+centerY+"\" rx=\""+aAxis+"\" ry=\""+bAxis+"\" />");

        return sb.toString();

    }

    @Override
    public void translateX(int sx) {
        setCenterX(getCenterX()+sx);
    }

    @Override
    public void translateY(int sy) {
        setCenterY(getCenterY()+sy);
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
    // sigurno shte ima i drug konstruktor poradi drug vid elipsa
}
