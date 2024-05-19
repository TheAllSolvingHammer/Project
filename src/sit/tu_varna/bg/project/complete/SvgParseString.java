package sit.tu_varna.bg.project.complete;

import sit.tu_varna.bg.project.contracts.ManageShape;
import sit.tu_varna.bg.project.contracts.Parser;
import sit.tu_varna.bg.project.contracts.Shape;


public class SvgParseString implements Parser {
    private ManageShape shape;

    public SvgParseString(ManageShape shape) {
        this.shape = shape;
    }

    @Override
    public String parseText() {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" standalone=\"no\"?>\n" +
                "<svg width=\"50%\" height=\"50%\" viewBox=\"0 0 1200 900\"" +
                " xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\">");
        sb.append("\n");
        for(Shape s: shape.getShapes()){
            if(s!=null) {
                sb.append(s.convertIntoString());
                sb.append("\n");
            }
        }
        sb.delete(sb.length()-1,sb.length());
        sb.append("\n</svg>");
        return sb.toString();

    }
}
