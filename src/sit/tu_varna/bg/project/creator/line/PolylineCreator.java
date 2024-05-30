package sit.tu_varna.bg.project.creator.line;

import sit.tu_varna.bg.project.contracts.Shape;
import sit.tu_varna.bg.project.creator.AbstractCreator;
import sit.tu_varna.bg.project.enums.NamedColors;
import sit.tu_varna.bg.project.exceptions.CreatorException;
import sit.tu_varna.bg.project.exceptions.FigureException;
import sit.tu_varna.bg.project.shapes.line.Polyline;


import java.util.*;

/**
 * Клас за създаване на полилинии, който наследява AbstractCreator.
 */
public class PolylineCreator extends AbstractCreator {
    /**
     * Конструктор за създаване на обект от класа PolylineCreator с дадени параметри.
     * @param parameters Параметрите за създаване на обектите.
     */
    public PolylineCreator(String parameters) throws CreatorException {
        super(parameters);
    }

    /**
     * Метод, който създава полилиния на базата на подадените параметри.
     * @return Връща създадената полилиния.
     */
    @Override
    public Shape createShape() {
        try{
        Scanner scanner = new Scanner(getParameters());
        String fillColor = scanner.next();
        NamedColors fill = NamedColors.valueOf(fillColor.toUpperCase(Locale.ROOT));
        String strokeColor = scanner.next();
        NamedColors stroke = NamedColors.valueOf(strokeColor.toUpperCase(Locale.ROOT));
        int strokeWidth = scanner.nextInt();
        List<Integer> array = new ArrayList<>();
        while(scanner.hasNextInt()){
            array.add(scanner.nextInt());
        }
        if(array.size()%2==1) {
            array.remove(array.size() - 1);
        }
        return new Polyline(fill,strokeWidth,stroke,array);
    }catch (FigureException e){
        System.out.println(e.getMessage());
        return null;
    }catch (InputMismatchException e){
        System.out.println("Wrong integer");
        return null;
    } catch (IllegalArgumentException e){
        System.out.println("Wrong enum");
        return null;
    }
    }
}
