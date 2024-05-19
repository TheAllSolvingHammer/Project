package sit.tu_varna.bg.project.creator.polygon;

import sit.tu_varna.bg.project.contracts.Shape;
import sit.tu_varna.bg.project.creator.AbstractCreator;
import sit.tu_varna.bg.project.enums.NamedColors;
import sit.tu_varna.bg.project.shapes.line.Polyline;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
/**
 * Клас за създаване на многоъгълници, който наследява AbstractCreator.
 */
public class PolygonCreator extends AbstractCreator {
    /**
     * Конструктор за създаване на обект от класа PolygonCreator с дадени параметри.
     * @param parameters Параметрите за създаване на обектите.
     */
    public PolygonCreator(String parameters) {
        super(parameters);
    }

    /**
     * Метод, който създава многоъгълник на базата на подадените параметри.
     * @return Връща създадения многоъгълник.
     */
    @Override
    public Shape createShape() {
        Scanner scanner = new Scanner(getParameters());
        if (!scanner.hasNext()) {
            System.out.println("Not enough arguments!");
            return null;
        }
        String fillColor = scanner.next();
        if (!validColor(fillColor)) {
            System.out.println("Fill color is not valid!");
            return null;
        }
        NamedColors fill = NamedColors.valueOf(fillColor.toUpperCase(Locale.ROOT));
        if (!scanner.hasNext()) {
            System.out.println("Not enough arguments!");
            return null;
        }
        String strokeColor = scanner.next();
        if (!validColor(strokeColor)) {
            System.out.println("Stroke color is not valid!");
            return null;
        }
        NamedColors stroke = NamedColors.valueOf(strokeColor.toUpperCase(Locale.ROOT));
        if (!scanner.hasNextInt()) {
            System.out.println("Passed value for stroke width is not a real number!");
            return null;
        }
        int strokeWidth = scanner.nextInt();
        List<Integer> array = new ArrayList<>();
        while(scanner.hasNextInt()){
            array.add(scanner.nextInt());
        }
        /*
        if(array.size()<2){
            return null;
        }

         */
        return new Polyline(fill,strokeWidth,stroke,array);
    }
}
