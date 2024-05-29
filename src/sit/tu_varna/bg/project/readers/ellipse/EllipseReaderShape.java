package sit.tu_varna.bg.project.readers.ellipse;


import sit.tu_varna.bg.project.readers.ReaderAbstractShape;

import java.util.Map;

/**
 * Клас четец на елипса, наследяващ абстрактния клас ReaderAbstractShape
 */
public class EllipseReaderShape extends ReaderAbstractShape {

    /**
     * Конструктор реализиращ класа
     */
    public EllipseReaderShape() {
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
        sb.append(attributes.get("fill")).append(" ");
        sb.append(attributes.get("stroke")).append(" ");
        sb.append(attributes.get("stroke-width")).append(" ");
        sb.append(attributes.get("cx")).append(" ");
        sb.append(attributes.get("cy")).append(" ");
        sb.append(attributes.get("rx")).append(" ");
        sb.append(attributes.get("ry"));
        return sb.toString();
    }

}
