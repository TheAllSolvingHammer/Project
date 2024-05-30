package sit.tu_varna.bg.project.regions;

import sit.tu_varna.bg.project.exceptions.CreatorException;
import sit.tu_varna.bg.project.exceptions.RegionException;

public class CircleRegion {
    private int x;
    private int y;
    private int radius;

    /**
     * Конструктор за създаване на кръгов регион с дадени координати на центъра и радиус.
     * @param x Координата X на центъра на кръга.
     * @param y Координата Y на центъра на кръга.
     * @param radius Радиусът на кръга.
     * @throws RegionException изключение ако се създаде грешен обект
     */
    public CircleRegion(int x, int y, int radius) throws RegionException {
        setX(x);
        setY(y);
        setRadius(radius);
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
     * @throws RegionException изключение за грешен Х кординат
     */
    public void setX(int x) throws RegionException {
        if (x < 0) {
            throw new RegionException("x should be greater than or equal to 0");
        }
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
     * @throws RegionException изключение за грешен У кординат
     */
    public void setY(int y) throws RegionException {
        if (y < 0) {
            throw new RegionException("y should be greater than or equal to 0");
        }
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
     * @throws RegionException изключение за грешен радиус
     */
    public void setRadius(int radius) throws RegionException {
        if (radius < 0) {
            throw new RegionException("radius should be greater than or equal to 0");
        }
        this.radius = radius;
    }

}
