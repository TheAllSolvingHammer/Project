package sit.tu_varna.bg.project.readers;

import sit.tu_varna.bg.project.contracts.ReaderShape;
import sit.tu_varna.bg.project.enums.NamedColors;

import java.util.HashMap;
import java.util.Map;

public abstract class ReaderAbstractShape implements ReaderShape {
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

    @Override
    public boolean isValidColor(String value) {
        try {
            NamedColors.valueOf(value.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

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
