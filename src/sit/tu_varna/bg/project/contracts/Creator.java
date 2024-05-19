package sit.tu_varna.bg.project.contracts;

/**
 * Интерфейс създател
 */
public interface Creator {
    Shape createShape();
    boolean validColor(String color);

}
