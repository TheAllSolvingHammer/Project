package sit.tu_varna.bg.project.readers;

import sit.tu_varna.bg.project.contracts.ManageShape;
import sit.tu_varna.bg.project.contracts.ReaderShape;
import sit.tu_varna.bg.project.contracts.Shape;
import sit.tu_varna.bg.project.factory.FlyWeightCreator;
import sit.tu_varna.bg.project.readers.circle.CircleReaderShape;
import sit.tu_varna.bg.project.readers.ellipse.EllipseReaderShape;
import sit.tu_varna.bg.project.readers.line.LineReaderShape;
import sit.tu_varna.bg.project.readers.line.PolylineReaderShape;
import sit.tu_varna.bg.project.readers.polygon.PolygonReaderShape;
import sit.tu_varna.bg.project.readers.rectangle.RectangleReaderShape;
import sit.tu_varna.bg.project.shapes.ShapeManager;

/**
 * Клас който проита съжърданието от HTML таговете на SVG
 */
public class SvgReader {
    private String read;

    /**
     * Конструктор за реализиращ класа
     * @param string низ със съдържанието от файла
     */
    public SvgReader(String string) {
        this.read = string;
    }

    /**
     * Прочита всички дъжерни тагове на SVG
     */
    public void readAllItems(){
        if (read == null || read.isEmpty()) {
            return;
        }

        int startIndex = read.indexOf("<svg");
        if (startIndex < 0) {
            throw new IllegalArgumentException("Invalid SVG string: Missing <svg> tag");
        }
        int endIndex = read.lastIndexOf("</svg>");
        if (endIndex < 0) {
            throw new IllegalArgumentException("Invalid SVG string: Missing closing </svg> tag");
        }
        String[] arr = (read.substring(startIndex, endIndex + 6)).split("\n");
        for(String a1:arr){
            checkFigure(a1);
        }
        System.out.println("All possible figures are read!");


    }

    /**
     * Проверява дали тагът за сигура съответства
     * @param str е фигурата
     */
    public void checkFigure(String str){
        FlyWeightCreator f1 = FlyWeightCreator.getInstance();
        ReaderShape sh;
        ManageShape manageShape = ShapeManager.getInstance();

        if(str.startsWith("<rect")){
            sh= new RectangleReaderShape(str);
            String s1=sh.convertShapeToUserReadable();
            if(s1==null || s1.isEmpty()){
                return;
            }
            int index=s1.indexOf(" ");
            if(index==-1){
                return;
            }
            String s2=s1.substring(0,index);
            String s3=s1.substring(index+1);
            Shape shape =f1.getProduct(s2,s3);
            manageShape.addShape(shape);

        }else if(str.startsWith("<circle")){

            sh= new CircleReaderShape(str);
            String s1=sh.convertShapeToUserReadable();
            if(s1==null || s1.isEmpty()){
                return;
            }
            int index=s1.indexOf(" ");
            if(index==-1){
                return;
            }
            String s2=s1.substring(0,index);
            String s3=s1.substring(index+1);
            Shape shape =f1.getProduct(s2,s3);
            manageShape.addShape(shape);

        }else if(str.startsWith("<ellipse")){

            sh= new EllipseReaderShape(str);
            String s1=sh.convertShapeToUserReadable();
            if(s1==null || s1.isEmpty()){
                return;
            }
            int index=s1.indexOf(" ");

            if(index==-1){
                return;
            }
            String s2=s1.substring(0,index);
            String s3=s1.substring(index+1);
            Shape shape =f1.getProduct(s2,s3);
            manageShape.addShape(shape);

        }
        else if(str.startsWith("<line")){

            sh= new LineReaderShape(str);
            String s1=sh.convertShapeToUserReadable();
            if(s1==null || s1.isEmpty()){
                return;
            }
            int index=s1.indexOf(" ");
            if(index==-1){
                return;
            }
            String s2=s1.substring(0,index);
            String s3=s1.substring(index+1);
            Shape shape =f1.getProduct(s2,s3);
            manageShape.addShape(shape);

        }
        else if(str.startsWith("<polyline")){

            sh= new PolylineReaderShape(str);
            String s1=sh.convertShapeToUserReadable();
            if(s1==null || s1.isEmpty()){
                return;
            }
            int index=s1.indexOf(" ");
            if(index==-1){
                return;
            }
            String s2=s1.substring(0,index);
            String s3=s1.substring(index+1);
            Shape shape =f1.getProduct(s2,s3);
            manageShape.addShape(shape);

        }
        else if(str.startsWith("<polygon")){

            sh= new PolygonReaderShape(str);
            String s1=sh.convertShapeToUserReadable();
            if(s1==null || s1.isEmpty()){
                return;
            }
            int index=s1.indexOf(" ");
            if(index==-1){
                return;
            }
            String s2=s1.substring(0,index);
            String s3=s1.substring(index+1);
            Shape shape =f1.getProduct(s2,s3);
            manageShape.addShape(shape);

        }
    }
}
