package sit.tu_varna.bg.project.readers.line;

import sit.tu_varna.bg.project.readers.ReaderAbstractShape;

import java.util.Map;
import java.util.Scanner;
/**
 * Клас четец на пречупена линия, наследяващ абстрактния клас ReaderAbstractShape
 */
public class PolylineReaderShape extends ReaderAbstractShape{
    /**
     * Конструктор реализиращ класа
     */
    public PolylineReaderShape() {

    }

    /**
     * Метод за превърщане на фигурата в лесно четим за хората начин
     * @return низ предствляващ фигурата
     */
    @Override
    public String convertShapeToUserReadable(String shapeString) {
        int pointsIndex = shapeString.indexOf("points=\"");
        String pointsValue;
        String result;
        try {
            int pointsEndIndex = shapeString.indexOf("\"", pointsIndex + 8);
            pointsValue = shapeString.substring(pointsIndex + 8, pointsEndIndex);
            result = shapeString.substring(0, pointsIndex) + shapeString.substring(pointsEndIndex + 1);
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("Points are missing!");
            return null;
        }
        Map<String, String> attributes = parseAttributes(result);
        Scanner scanner = new Scanner(pointsValue);
        scanner.useDelimiter("[, ]+");
        StringBuilder sb = new StringBuilder();
        sb.append("polyline ");
        sb.append(attributes.get("fill")).append(" ");
        sb.append(attributes.get("stroke")).append(" ");
        sb.append(attributes.get("stroke-width")).append(" ");
        while (scanner.hasNext()) {
            sb.append(scanner.next()).append(" ");
        }
        return sb.toString();
    }
}
