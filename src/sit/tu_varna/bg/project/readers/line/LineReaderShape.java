package sit.tu_varna.bg.project.readers.line;


import sit.tu_varna.bg.project.readers.ReaderAbstractShape;

import java.util.Map;
import java.util.Scanner;
/**
 * Клас четец на линия, наследяващ абстрактния клас ReaderAbstractShape
 */
public class LineReaderShape extends ReaderAbstractShape {
    private String shapeString;
    /**
     * Конструктор реализиращ класа
     * @param shapeString низ съответстващ на фигурата
     */
    public LineReaderShape(String shapeString) {
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
        sb.append("ellipse ");
        sb.append(attributes.get("stroke")).append(" ");
        sb.append(attributes.get("stroke-width")).append(" ");
        sb.append(attributes.get("x1")).append(" ");
        sb.append(attributes.get("y1")).append(" ");
        sb.append(attributes.get("x2")).append(" ");
        sb.append(attributes.get("y2"));
        return sb.toString();
    }
}
