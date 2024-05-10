package sit.tu_varna.bg.project.shapes;


import sit.tu_varna.bg.project.contracts.ManageShape;
import sit.tu_varna.bg.project.contracts.Shape;
import sit.tu_varna.bg.project.regions.CircleRegion;
import sit.tu_varna.bg.project.regions.RectangleRegion;

import java.util.ArrayList;
import java.util.List;


public class ShapeManager implements ManageShape {
    private List<Shape> shapes;

    /**
     * Конструктор на класа ShapeManager
     * В него се създава ArrayList съдържащ създадените от нас фигури
     */
    public ShapeManager() {
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
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    /**
     * Метод за премахване на фигури, Ако фигурата съществува метода я премахва по указан индекс от потребителя.
     * В противен случай метода не прави модификации по листа с фигури
     * @param index индекс на съответствие на фигурата
     */
    @Override
    public void removeShape(int index) {
        if(index<0 || index>shapes.size()){
            return;
        }
        if(shapes.isEmpty()){
            return;
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
            if(s.isWithin(region)){
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
            if(s.isWithin(region)){
                withinShapes.add(s);
            }
        }
        return withinShapes;
    }

    /**
     * Транслира/Премества всички фигури по зададен от потребителя интервал
     * @param x - разстояние на което фигурата ще се измести по Х абцисата
     * @param y -растояние на което фигурата ще се измести по У ординатата
     */
    @Override
    public void translate(int x, int y) {
        for(Shape s:shapes){
            s.translateX(x);
            s.translateY(y);
        }
    }

}
