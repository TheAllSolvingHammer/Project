package sit.tu_varna.bg.project.menu;

import sit.tu_varna.bg.project.contracts.Creator;
import sit.tu_varna.bg.project.contracts.ManageShape;
import sit.tu_varna.bg.project.contracts.Shape;
import sit.tu_varna.bg.project.creator.circle.CircleCreator;
import sit.tu_varna.bg.project.creator.ellipse.EllipseCreator;
import sit.tu_varna.bg.project.creator.line.LineCreator;
import sit.tu_varna.bg.project.creator.line.PolylineCreator;
import sit.tu_varna.bg.project.creator.polygon.PolygonCreator;
import sit.tu_varna.bg.project.creator.rectangle.RectangleCreator;

import java.util.Scanner;

public class CreateCommand implements MenuCommand{
    private ManageShape manageShape;
    private String command;

    public CreateCommand(ManageShape manageShape, String command) {
        this.manageShape = manageShape;
        this.command = command;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(command);
        scanner.useDelimiter(" ");
        if(!scanner.hasNext()) {
            return;
        }
        String s1=scanner.next();

        if(!s1.equalsIgnoreCase("create")){
            return;
        }
        if(!scanner.hasNext()){
            return;
        }
        String fig= scanner.next();
        Creator c1;
        StringBuilder sb1= new StringBuilder(fig+" ");
        switch (fig){
            case "rectangle":
                while (scanner.hasNext()) {
                    sb1.append(scanner.next()).append(" ");
                }
                c1 = new RectangleCreator(sb1.toString());
                break;
            case "circle":
                while (scanner.hasNext()) {
                    sb1.append(scanner.next()).append(" ");
                }
                c1 = new CircleCreator(sb1.toString());
                break;
            case "polygon":
                while (scanner.hasNext()) {
                    sb1.append(scanner.next()).append(" ");
                }
                c1 = new PolygonCreator(sb1.toString());
                break;
            case "polyline":
                while (scanner.hasNext()) {
                    sb1.append(scanner.next()).append(" ");
                }
                c1 = new PolylineCreator(sb1.toString());
                break;
            case "ellipse":
                while (scanner.hasNext()) {
                    sb1.append(scanner.next()).append(" ");
                }
                c1 = new EllipseCreator(sb1.toString());
                break;
            case "line":
                while (scanner.hasNext()) {
                    sb1.append(scanner.next()).append(" ");
                }
                c1 = new LineCreator(sb1.toString());
                break;
            default:
                System.out.println("Unsupported figure type: " + fig);
                return;

        }
        if(c1==null){
            return;
        }
        Shape shape=c1.createShape();
        manageShape.addShape(shape);
    }
}
