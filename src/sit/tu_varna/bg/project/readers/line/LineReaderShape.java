package sit.tu_varna.bg.project.readers.line;


import sit.tu_varna.bg.project.readers.ReaderAbstractShape;

import java.util.Map;

/**
 * Клас четец на линия, наследяващ абстрактния клас ReaderAbstractShape
 */
public class LineReaderShape extends ReaderAbstractShape {

    /**
     * Конструктор реализиращ класа
     */
    public LineReaderShape() {

    }

    /**
     * Метод за превърщане на фигурата в лесно четим за хората начин
     * @return низ предствляващ фигурата
     */
    @Override
    public String convertShapeToUserReadable(String shapeString) {
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
