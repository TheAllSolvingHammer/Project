package sit.tu_varna.bg.project.factory;


import sit.tu_varna.bg.project.contracts.Shape;
import sit.tu_varna.bg.project.creator.circle.CircleCreator;
import sit.tu_varna.bg.project.creator.ellipse.EllipseCreator;
import sit.tu_varna.bg.project.creator.line.LineCreator;
import sit.tu_varna.bg.project.creator.line.PolylineCreator;
import sit.tu_varna.bg.project.creator.polygon.PolygonCreator;
import sit.tu_varna.bg.project.creator.rectangle.RectangleCreator;
import sit.tu_varna.bg.project.enums.Figures;


import java.util.EnumMap;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/**
 * Класът отговаря за създаването на на обекти от вход на потребителя
 */
public class FlyWeightCreator {
    private static FlyWeightCreator instance;
    private final Map<Figures,Map<String,Shape>> products= new EnumMap<>(Figures.class);

    /**
     * Конструктор инициализиращ енум-Мап, със стойност други мапове
     */
    private FlyWeightCreator() {
        products.put(Figures.RECTANGLE, new HashMap<>());
        products.put(Figures.POLYGON, new HashMap<>());
        products.put(Figures.CIRCLE, new HashMap<>());
        products.put(Figures.LINE, new HashMap<>());
        products.put(Figures.POLYLINE, new HashMap<>());
        products.put(Figures.ELLIPSE, new HashMap<>());

    }

    /**
     * Метод getProduct() представлява Factory метод , на модела на FlyWeight патерна. В него чрез параметрите
     * на метеодът се проверяра дали дадена фигура съществиа в въпросния Мап. Ако вече е била създавана такава фигура,
     * методът ще върне вече създадената такава, без да трябва да създава нова.
     * @param figure от Енума Figures, отговаря на някоя от стойностите в енума
     * @param parameters параметри за създаване. При еднакви параметри ще се създаде еднаква фигура
     * @return Фигура, създадена след обработване на параметъра parameters.
     */
    public Shape getProduct(String figure,String parameters){
        Figures type;
        try {
            type = Figures.valueOf(figure.toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid figure name!");
            return null;
        }
        Map<String, Shape> productMap = products.get(type);
        Shape c1 = productMap.get(parameters);
        switch (type){
            case RECTANGLE:{
                if(c1==null){
                    c1= new RectangleCreator(parameters).createShape();
                    productMap.put(parameters,c1);
                }
                products.put(Figures.RECTANGLE,productMap);
                break;
            }
            case POLYGON:{
                if(c1==null){
                    c1= new PolygonCreator(parameters).createShape();
                    productMap.put(parameters,c1);
                }
                products.put(Figures.POLYGON,productMap);
                break;
            }

            case ELLIPSE:{
                if(c1==null){
                    c1= new EllipseCreator(parameters).createShape();
                    productMap.put(parameters,c1);
                }
                products.put(Figures.ELLIPSE,productMap);
                break;
            }
            case CIRCLE:{
                if(c1==null){
                    c1= new CircleCreator(parameters).createShape();
                    productMap.put(parameters,c1);
                }
                products.put(Figures.CIRCLE,productMap);
                break;
            }

            case LINE:{
                if(c1==null){
                    c1= new LineCreator(parameters).createShape();
                    productMap.put(parameters,c1);
                }
                products.put(Figures.LINE,productMap);
                break;
            }

            case POLYLINE:{
                if(c1==null){
                    c1= new PolylineCreator(parameters).createShape();
                    productMap.put(parameters,c1);
                }
                products.put(Figures.POLYLINE,productMap);
                break;
            }
        }
        return products.get(type).get(parameters);
    }

    /**
     * Метод, който връща инстанцията на този клас.
     * @return инстанция от този клас
     */
    public static FlyWeightCreator getInstance() {
        if(instance==null){
            instance = new FlyWeightCreator();
        }
        return instance;
    }
}
