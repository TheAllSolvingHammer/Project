package sit.tu_varna.bg.project.contracts;

import sit.tu_varna.bg.project.exceptions.FigureException;
import sit.tu_varna.bg.project.regions.CircleRegion;
import sit.tu_varna.bg.project.regions.RectangleRegion;


public interface Shape {
    String convertIntoString();
    void translateX(int sx) throws FigureException;
    void translateY(int sy) throws FigureException;
    boolean isWithin(CircleRegion region);
    boolean isWithin(RectangleRegion region);
    String toUser();

}
