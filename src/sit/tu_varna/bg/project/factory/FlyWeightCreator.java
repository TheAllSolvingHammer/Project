package sit.tu_varna.bg.project.factory;

import sit.tu_varna.bg.project.contracts.Creator;
import sit.tu_varna.bg.project.creator.rectangle.RectangleCreator;
import sit.tu_varna.bg.project.enums.Figures;
import sit.tu_varna.bg.project.shapes.rectangle.Rectangle;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class FlyWeightCreator {

    private static Map<Figures,Map<String,Creator>> products;

    public FlyWeightCreator() {
        new EnumMap<>(Figures.class);
    }
    public Creator getProduct(String figure,String parameters){
        Figures type= Figures.valueOf(figure); // moje da hvurli null pointer !!!!
        Map<String,Creator> productMap = products.get(type);
        Creator c1 = productMap.get(parameters);
        switch (type){
            case RECTANGLE:{
                if(c1==null){
                    c1= new RectangleCreator(parameters);
                    productMap.put(parameters,c1);
                }
                products.put(Figures.RECTANGLE,productMap);
            }

        }
        return products.get(type).get(parameters);




    }
}
