package sit.tu_varna.bg.project.enums;

public enum CommandEnum {
    OPEN("open"),READ("read"),CLOSE("close"),SAVE("save"),SAVEAS("saveas"),
    HELP("help"),PRINT("print"),CREATE("create"),
    ERASE("erase"),TRANSLATE("translate"),WITHIN("within"),EXIT("exit");
    private final String val;

    CommandEnum(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}
