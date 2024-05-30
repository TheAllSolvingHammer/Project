package sit.tu_varna.bg.project.menu;


import sit.tu_varna.bg.project.contracts.MenuCommand;
import sit.tu_varna.bg.project.enums.CommandEnum;
import sit.tu_varna.bg.project.menu.commands.*;

import java.util.EnumMap;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Клас меню, с което потребителя ще достъпва различните функционалности на програмата
 */
public class Menu {
    private EnumMap<CommandEnum, MenuCommand> map;
    private String command;


    /**
     * Конструктор на менюто, инициализиращ мап с командите
     */
    public Menu() {
        map= new EnumMap<>(CommandEnum.class);
        map.put(CommandEnum.OPEN,new OpenFileCommand());
        map.put(CommandEnum.SAVE,new SaveCommand());
        map.put(CommandEnum.SAVEAS, new SaveAsCommand());
        map.put(CommandEnum.CLOSE,new CloseFileCommand());
        map.put(CommandEnum.PRINT,new PrintCommand());
        map.put(CommandEnum.CREATE,new CreateCommand());
        map.put(CommandEnum.ERASE,new EraseCommand());
        map.put(CommandEnum.TRANSLATE,new TranslateCommand());
        map.put(CommandEnum.WITHIN,new WithinCommand());
        map.put(CommandEnum.HELP,new HelpCommand());
        map.put(CommandEnum.EXIT,new ExitCommand());

    }

    /**
     * стартира команда спрямо това каквъв е бил потребителския избор, ако е грешен се изписва съобщение за грешка
     */
    public void run(){
        try {
            String normalizedCommand = command.toLowerCase(Locale.ROOT);
            Scanner scanner = new Scanner(normalizedCommand);
            scanner.useDelimiter(" ");

            String commandWork = scanner.next();
            if (map.containsKey(CommandEnum.getEnum(commandWork))) {
                map.get(CommandEnum.getEnum(commandWork)).execute(command);
            } else System.out.println("Wrong command");
        }
        catch (NullPointerException | NoSuchElementException e) {
            System.out.println("No command found");
        }
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }



}
