package sit.tu_varna.bg.project.contracts;

import sit.tu_varna.bg.project.regions.CircleRegion;
import sit.tu_varna.bg.project.regions.RectangleRegion;

public interface Shape {
    String convertIntoString();
    void translateX(int sx);
    void translateY(int sy);
    boolean isWithin(CircleRegion region);
    boolean isWithin(RectangleRegion region);
    String toUser();

}
