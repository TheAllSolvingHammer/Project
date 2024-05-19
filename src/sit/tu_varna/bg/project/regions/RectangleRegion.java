package sit.tu_varna.bg.project.regions;

/**
 * Клас правоъгълен регион
 */
public class RectangleRegion {
    private int x;
    private int y;
    private int width;
    private int height;

    /**
     * Конструктор за създаване на правоъгълен регион с дадени координати и размери.
     * @param x Координата X на горния ляв ъгъл на правоъгълника.
     * @param y Координата Y на горния ляв ъгъл на правоъгълника.
     * @param width Ширината на правоъгълника.
     * @param height Височината на правоъгълника.
     */
    public RectangleRegion(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Връща координатата X на горния ляв ъгъл на правоъгълника.
     * @return Координатата X на горния ляв ъгъл на правоъгълника.
     */
    public int getX() {
        return x;
    }

    /**
     * Задава нова стойност за координатата X на горния ляв ъгъл на правоъгълника.
     * @param x Новата координата X на горния ляв ъгъл на правоъгълника.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Връща координатата Y на горния ляв ъгъл на правоъгълника.
     * @return Координатата Y на горния ляв ъгъл на правоъгълника.
     */
    public int getY() {
        return y;
    }

    /**
     * Задава нова стойност за координатата Y на горния ляв ъгъл на правоъгълника.
     * @param y Новата координата Y на горния ляв ъгъл на правоъгълника.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Връща ширината на правоъгълника.
     * @return Ширината на правоъгълника.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Задава нова стойност за ширината на правоъгълника.
     * @param width Новата ширина на правоъгълника.
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Връща височината на правоъгълника.
     * @return Височината на правоъгълника.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Задава нова стойност за височината на правоъгълника.
     * @param height Новата височина на правоъгълника.
     */
    public void setHeight(int height) {
        this.height = height;
    }

}
