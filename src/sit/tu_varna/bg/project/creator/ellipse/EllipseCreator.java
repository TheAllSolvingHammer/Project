package sit.tu_varna.bg.project.creator.ellipse;

import sit.tu_varna.bg.project.contracts.Shape;
import sit.tu_varna.bg.project.creator.AbstractCreator;
import sit.tu_varna.bg.project.enums.NamedColors;
import sit.tu_varna.bg.project.exceptions.CreatorException;
import sit.tu_varna.bg.project.exceptions.FigureException;
import sit.tu_varna.bg.project.shapes.elipse.Ellipse;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
/**
 * Клас за създаване на елипси, който наследява AbstractCreator.
 */
public class EllipseCreator extends AbstractCreator {
    /**
     * Конструктор за създаване на обект от класа EllipseCreator с дадени параметри.
     * @param parameters Параметрите за създаване на обектите.
     * @throws CreatorException изключение наследено от абстрактния клас
     */
    public EllipseCreator(String parameters) throws CreatorException {
        super(parameters);
    }

    /**
     * Метод, който създава елипса на базата на подадените параметри.
     * @return Връща създадената елипса.
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
        int initialX = scanner.nextInt();
        int initialY = scanner.nextInt();
        int radiusX = scanner.nextInt();
        int radiusY = scanner.nextInt();
            return new Ellipse(fill,strokeWidth,stroke,initialX,initialY,radiusX,radiusY);
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
