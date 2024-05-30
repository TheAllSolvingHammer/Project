package sit.tu_varna.bg.project.creator.line;

import sit.tu_varna.bg.project.contracts.Shape;
import sit.tu_varna.bg.project.creator.AbstractCreator;
import sit.tu_varna.bg.project.enums.NamedColors;
import sit.tu_varna.bg.project.exceptions.CreatorException;
import sit.tu_varna.bg.project.exceptions.FigureException;
import sit.tu_varna.bg.project.shapes.line.Line;


import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
/**
 * Клас за създаване на линии, който наследява AbstractCreator.
 */
public class LineCreator extends AbstractCreator {
    /**
     * Конструктор за създаване на обект от класа LineCreator с дадени параметри.
     * @param parameters Параметрите за създаване на обектите.
     * @throws CreatorException изключение наследено от абстрактния клас
     */
    public LineCreator(String parameters) throws CreatorException {
        super(parameters);
    }
    /**
     * Метод, който създава линия на базата на подадените параметри.
     * @return Връща създадената линия.
     */
    @Override
    public Shape createShape() {
        try{
        Scanner scanner = new Scanner(getParameters());
        int strokeWidth = scanner.nextInt();
        String strokeColor = scanner.next();
        NamedColors stroke = NamedColors.valueOf(strokeColor.toUpperCase(Locale.ROOT));
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
            return new Line(strokeWidth,stroke,x1,y1,x2,y2);
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
