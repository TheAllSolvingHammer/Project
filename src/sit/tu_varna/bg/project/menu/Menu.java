package sit.tu_varna.bg.project.menu;

import sit.tu_varna.bg.project.contracts.MenuCommand;
import sit.tu_varna.bg.project.enums.CommandEnum;
import sit.tu_varna.bg.project.menu.commands.*;

import java.util.EnumMap;
import java.util.Locale;


public class Menu {
    private EnumMap<CommandEnum, MenuCommand> map;
    private String command=null;



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
        map.put(CommandEnum.HELP,new HelpCommand());
        map.put(CommandEnum.EXIT,new ExitCommand());
    }

    public void run(){
        if(command==null || command.isEmpty()){
            return;
        }
        String normalizedCommand = command.toLowerCase(Locale.ROOT);

        if (normalizedCommand.startsWith("open")) {
            map.get(CommandEnum.OPEN).execute(normalizedCommand);
        } else if (normalizedCommand.startsWith("close")) {
            map.get(CommandEnum.CLOSE).execute(normalizedCommand);
        } else if (normalizedCommand.startsWith("save") && normalizedCommand.length()==4) {
            map.get(CommandEnum.SAVE).execute(normalizedCommand);
        } else if (normalizedCommand.startsWith("saveas")) {
            map.get(CommandEnum.SAVEAS).execute(normalizedCommand);
        } else if (normalizedCommand.startsWith("print")) {
            map.get(CommandEnum.PRINT).execute(normalizedCommand);
        } else if (normalizedCommand.startsWith("create")) {
            map.get(CommandEnum.CREATE).execute(normalizedCommand);
        } else if (normalizedCommand.startsWith("erase")) {
            map.get(CommandEnum.ERASE).execute(normalizedCommand);
        } else if (normalizedCommand.startsWith("translate")) {
            map.get(CommandEnum.TRANSLATE).execute(normalizedCommand);}
        else if (normalizedCommand.startsWith("within")) {
            map.get(CommandEnum.WITHIN).execute(normalizedCommand);
        } else if (normalizedCommand.startsWith("help")) {
            map.get(CommandEnum.HELP).execute(normalizedCommand);
        } else if (normalizedCommand.startsWith("exit")) {
            map.get(CommandEnum.EXIT).execute(normalizedCommand);
        } else {
            System.out.println("Unknown command");
        }
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }



}
