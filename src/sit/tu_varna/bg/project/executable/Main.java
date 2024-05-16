package sit.tu_varna.bg.project.executable;

import sit.tu_varna.bg.project.contracts.*;
import sit.tu_varna.bg.project.complete.ParseIntoText;
import sit.tu_varna.bg.project.factory.FlyWeightCreator;
import sit.tu_varna.bg.project.file.FileWorker;
import sit.tu_varna.bg.project.file.write.SaveFile;
import sit.tu_varna.bg.project.readers.rectangle.RectangleReaderShape;
import sit.tu_varna.bg.project.shapes.ShapeManager;

import java.io.IOException;
import java.util.Locale;


public class Main {

    public static void main(String[] args)  {
	// write your code here



        String s1="rectangle brown pink 10 200 300 500 400";
        int index=s1.indexOf(" ");
        String s2=s1.substring(index+1);
        String s3=s1.substring(0,index);
        FlyWeightCreator f1=new FlyWeightCreator();
        Shape t1= f1.getProduct(s3.toUpperCase(Locale.ROOT),s2.toUpperCase(Locale.ROOT));
        Shape t2 =f1.getProduct("rectangle","brown pink 10 200 20 500 400 20 20");
        Shape t3 =f1.getProduct("ellipse","beige brown 3 600 700 100 200");
        Shape t4=f1.getProduct("circle","Blue ReD 4 100 200 100");
            ManageShape manager = new ShapeManager();
            manager.addShape(t1);
            manager.addShape(t2);
            manager.addShape(t3);
            manager.addShape(t4);
            manager.translate(20,30);
            Parser p1 = new ParseIntoText(manager);
        System.out.println(t1.toUser());
            System.out.println(p1.parseText());
            System.out.println();
        System.out.println(manager.getItemsToUser());
        ReaderShape r1 = new RectangleReaderShape("<rect fill=\"BROWN\" stroke=\"PINK\" stroke-width=\"10\" x=\"200\" y=\"300\" width=\"500\" height=\"400\" rx=\"10\" ry=\"20\" />");
        System.out.println(r1.convertShapeToUserReadable().toLowerCase(Locale.ROOT));
        FileWorker fr1 =  FileWorker.getInstance("D:\\testSvg\\fig.svg");
        fr1.open();
        fr1.read();
        System.out.println(fr1.getContent());
        FileManage saver = new SaveFile(fr1.getPath(),p1.parseText());
        saver.execute();



        System.out.println();







    }
}
