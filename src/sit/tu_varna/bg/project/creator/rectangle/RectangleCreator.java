package sit.tu_varna.bg.project.creator.rectangle;

import sit.tu_varna.bg.project.creator.AbstractCreator;
import sit.tu_varna.bg.project.enums.NamedColors;
import sit.tu_varna.bg.project.contracts.Shape;
import sit.tu_varna.bg.project.exceptions.CreatorException;
import sit.tu_varna.bg.project.exceptions.FigureException;
import sit.tu_varna.bg.project.shapes.rectangle.Rectangle;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
/**
 * Клас за създаване на правоъгълни обекти, който наследява AbstractCreator.
 */
public class RectangleCreator extends AbstractCreator {
    /**
     * Конструктор за създаване на обект от класа RectangleCreator с дадени параметри.
     * @param parameters Параметрите за създаване на обектите.
     * @throws CreatorException изключение наследено от абстрактния клас
     */
    public RectangleCreator(String parameters) throws CreatorException {
        super(parameters);
    }
    /**
     * Метод, който създава правоъгълник на базата на подадените параметри.
     * @return Връща създадения правоъгълник.
     */
    @Override
    public Shape createShape() {
        try {
            NamedColors fill;
            NamedColors stroke;
            Scanner scanner = new Scanner(getParameters());
            String fillColor = scanner.next();
            fill = NamedColors.valueOf(fillColor.toUpperCase(Locale.ROOT));
            String strokeColor = scanner.next();
            stroke = NamedColors.valueOf(strokeColor.toUpperCase(Locale.ROOT));
            int strokeWidth = scanner.nextInt();
            int initialX = scanner.nextInt();
            int initialY = scanner.nextInt();
            int width = scanner.nextInt();
            int height = scanner.nextInt();
            int roundCornerX = 0;
            int roundCornerY = 0;
            if (scanner.hasNextInt()) {
                roundCornerX = scanner.nextInt();
            }
            if (scanner.hasNextInt()) {
                roundCornerY = scanner.nextInt();
            }
            scanner.close();
            if (roundCornerY == 0 || roundCornerX == 0) {
                return new Rectangle(fill, strokeWidth, stroke, initialX, initialY, width, height);
            } else {
                return new Rectangle(fill, strokeWidth, stroke, initialX, initialY, width, height, roundCornerX, roundCornerY);
            }
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
