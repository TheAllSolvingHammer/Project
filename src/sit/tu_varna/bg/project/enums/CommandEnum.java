package sit.tu_varna.bg.project.enums;

import java.util.HashMap;
import java.util.Locale;

/**
 * Енум с командите, които програмата поддържа
 */
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

    /**
     * Конструктор на енума с фигурите
     * @param val стойноста на командата
     */
    CommandEnum(String val) {
        this.val = val;
    }

    /**
     * Връща стойността на дадената константа
     * @return стойността на константата
     */
    public String getVal() {
        return val;
    }

    /**
     * Гетър на константа, като я проверява в мапа и я връща на база на подаден текст
     * @param text командата като стринг
     * @return константата отговаряща на командата
     */
    public static CommandEnum getEnum(String text) {
        return map.get(text.toLowerCase(Locale.ROOT));
    }
}
