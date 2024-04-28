package sit.tu_varna.bg.project.creator.circle;

import sit.tu_varna.bg.project.contracts.Creator;
import sit.tu_varna.bg.project.contracts.Shape;

public class CircleCreator implements Creator {
    @Override
    public Shape createShape() {
        return null;
    }

    @Override
    public boolean validColor(String color) {
        return false;
    }
}
