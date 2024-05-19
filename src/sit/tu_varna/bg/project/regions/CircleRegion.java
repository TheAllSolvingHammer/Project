package sit.tu_varna.bg.project.regions;

public class CircleRegion {
    private int x;
    private int y;
    private int radius;

    /**
     * Конструктор за създаване на кръгов регион с дадени координати на центъра и радиус.
     * @param x Координата X на центъра на кръга.
     * @param y Координата Y на центъра на кръга.
     * @param radius Радиусът на кръга.
     */
    public CircleRegion(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    /**
     * Връща координатата X на центъра на кръга.
     * @return Координатата X на центъра на кръга.
     */
    public int getX() {
        return x;
    }

    /**
     * Задава нова стойност за координатата X на центъра на кръга.
     * @param x Новата координата X на центъра на кръга.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Връща координатата Y на центъра на кръга.
     * @return Координатата Y на центъра на кръга.
     */
    public int getY() {
        return y;
    }

    /**
     * Задава нова стойност за координатата Y на центъра на кръга.
     * @param y Новата координата Y на центъра на кръга.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Връща радиуса на кръга.
     * @return Радиусът на кръга.
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Задава нова стойност за радиуса на кръга.
     * @param radius Новият радиус на кръга.
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

}
