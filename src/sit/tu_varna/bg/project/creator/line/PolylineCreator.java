package sit.tu_varna.bg.project.creator.line;

import sit.tu_varna.bg.project.contracts.Shape;
import sit.tu_varna.bg.project.creator.AbstractCreator;
import sit.tu_varna.bg.project.enums.NamedColors;
import sit.tu_varna.bg.project.shapes.line.Polyline;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class PolylineCreator extends AbstractCreator {
    public PolylineCreator(String parameters) {
        super(parameters);
    }

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
