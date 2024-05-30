package sit.tu_varna.bg.project.creator.circle;

import sit.tu_varna.bg.project.contracts.Shape;
import sit.tu_varna.bg.project.creator.AbstractCreator;
import sit.tu_varna.bg.project.enums.NamedColors;
import sit.tu_varna.bg.project.exceptions.CreatorException;
import sit.tu_varna.bg.project.exceptions.FigureException;
import sit.tu_varna.bg.project.shapes.circle.Circle;


import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
/**
 * Клас за създаване на кръгове, който наследява AbstractCreator.
 */
public class CircleCreator extends AbstractCreator {
    /**
     * Конструктор за създаване на обект от класа CircleCreator с дадени параметри.
     * @param parameters Параметрите за създаване на обектите.
     * @throws CreatorException изключение наследено от абстрактния клас
     */
    public CircleCreator(String parameters) throws CreatorException {
        super(parameters);
    }

    /**
     * Метод, който създава кръг на базата на подадените параметри.
     * @return Връща създадения кръг.
     */
    @Override
    public Shape createShape() {
        try {
            Scanner scanner = new Scanner(getParameters());
            String fillColor = scanner.next();
            NamedColors fill = NamedColors.valueOf(fillColor.toUpperCase(Locale.ROOT));
            String strokeColor = scanner.next();
            NamedColors stroke = NamedColors.valueOf(strokeColor.toUpperCase(Locale.ROOT));
            int strokeWidth = scanner.nextInt();
            int initialX = scanner.nextInt();
            int initialY = scanner.nextInt();
            int radius = scanner.nextInt();
            return new Circle(fill, strokeWidth, stroke, initialX, initialY, radius);
        }
        catch (FigureException e){
            System.out.println(e.getMessage());
            return null;
        }
        catch (InputMismatchException e){
            System.out.println("Wrong integer");
            return null;
        }
        catch (IllegalArgumentException e){
            System.out.println("Wrong enum");
            return null;
        }
    }

}
