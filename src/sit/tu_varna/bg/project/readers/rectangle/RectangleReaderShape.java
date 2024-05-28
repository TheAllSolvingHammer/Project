package sit.tu_varna.bg.project.readers.rectangle;

import sit.tu_varna.bg.project.readers.ReaderAbstractShape;
import java.util.Map;

/**
 * Клас четец на правоъгълници, наследяващ абстрактния клас ReaderAbstractShape
 */
public class RectangleReaderShape extends ReaderAbstractShape {
    private String shapeString;

    /**
     * Конструктор реализиращ класа
     * @param shapeString низ съответстващ на фигурата
     */
    public RectangleReaderShape(String shapeString) {
        this.shapeString = shapeString;
    }

    /**
     * Метод за превърщане на фигурата в лесно четим за хората начин
     * @return низ предствляващ фигурата
     */
    @Override
    public String convertShapeToUserReadable() {
        Map<String, String> attributes = parseAttributes(shapeString);

        StringBuilder sb = new StringBuilder();
        sb.append("rectangle ");
        sb.append(attributes.get("fill")).append(" ");
        sb.append(attributes.get("stroke")).append(" ");
        sb.append(attributes.get("stroke-width")).append(" ");
        sb.append(attributes.get("x")).append(" ");
        sb.append(attributes.get("y")).append(" ");
        sb.append(attributes.get("width")).append(" ");
        sb.append(attributes.get("height"));
        String rx = attributes.get("rx");
        String ry = attributes.get("ry");
        if (rx != null && ry != null && isValidInteger(rx) && isValidInteger(ry)) {
            sb.append(" ").append(rx).append(" ").append(ry);
        }
        return sb.toString();
    }
}
