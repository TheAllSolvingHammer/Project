package sit.tu_varna.bg.project.enums;

import java.util.HashMap;
import java.util.Locale;

public enum CommandEnum {
    OPEN("open"), CLOSE("close"), SAVE("save"), SAVEAS("saveas"),
    HELP("help"), PRINT("print"), CREATE("create"),
    ERASE("erase"), TRANSLATE("translate"), WITHIN("within"), EXIT("exit");

    private String val;
    private static final HashMap<String, CommandEnum> map = new HashMap<>();

    static {
        for (CommandEnum commandEnum : CommandEnum.values()) {
            map.put(commandEnum.getVal(), commandEnum);
        }
    }

    CommandEnum(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }

    public static CommandEnum getEnum(String text) {
        return map.get(text.toLowerCase(Locale.ROOT));
    }
}
