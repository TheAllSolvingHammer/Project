package sit.tu_varna.bg.project.executable;

import sit.tu_varna.bg.project.Test;
import sit.tu_varna.bg.project.colors.NamedColors;
import sit.tu_varna.bg.project.shapes.AbstractShape;
import sit.tu_varna.bg.project.shapes.Shape;
import sit.tu_varna.bg.project.shapes.circle.Circle;
import sit.tu_varna.bg.project.shapes.elipse.Ellipse;
import sit.tu_varna.bg.project.shapes.line.Polyline;
import sit.tu_varna.bg.project.shapes.polygon.Polygon;
import sit.tu_varna.bg.project.shapes.rectangle.Rectangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {

    public static void main(String[] args) {
	// write your code here
        Test.printSmth();
        //dddddddddddddddddddddddddddddddddddddddddd
        System.out.println("Testing if git works");
        Shape shape1 = new Circle("circle1", NamedColors.Blue,2,NamedColors.Green,30,20,10); //test circle i name

        System.out.println(shape1.convertIntoString());
        Shape shape2 = new Ellipse("", NamedColors.Blue,10,NamedColors.Beige,100,200,300,20); //test ellipse without name
        System.out.println(shape2.convertIntoString());
        Shape shape3 = new Rectangle("", NamedColors.Red,10,NamedColors.Pink,100,200,500,400);
        Shape shape4 = new Rectangle("", NamedColors.Red,10,NamedColors.Pink,100,200,500,400,20,30);
        System.out.println(shape3.convertIntoString());
        System.out.println(shape4.convertIntoString());
        List<Integer> a1= new ArrayList<>();
        a1.add(300);
        a1.add(400);
        a1.add(200);
        a1.add(600);
        a1.add(700);
        a1.add(800);

        Shape shapeline = new Polygon("",NamedColors.Green,4,NamedColors.Bisque,a1);
        System.out.println(shapeline.convertIntoString());

    }
}
