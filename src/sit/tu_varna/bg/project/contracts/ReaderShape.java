package sit.tu_varna.bg.project.contracts;

import java.util.Map;

/**
 * Интерфейс четец на фигурите от файл
 */
public interface ReaderShape {
    String convertShapeToUserReadable();
    boolean isValidColor(String value);
    boolean isValidInteger(String value);
    Map<String, String> parseAttributes(String shapeString);

}

