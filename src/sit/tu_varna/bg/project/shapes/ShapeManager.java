package sit.tu_varna.bg.project.shapes;


import sit.tu_varna.bg.project.contracts.ManageShape;
import sit.tu_varna.bg.project.contracts.Shape;
import sit.tu_varna.bg.project.exceptions.FigureException;
import sit.tu_varna.bg.project.exceptions.ManagerException;
import sit.tu_varna.bg.project.regions.CircleRegion;
import sit.tu_varna.bg.project.regions.RectangleRegion;

import java.util.ArrayList;
import java.util.List;

/**
 * Мениджър клас отговарящ за съхраняването на всички фигури
 */
public class ShapeManager implements ManageShape {
    private List<Shape> shapes;
    private static ShapeManager instance;

    /**
     * Конструктор на класа ShapeManager
     * В него се създава ArrayList съдържащ създадените от нас фигури
     */
    private ShapeManager() {
        shapes= new ArrayList<>();
    }

    /**
     * Гетър за фигурите
     * @return Лист от фигури
     */
    @Override
    public List<Shape> getShapes() {
        return shapes;
    }

    /**
     * Добавяне на фигури
     * @param shape фигурата която ще бъде добавена към листа с фигури
     */
    @Override
    public void addShape(Shape shape) throws ManagerException {
        if(shape==null){
            throw new ManagerException("Can not add shape to shape manager");
        }
        shapes.add(shape);
    }

    /**
     * Метод за премахване на фигури, Ако фигурата съществува метода я премахва по указан индекс от потребителя.
     * В противен случай метода не прави модификации по листа с фигури
     * @param index индекс на съответствие на фигурата
     */
    @Override
    public void removeShape(int index) throws ManagerException {
        if(shapes.isEmpty()){
            throw new ManagerException("List is empty");
        }
        if(index<0 || index>=shapes.size()){
            throw new ManagerException("Index is out of bounds");
        }
        shapes.remove(index);
    }

    /**
     * Метод отговарящ за проверката дали всички фигури попадат в дадена правоъгълна област
     * @param region регионът отговарящ на правоъгълник. Той представлява инстанция на класа RectangleRegion
     * @return Всички фигури попаднали в региона
     */
    @Override
    public List<Shape> within(RectangleRegion region) {
        List<Shape> withinShapes = new ArrayList<>();
        for(Shape s: shapes){
            if(s!=null && s.isWithin(region)){
                withinShapes.add(s);
            }
        }
        return withinShapes;
    }
    /**
     * Метод отговарящ за проверката дали всички фигури попадат в дадена кръгла област
     * @param region регионът отговарящ на кръг. Той представлява инстанция на класа CircleRegion
     * @return Всички фигури попаднали в региона
     */
    @Override
    public List<Shape> within(CircleRegion region) {
        List<Shape> withinShapes = new ArrayList<>();
        for(Shape s: shapes){
            if(s!=null &&s.isWithin(region)){
                withinShapes.add(s);
            }
        }
        return withinShapes;
    }

    /**
     * Премества всички фигури по зададен от потребителя интервал
     * @param x - разстояние на което фигурата ще се измести по Х абцисата
     * @param y -растояние на което фигурата ще се измести по У ординатата
     */
    @Override
    public void translate(int x, int y) throws ManagerException {
        if(shapes.isEmpty()){
            return;
        }
        for(Shape s:shapes){
                try {
                    s.translateX(x);
                    s.translateY(y);
                } catch (FigureException e) {
                    System.out.println(e.getMessage());
                    return;
                }
        }
        System.out.println("Translated all figures");
    }

    /**
     * Премества фигура по зададен от потребителя интервал
     * @param x - разстояние на което фигурата ще се измести по Х абцисата
     * @param y -растояние на което фигурата ще се измести по У ординатата
     */
    @Override
    public void translate(int x, int y, int index) throws ManagerException {
        if(shapes.isEmpty())
            throw new ManagerException("List is empty");
        if(index<0|| index>shapes.size()-1)
            throw new ManagerException("Index is out of bounds");
        Shape s1= shapes.get(index);
        try {
            s1.translateX(x);
            s1.translateY(y);
        } catch (FigureException e) {
            System.out.println(e.getMessage());
            return;
        }

        shapes.set(index,s1);
        System.out.println("Translated figure at index "+index);
    }

    /**
     * Метод за представяне на потребителя всички фигури
     * @return низ предтсавляващ всички фигури, като всяка фигура е на нов ред
     */
    @Override
    public String getItemsToUser() {
        StringBuilder sb1 = new StringBuilder();
        for (Shape s:shapes){
            sb1.append(s.toUser()).append("\n");
        }
        return sb1.toString();
    }

    /**
     * Метод за получаване на инстанцията от класа, зададена статично
     * @return инсатция от калса
     */
    public static ShapeManager getInstance() {
        if(instance==null){
            instance = new ShapeManager();
        }
        return instance;
    }
}
