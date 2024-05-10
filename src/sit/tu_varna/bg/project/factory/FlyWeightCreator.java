package sit.tu_varna.bg.project.factory;

import sit.tu_varna.bg.project.contracts.Creator;
import sit.tu_varna.bg.project.contracts.Shape;
import sit.tu_varna.bg.project.creator.circle.CircleCreator;
import sit.tu_varna.bg.project.creator.ellipse.EllipseCreator;
import sit.tu_varna.bg.project.creator.line.LineCreator;
import sit.tu_varna.bg.project.creator.polygon.PolygonCreator;
import sit.tu_varna.bg.project.creator.rectangle.RectangleCreator;
import sit.tu_varna.bg.project.enums.Figures;


import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class FlyWeightCreator {
    /**
     * Класът отговаря за създаването на на обекти от вход на потребителя
     */
    private static Map<Figures,Map<String,Shape>> products;

    /**
     * Конструктор създаващ енумМап, със стойност други мапове
     */
    public FlyWeightCreator() {
        new EnumMap<>(Figures.class);
    }

    /**
     * Метод getProduct() представлява Factory метод , на модела на FlyWeight патерна. В него чрез параметрите
     * на метеодът се проверяра дали дадена фигура съществиа в въпросния Мап. Ако вече е била създавана такава фигура,
     * методът ще върне вече създадената такава, без да трябва да създава нова.
     * @param figure - от Енума Figures, отговаря на някоя от стойностите в енума
     * @param parameters - параметри за създаване. При еднакви параметри ще се създаде еднаква фигура
     * @return Фигура, създадена след обработване на параметъра parameters.
     */
    public Shape getProduct(String figure,String parameters){
        Figures type= Figures.valueOf(figure); // moje da hvurli null pointer !!!! Ako ne e v figure enuma
        Map<String, Shape> productMap = products.get(type);
        Shape c1 = productMap.get(parameters);
        switch (type){
            case RECTANGLE:{
                if(c1==null){
                    c1= new RectangleCreator(parameters).createShape();
                    productMap.put(parameters,c1);
                }
                products.put(Figures.RECTANGLE,productMap);
            }
            case POLYGON:{
                if(c1==null){
                    c1= new PolygonCreator(parameters).createShape();
                    productMap.put(parameters,c1);
                }
                products.put(Figures.RECTANGLE,productMap);
            }
            case ELLIPSE:{
                if(c1==null){
                    c1= new EllipseCreator(parameters).createShape();
                    productMap.put(parameters,c1);
                }
                products.put(Figures.RECTANGLE,productMap);
            }
            case CIRCLE:{
                if(c1==null){
                    c1= new CircleCreator(parameters).createShape();
                    productMap.put(parameters,c1);
                }
                products.put(Figures.RECTANGLE,productMap);
            }
            case LINE:{
                if(c1==null){
                    c1= new LineCreator(parameters).createShape();
                    productMap.put(parameters,c1);
                }
                products.put(Figures.RECTANGLE,productMap);
            }
            default:
                System.out.println("Shape is not valid and/or is not part in the basic shapes");

        }
        return products.get(type).get(parameters);
    }
}
