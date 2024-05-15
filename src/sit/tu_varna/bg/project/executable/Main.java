package sit.tu_varna.bg.project.executable;

import sit.tu_varna.bg.project.contracts.ReaderShape;
import sit.tu_varna.bg.project.enums.NamedColors;
import sit.tu_varna.bg.project.complete.ParseIntoText;
import sit.tu_varna.bg.project.contracts.ManageShape;
import sit.tu_varna.bg.project.contracts.Parser;
import sit.tu_varna.bg.project.contracts.Shape;
import sit.tu_varna.bg.project.factory.FlyWeightCreator;
import sit.tu_varna.bg.project.readers.rectangle.RectangleReaderShape;
import sit.tu_varna.bg.project.shapes.ShapeManager;
import sit.tu_varna.bg.project.shapes.circle.Circle;
import sit.tu_varna.bg.project.shapes.elipse.Ellipse;
import sit.tu_varna.bg.project.shapes.polygon.Polygon;
import sit.tu_varna.bg.project.shapes.rectangle.Rectangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class Main {

    public static void main(String[] args) {
	// write your code here



        String s1="rectangle brown pink 10 200 300 500 400 10";
        int index=s1.indexOf(" ");
        String s2=s1.substring(index+1);

        System.out.println(s2);

        String s3=s1.substring(0,index);
        System.out.println(s3);
        FlyWeightCreator f1=new FlyWeightCreator();
        Shape t1= f1.getProduct(s3.toUpperCase(Locale.ROOT),s2.toUpperCase(Locale.ROOT));
            ManageShape manager = new ShapeManager();
            manager.addShape(t1);
            manager.translate(20,30);
            Parser p1 = new ParseIntoText(manager);

            System.out.println(p1.parseText());
            System.out.println();

        ReaderShape r1 = new RectangleReaderShape("<rect fill=\"BROWN\" stroke=\"PINK\" stroke-width=\"10\" x=\"200\" y=\"300\" width=\"500\" height=\"400\" rx=\"10\" />");
        System.out.println(r1.convertShapeToUserReadable().toLowerCase(Locale.ROOT));





    }
}
