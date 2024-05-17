package sit.tu_varna.bg.project.readers;

public class SvgReader {
    private String read;

    public SvgReader(String string) {
        this.read = string;
    }
    public void readAllItems(){
        if (read == null || read.isEmpty()) {
            return;
        }

        int startIndex = read.indexOf("<svg");
        if (startIndex < 0) {
            throw new IllegalArgumentException("Invalid SVG string: Missing opening <svg> tag");
        }
        int endIndex = read.lastIndexOf("</svg>");
        if (endIndex < 0) {
            throw new IllegalArgumentException("Invalid SVG string: Missing closing </svg> tag");
        }
        System.out.println(read.substring(startIndex, endIndex + 6));
    }
}
