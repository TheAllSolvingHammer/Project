package sit.tu_varna.bg.project.shapes.elipse;

public class Ellipse {
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
    private double majorAxis;
    private double minorAxis;

    public Ellipse(double centerX, double centerY, double majorAxis, double minorAxis) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.majorAxis = majorAxis;
        this.minorAxis = minorAxis;
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

    public double getMajorAxis() {
        return majorAxis;
    }

    public void setMajorAxis(double majorAxis) {
        this.majorAxis = majorAxis;
    }

    public double getMinorAxis() {
        return minorAxis;
    }

    public void setMinorAxis(double minorAxis) {
        this.minorAxis = minorAxis;
    }
    // sigurno shte ima i drug konstruktor poradi drug vid elipsa
}
