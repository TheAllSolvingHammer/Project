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
        map.put(CommandEnum.OPEN,new OpenFileCommand(command));
        map.put(CommandEnum.SAVE,new SaveCommand(command));
        map.put(CommandEnum.SAVEAS, new SaveAsCommand(command));
        map.put(CommandEnum.CLOSE,new CloseFileCommand(command));
        map.put(CommandEnum.PRINT,new PrintCommand(command));
        map.put(CommandEnum.CREATE,new CreateCommand(command));
        map.put(CommandEnum.ERASE,new EraseCommand(command));
        map.put(CommandEnum.TRANSLATE,new TranslateCommand(command));
        map.put(CommandEnum.HELP,new HelpCommand());
        map.put(CommandEnum.EXIT,new ExitCommand());
    }

    public void run(){
        if(command==null || command.isEmpty()){
            return;
        }
        String normalizedCommand = command.toLowerCase(Locale.ROOT);

        if (normalizedCommand.startsWith("open")) {
            map.get(CommandEnum.OPEN).execute();
        } else if (normalizedCommand.startsWith("close")) {
            map.get(CommandEnum.CLOSE).execute();
        } else if (normalizedCommand.startsWith("save") && normalizedCommand.length()==4) {
            map.get(CommandEnum.SAVE).execute();
        } else if (normalizedCommand.startsWith("saveas")) {
            map.get(CommandEnum.SAVEAS).execute();
        } else if (normalizedCommand.startsWith("print")) {
            map.get(CommandEnum.PRINT).execute();
        } else if (normalizedCommand.startsWith("create")) {
            map.get(CommandEnum.CREATE).execute();
        } else if (normalizedCommand.startsWith("erase")) {
            map.get(CommandEnum.ERASE).execute();
        } else if (normalizedCommand.startsWith("translate")) {
            map.get(CommandEnum.TRANSLATE).execute();}
        else if (normalizedCommand.startsWith("within")) {
            map.get(CommandEnum.WITHIN).execute();
        } else if (normalizedCommand.startsWith("help")) {
            map.get(CommandEnum.HELP).execute();
        } else if (normalizedCommand.startsWith("exit")) {
            map.get(CommandEnum.EXIT).execute();
        } else {
            System.out.println("Unknown command");
        }
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
        map.put(CommandEnum.OPEN,new OpenFileCommand(command));
        map.put(CommandEnum.SAVE,new SaveCommand(command));
        map.put(CommandEnum.SAVEAS, new SaveAsCommand(command));
        map.put(CommandEnum.CLOSE,new CloseFileCommand(command));
        map.put(CommandEnum.PRINT,new PrintCommand(command));
        map.put(CommandEnum.CREATE,new CreateCommand(command));
        map.put(CommandEnum.ERASE,new EraseCommand(command));
        map.put(CommandEnum.TRANSLATE,new TranslateCommand(command));
        map.put(CommandEnum.WITHIN,new WithinCommand(command));
        map.put(CommandEnum.HELP,new HelpCommand());
        map.put(CommandEnum.EXIT,new ExitCommand());

    }



}
