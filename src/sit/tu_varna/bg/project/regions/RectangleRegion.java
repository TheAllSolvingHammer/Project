package sit.tu_varna.bg.project.regions;

import sit.tu_varna.bg.project.contracts.Region;

public class RectangleRegion implements Region {
    private int x;
    private int y;
    private int length;
    private int width;

    public RectangleRegion(int x, int y, int length, int width) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.width = width;
    }

}
