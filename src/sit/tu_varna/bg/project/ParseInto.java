package sit.tu_varna.bg.project;

import sit.tu_varna.bg.project.shapes.Shape;

import java.util.List;

public class ParseInto {
    private List<Shape> shapes;

    public ParseInto(List<Shape> shapes) {
        this.shapes = shapes;
    }

    public String parse(){
        return "<?xml version=\"1.0\" standalone=\"no\"?>\n" +
                "<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \n" +
                "  \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n" +
                "<svg width=\"12cm\" height=\"4cm\" viewBox=\"0 0 1200 400\"\n" +
                "     xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\">\n" +
                "  <desc>Example rect02 - rounded rectangles</desc>\n" +
                "\n" +
                "  <!-- Show outline of canvas using 'rect' element -->\n" +
                "  <rect x=\"1\" y=\"1\" width=\"1198\" height=\"398\"\n" +
                "        fill=\"none\" stroke=\"blue\" stroke-width=\"2\"/>\n" +
                "\n" +
                "  <rect x=\"100\" y=\"100\" width=\"400\" height=\"200\" rx=\"50\"\n" +
                "        fill=\"green\" />\n" +
                "\n" +
                "  <g transform=\"translate(700 210) rotate(-30)\">\n" +
                "    <rect x=\"0\" y=\"0\" width=\"400\" height=\"200\" rx=\"50\"\n" +
                "          fill=\"none\" stroke=\"purple\" stroke-width=\"30\" />\n" +
                "  </g>\n" +
                "</svg>";
    }
}
