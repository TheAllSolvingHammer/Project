package sit.tu_varna.bg.project.readers.circle;

import sit.tu_varna.bg.project.contracts.ReaderShape;
import sit.tu_varna.bg.project.readers.ReaderAbstractShape;

import java.util.Map;


/**
 * Клас четец на кръг, наследяващ абстрактния клас ReaderAbstractShape
 */
public class CircleReaderShape extends ReaderAbstractShape{
    private String shapeString;

    /**
     * Конструктор реализиращ класа
     * @param shapeString низ съответстващ на фигурата
     */
    public CircleReaderShape(String shapeString) {
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
        sb.append("circle ");
        sb.append(attributes.get("fill")).append(" ");
        sb.append(attributes.get("stroke")).append(" ");
        sb.append(attributes.get("stroke-width")).append(" ");
        sb.append(attributes.get("cx")).append(" ");
        sb.append(attributes.get("cy")).append(" ");
        sb.append(attributes.get("r"));
        return sb.toString();
    }
}
