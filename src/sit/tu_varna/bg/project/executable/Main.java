package sit.tu_varna.bg.project.executable;

import sit.tu_varna.bg.project.Test;
import sit.tu_varna.bg.project.colors.NamedColors;
import sit.tu_varna.bg.project.shapes.AbstractShape;
import sit.tu_varna.bg.project.shapes.circle.Circle;
import sit.tu_varna.bg.project.shapes.elipse.Ellipse;
import sit.tu_varna.bg.project.shapes.rectangle.Rectangle;



public class Main {

    public static void main(String[] args) {
	// write your code here
        Test.printSmth();
        //dddddddddddddddddddddddddddddddddddddddddd
        System.out.println("Testing if git works");
        AbstractShape shape1 = new Circle("circle1", NamedColors.Blue,2,NamedColors.Green,30,20,10); //test circle i name

        System.out.println(shape1.convertIntoString());
        AbstractShape shape2 = new Ellipse("", NamedColors.Blue,10,NamedColors.Beige,100,200,300,20); //test ellipse without name
        System.out.println(shape2.convertIntoString());
        AbstractShape shape3 = new Rectangle("", NamedColors.Red,10,NamedColors.Pink,100,200,500,400);
        AbstractShape shape4 = new Rectangle("", NamedColors.Red,10,NamedColors.Pink,100,200,500,400,20,30);
        System.out.println(shape3.convertIntoString());
        System.out.println(shape4.convertIntoString());

    }
}
