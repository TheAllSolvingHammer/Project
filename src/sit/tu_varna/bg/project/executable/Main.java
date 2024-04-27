package sit.tu_varna.bg.project.executable;

import sit.tu_varna.bg.project.CommandLine;
import sit.tu_varna.bg.project.colors.NamedColors;
import sit.tu_varna.bg.project.complete.ParseIntoText;
import sit.tu_varna.bg.project.contracts.ManageShape;
import sit.tu_varna.bg.project.contracts.Parser;
import sit.tu_varna.bg.project.contracts.Shape;
import sit.tu_varna.bg.project.shapes.ShapeManager;
import sit.tu_varna.bg.project.shapes.circle.Circle;
import sit.tu_varna.bg.project.shapes.elipse.Ellipse;
import sit.tu_varna.bg.project.shapes.polygon.Polygon;
import sit.tu_varna.bg.project.shapes.rectangle.Rectangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
	// write your code here


        System.out.println("Testing if git works");
        Shape shape1 = new Circle("circle1", NamedColors.Blue,2,NamedColors.Green,30,20,10); //test circle i name


        Shape shape2 = new Ellipse("", NamedColors.Blue,10,NamedColors.Beige,100,200,300,20); //test ellipse without name

        Shape shape3 = new Rectangle("", NamedColors.Red,10,NamedColors.Pink,450,200,500,400);
        Shape shape4 = new Rectangle("", NamedColors.Red,10,NamedColors.Pink,100,200,500,400,20,30);

        List<Integer> a1= new ArrayList<>();
        a1.add(300);
        a1.add(400);
        a1.add(200);
        a1.add(600);
        a1.add(700);
        a1.add(800);

        Shape shapolygon = new Polygon("",NamedColors.Green,4,NamedColors.Bisque,a1);
        ManageShape manager = new ShapeManager();
        manager.addShape(shape1);
        manager.addShape(shape2);
        manager.addShape(shape3);
        manager.addShape(shape4);
        manager.addShape(shapolygon);
        Parser p1= new ParseIntoText(manager);
        System.out.println(p1.parseText());
        String s1="rectangle rec1 red pink 10 100 200 500 400 20 30";


    }
}
