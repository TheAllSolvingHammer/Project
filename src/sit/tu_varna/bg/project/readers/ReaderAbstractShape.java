package sit.tu_varna.bg.project.readers;

import sit.tu_varna.bg.project.contracts.ReaderShape;

import java.util.HashMap;
import java.util.Map;

/**
 * Aбстрактен клас за четците на фигури, имплеменмтираш интергейсът ReaderShape
 */
public abstract class ReaderAbstractShape implements ReaderShape {
    /**
     * Парсва всички атрибути
     * @param shapeString параметър на прочетената фигура от файл
     * @return върща мап от всички атрибути
     */
    public Map<String, String> parseAttributes(String shapeString) {
        Map<String, String> attributes = new HashMap<>();
        String[] parts = shapeString.split("[ =\"/]+");
        for (int i = 1; i < parts.length; i += 2) {
            if (i + 1 < parts.length) {
                attributes.put(parts[i], parts[i+1]);
            }
        }
        return attributes;
    }

    /**
     * Проверява дали цвета на фигурата е валиден
     * @param value параметър за цвета
     * @return истина или лъжа спрямо проверката дали съществува
     */

    @Override
    public boolean isValidInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
