package sit.tu_varna.bg.project.factory;

import sit.tu_varna.bg.project.contracts.Creator;
import sit.tu_varna.bg.project.creator.rectangle.RectangleCreator;

import java.util.Locale;

public class FactoryCreator {
    public static Creator getFactory(String type, String parameters){
        type=type.toLowerCase(Locale.ROOT);
        switch (type){
            case "rectangle": return new RectangleCreator(parameters);
            case "circle":;
            case "ellipse":;
            case "line":;
            case "polyline":;
            case "polygon":;

            default: return null;
        }
    }
}
