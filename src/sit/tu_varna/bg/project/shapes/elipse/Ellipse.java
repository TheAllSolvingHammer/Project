package sit.tu_varna.bg.project.shapes.elipse;

import sit.tu_varna.bg.project.colors.NamedColors;
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
    private double centerX;
    private double centerY;
    private double aAxis;
    private double bAxis;

    public Ellipse(String name, NamedColors fill, double strokeWidth, NamedColors stroke,double centerX, double centerY, double majorAxis, double bAxis) {
        super(name, fill, strokeWidth, stroke);
        this.centerX = centerX;
        this.centerY = centerY;
        this.aAxis = majorAxis;
        this.bAxis = bAxis;
    }

    @Override
    public String convertIntoString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<ellipse ").append(super.convertIntoString());
        sb.append (" cx=\""+centerX+"\" cy=\""+centerY+"\" rx=\""+aAxis+"\" ry=\""+bAxis+"\" />");

        return sb.toString();

    }

    public double getCenterX() {
        return centerX;
    }

    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }

    public double getaAxis() {
        return aAxis;
    }

    public void setaAxis(double aAxis) {
        this.aAxis = aAxis;
    }

    public double getbAxis() {
        return bAxis;
    }

    public void setbAxis(double bAxis) {
        this.bAxis = bAxis;
    }
    // sigurno shte ima i drug konstruktor poradi drug vid elipsa
}
