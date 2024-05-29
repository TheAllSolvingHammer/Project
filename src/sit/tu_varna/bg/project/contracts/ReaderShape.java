package sit.tu_varna.bg.project.contracts;

import java.util.Map;


public interface ReaderShape {
    String convertShapeToUserReadable(String shapeString);
    boolean isValidInteger(String value);
    Map<String, String> parseAttributes(String shapeString);

}

