package sit.tu_varna.bg.project.contracts;

public interface Creator {
    Shape createShape();
    boolean isValidColor(String color);

}