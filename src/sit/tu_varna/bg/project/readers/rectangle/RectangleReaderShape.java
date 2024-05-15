package sit.tu_varna.bg.project.readers.rectangle;

import sit.tu_varna.bg.project.contracts.ReaderShape;

import java.util.Scanner;

public class RectangleReaderShape implements ReaderShape {
    private String shapeString;

    public RectangleReaderShape(String shapeString) {
        this.shapeString = shapeString;
    }

    @Override
    public String convertShapeToUserReadable() {
        Scanner scanner = new Scanner(shapeString);
        scanner.useDelimiter("[=\" ]+");

        scanner.next();

        StringBuilder sb = new StringBuilder();
        sb.append("rect ");

        if (scanner.hasNext("fill")) {
            scanner.next();
            sb.append(scanner.next()).append(" ");
        } else {
            System.out.println("Error: 'fill' attribute not found.");
            return null;
        }

        if (scanner.hasNext("stroke")) {
            scanner.next();
            sb.append(scanner.next()).append(" ");
        } else {
            System.out.println("Error: 'stroke' attribute not found.");
            return null;
        }

        if (scanner.hasNext("stroke-width")) {
            scanner.next();
            if (scanner.hasNextInt()) {
                sb.append(scanner.nextInt()).append(" ");
            } else {
                System.out.println("Error: 'stroke-width' attribute is not a double.");
                return null;
            }
        } else {
            System.out.println("Error: 'stroke-width' attribute not found.");
            return null;
        }

        if (scanner.hasNext("x")) {
            scanner.next();
            if (scanner.hasNextInt()) {
                sb.append(scanner.nextInt()).append(" ");
            } else {
                System.out.println("Error: 'x' attribute is not an integer.");
                return null;
            }
        } else {
            System.out.println("Error: 'x' attribute not found.");
            return null;
        }

        if (scanner.hasNext("y")) {
            scanner.next();
            if (scanner.hasNextInt()) {
                sb.append(scanner.nextInt()).append(" ");
            } else {
                System.out.println("Error: 'y' attribute is not an integer.");
                return null;
            }
        } else {
            System.out.println("Error: 'y' attribute not found.");
            return null;
        }

        if (scanner.hasNext("width")) {
            scanner.next();
            if (scanner.hasNextInt()) {
                sb.append(scanner.nextInt()).append(" ");
            } else {
                System.out.println("Error: 'width' attribute is not an integer.");
                return null;
            }
        } else {
            System.out.println("Error: 'width' attribute not found.");
            return null;
        }

        if (scanner.hasNext("height")) {
            scanner.next();
            if (scanner.hasNextInt()) {
                sb.append(scanner.nextInt()).append(" ");
            } else {
                System.out.println("Error: 'height' attribute is not an integer.");
                return null;
            }
        } else {
            System.out.println("Error: 'height' attribute not found.");
            return null;
        }
        if(!scanner.hasNext()){
            scanner.close();
            return sb.toString();
        }
        int roundX=0,roundY=0;
        if (scanner.hasNext("rx")) {
            scanner.next();
            if (scanner.hasNextInt()) {
                roundX= scanner.nextInt();
            }
        }
        if (scanner.hasNext("ry")) {
            scanner.next();
            if (scanner.hasNextInt()) {
                roundY= scanner.nextInt();
            }
        }
        if(roundX>0 && roundY>0){
            sb.append(roundX).append(" ").append(roundY);
        }
        scanner.close();
        return sb.toString();

    }
}
