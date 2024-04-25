package sit.tu_varna.bg.project.executable;

import sit.tu_varna.bg.project.Test;
import sit.tu_varna.bg.project.colors.NamedColors;
import sit.tu_varna.bg.project.shapes.AbstractShape;
import sit.tu_varna.bg.project.shapes.circle.Circle;
import sit.tu_varna.bg.project.shapes.elipse.Ellipse;

import javax.sound.midi.Soundbank;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Test.printSmth();
        //dddddddddddddddddddddddddddddddddddddddddd
        System.out.println("Testing if git works");
        AbstractShape shape1 = new Circle("circle1", NamedColors.Blue,2,NamedColors.Green,30,20,10);

        System.out.println(shape1.convertIntoString());
        AbstractShape shape2 = new Ellipse("elipse1", NamedColors.Blue,10,NamedColors.Beige,100,200,300,20);
        System.out.println(shape2.convertIntoString());

    }
}
