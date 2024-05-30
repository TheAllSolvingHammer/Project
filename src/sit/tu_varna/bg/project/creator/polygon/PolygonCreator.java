package sit.tu_varna.bg.project.creator.polygon;

import sit.tu_varna.bg.project.contracts.Shape;
import sit.tu_varna.bg.project.creator.AbstractCreator;
import sit.tu_varna.bg.project.enums.NamedColors;
import sit.tu_varna.bg.project.exceptions.CreatorException;
import sit.tu_varna.bg.project.exceptions.FigureException;

import sit.tu_varna.bg.project.shapes.polygon.Polygon;

import java.util.*;

/**
 * Клас за създаване на многоъгълници, който наследява AbstractCreator.
 */
public class PolygonCreator extends AbstractCreator {
    /**
     * Конструктор за създаване на обект от класа PolygonCreator с дадени параметри.
     * @param parameters Параметрите за създаване на обектите.
     * @throws CreatorException изключение наследено от абстрактния клас
     */
    public PolygonCreator(String parameters) throws CreatorException {
        super(parameters);
    }

    /**
     * Метод, който създава многоъгълник на базата на подадените параметри.
     * @return Връща създадения многоъгълник.
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
        if(array.size()%2==1){
            array.remove(array.size()-1);
        }
        return new Polygon(fill,strokeWidth,stroke,array);
    } catch (FigureException e){
        System.out.println(e.getMessage());
        return null;
    } catch (InputMismatchException e){
        System.out.println("Wrong integer");
        return null;
    } catch (IllegalArgumentException e){
        System.out.println("Wrong enum");
        return null;
    }
    }
}
