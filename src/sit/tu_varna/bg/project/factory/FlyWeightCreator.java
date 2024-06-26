package sit.tu_varna.bg.project.factory;


import sit.tu_varna.bg.project.contracts.Shape;
import sit.tu_varna.bg.project.creator.circle.CircleCreator;
import sit.tu_varna.bg.project.creator.ellipse.EllipseCreator;
import sit.tu_varna.bg.project.creator.line.LineCreator;
import sit.tu_varna.bg.project.creator.line.PolylineCreator;
import sit.tu_varna.bg.project.creator.polygon.PolygonCreator;
import sit.tu_varna.bg.project.creator.rectangle.RectangleCreator;
import sit.tu_varna.bg.project.enums.Figures;
import sit.tu_varna.bg.project.exceptions.CreatorException;


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
     * методът ще върне вече създадената такава, без да трябва да създава нова. Причината за използването на мап във мапа е да
     * може да се изпратят всички фигури от даден тип. Примерно потребителя иска да получи всчики създадени правоъгълници, ще се обърне към
     * мапа със стойност Енумерацията на Rectangle.
     * @param figure от Енума Figures, отговаря на някоя от стойностите в енума
     * @param parameters параметри за създаване. При еднакви параметри ще се създаде еднаква фигура
     * @return Фигура, създадена след обработване на параметъра parameters.
     */
    public Shape getProduct(String figure,String parameters){
        try {
            Figures type;
            type = Figures.valueOf(figure.toUpperCase(Locale.ROOT));
            Map<String, Shape> productMap = products.get(type);
            Shape c1;
            switch (type) {
                case RECTANGLE: {
                        c1 = new RectangleCreator(parameters).createShape();
                        productMap.put(parameters, c1);
                    products.put(Figures.RECTANGLE, productMap);
                    break;
                }
                case POLYGON: {
                        c1 = new PolygonCreator(parameters).createShape();
                        productMap.put(parameters, c1);
                    products.put(Figures.POLYGON, productMap);
                    break;
                }
                case ELLIPSE: {
                        c1 = new EllipseCreator(parameters).createShape();
                        productMap.put(parameters, c1);
                    products.put(Figures.ELLIPSE, productMap);
                    break;
                }
                case CIRCLE: {
                        c1 = new CircleCreator(parameters).createShape();
                        productMap.put(parameters, c1);
                    products.put(Figures.CIRCLE, productMap);
                    break;
                }

                case LINE: {
                        c1 = new LineCreator(parameters).createShape();
                        productMap.put(parameters, c1);
                    products.put(Figures.LINE, productMap);
                    break;
                }

                case POLYLINE: {
                        c1 = new PolylineCreator(parameters).createShape();
                        productMap.put(parameters, c1);
                    products.put(Figures.POLYLINE, productMap);
                    break;
                }
            }
            return products.get(type).get(parameters);
        }catch (IllegalArgumentException e){
            System.out.println("Wrong figure");
            return null;
        }catch (CreatorException e){
            System.out.println(e.getMessage());
            return null;
        }
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
