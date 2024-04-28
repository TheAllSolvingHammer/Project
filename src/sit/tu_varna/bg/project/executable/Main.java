package sit.tu_varna.bg.project.executable;

import sit.tu_varna.bg.project.enums.NamedColors;
import sit.tu_varna.bg.project.complete.ParseIntoText;
import sit.tu_varna.bg.project.contracts.Creator;
import sit.tu_varna.bg.project.contracts.ManageShape;
import sit.tu_varna.bg.project.contracts.Parser;
import sit.tu_varna.bg.project.contracts.Shape;
import sit.tu_varna.bg.project.factory.FactoryCreator;
import sit.tu_varna.bg.project.shapes.ShapeManager;
import sit.tu_varna.bg.project.shapes.circle.Circle;
import sit.tu_varna.bg.project.shapes.elipse.Ellipse;
import sit.tu_varna.bg.project.shapes.polygon.Polygon;
import sit.tu_varna.bg.project.shapes.rectangle.Rectangle;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
	// write your code here


        System.out.println("Testing if git works");
        String s1="rectangle brown pink 10 200 300 500 400 10 20";
        int index=s1.indexOf(" ");
        String s2=s1.substring(index+1);

        String s3=s1.substring(0,index);
        Creator shapef = FactoryCreator.getFactory(s3,s2);
        Shape shape0 = shapef.createShape();

        Shape shape1 = new Circle(NamedColors.BLUE,2,NamedColors.GREEN,30,20,10); //test circle i name


        Shape shape2 = new Ellipse(NamedColors.BLUE,10,NamedColors.BEIGE,100,200,300,20); //test ellipse without name

        Shape shape3 = new Rectangle(NamedColors.RED,10,NamedColors.PINK,450,200,500,400);
        Shape shape4 = new Rectangle(NamedColors.RED,10,NamedColors.PINK,100,200,500,400,20,30);

        List<Integer> a1= new ArrayList<>();
        a1.add(300);
        a1.add(400);
        a1.add(200);
        a1.add(600);
        a1.add(700);
        a1.add(800);
        a1.add(900);
        a1.add(1000);

        Shape shapolygon = new Polygon(NamedColors.GREEN,4,NamedColors.BISQUE,a1);
        ManageShape manager = new ShapeManager();
        manager.addShape(shape0);
        manager.addShape(shape1);
        manager.addShape(shape2);
        manager.addShape(shape3);
        manager.addShape(shape4);
        manager.addShape(shapolygon);
        Parser p1= new ParseIntoText(manager);
        System.out.println(p1.parseText());


    }
}
