package sit.tu_varna.bg.project.readers;

import sit.tu_varna.bg.project.contracts.ManageShape;
import sit.tu_varna.bg.project.contracts.ReaderShape;
import sit.tu_varna.bg.project.contracts.Shape;
import sit.tu_varna.bg.project.exceptions.ManagerException;
import sit.tu_varna.bg.project.factory.FlyWeightCreator;
import sit.tu_varna.bg.project.readers.circle.CircleReaderShape;
import sit.tu_varna.bg.project.readers.ellipse.EllipseReaderShape;
import sit.tu_varna.bg.project.readers.line.LineReaderShape;
import sit.tu_varna.bg.project.readers.line.PolylineReaderShape;
import sit.tu_varna.bg.project.readers.polygon.PolygonReaderShape;
import sit.tu_varna.bg.project.readers.rectangle.RectangleReaderShape;
import sit.tu_varna.bg.project.shapes.ShapeManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Клас който проита съжърданието от HTML таговете на SVG
 */
public class SvgReader {
    private String read;
    private Map<String,ReaderShape> shapes;

    /**
     * Конструктор за реализиращ класа
     * @param string низ със съдържанието от файла
     */
    public SvgReader(String string) {
        this.read = string;
        shapes = new HashMap<>();
        shapes.put("<rect",new RectangleReaderShape());
        shapes.put("<polygon",new PolygonReaderShape());
        shapes.put("<ellipse",new EllipseReaderShape());
        shapes.put("<circle",new CircleReaderShape());
        shapes.put("<line",new LineReaderShape());
        shapes.put("<polyline",new PolylineReaderShape());
    }

    /**
     * Прочита всички дъжерни тагове на SVG
     */
    public void readAllItems(){
        int startIndex = read.indexOf("<svg");
        int endIndex = read.lastIndexOf("</svg>");
        if(startIndex == -1 || endIndex == -1){
            System.out.println("Error in containing tag svg!");
            return;
        }
        String[] arr = (read.substring(startIndex, endIndex + 6)).split("\n");


        for (int i = 1; i < arr.length-1; i++) {
            try {
                checkFigure(arr[i]);
            }catch (StringIndexOutOfBoundsException |ManagerException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("All possible figures are read!");
    }
    /**
     * Проверява дали тагът за сигура съответства
     * @param str е фигурата
     */
    private void checkFigure(String str) throws ManagerException {
        ReaderShape sh;
        ManageShape manageShape = ShapeManager.getInstance();
        FlyWeightCreator f1 = FlyWeightCreator.getInstance();
        int index=str.indexOf(" ");
        String start=str.substring(0,index);
        if(shapes.containsKey(start.toLowerCase())){
            sh = shapes.get(start);
            String read=sh.convertShapeToUserReadable(str).toLowerCase();
            int index2=read.indexOf(" ");
            String s2=read.substring(0,index2);
            String s3=read.substring(index2+1);
            Shape shape =f1.getProduct(s2,s3);
            manageShape.addShape(shape);
        }

    }
}
