package sit.tu_varna.bg.project.creator.line;

import sit.tu_varna.bg.project.contracts.Shape;
import sit.tu_varna.bg.project.creator.AbstractCreator;
import sit.tu_varna.bg.project.enums.NamedColors;
import sit.tu_varna.bg.project.shapes.line.Polyline;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
/**
 * Клас за създаване на полилинии, който наследява AbstractCreator.
 */
public class PolylineCreator extends AbstractCreator {
    /**
     * Конструктор за създаване на обект от класа PolylineCreator с дадени параметри.
     * @param parameters Параметрите за създаване на обектите.
     */
    public PolylineCreator(String parameters) {
        super(parameters);
    }

    /**
     * Метод, който създава полилиния на базата на подадените параметри.
     * @return Връща създадената полилиния.
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
        if(array.size()<2){
            return null;
        }
        return new Polyline(fill,strokeWidth,stroke,array);

    }
}
