package sit.tu_varna.bg.project.menu;

import com.sun.org.apache.bcel.internal.generic.FSUB;
import sit.tu_varna.bg.project.contracts.FileManage;
import sit.tu_varna.bg.project.contracts.ManageShape;
import sit.tu_varna.bg.project.enums.CommandEnum;
import sit.tu_varna.bg.project.file.FileWorker;
import sit.tu_varna.bg.project.file.write.SaveAsFile;
import sit.tu_varna.bg.project.file.write.SaveFile;

import java.util.EnumMap;
import java.util.Locale;


public class Menu {
    private EnumMap<CommandEnum,MenuCommand> map;
    private FileWorker worker;
    private ManageShape manageShape;
    private String command;



    public Menu(FileWorker worker, ManageShape manageShape) {
        this.worker = worker;
        this.manageShape = manageShape;
        this.command = "help";
        map= new EnumMap<>(CommandEnum.class);
        map.put(CommandEnum.OPEN,new OpenFileCommand(command));
        map.put(CommandEnum.SAVE,new SaveCommand(command,manageShape,worker));
        map.put(CommandEnum.SAVEAS, new SaveAsCommand(command,manageShape,worker));
        map.put(CommandEnum.CLOSE,new CloseFileCommand(worker,command));
        map.put(CommandEnum.PRINT,new PrintCommand(manageShape,command));
        map.put(CommandEnum.CREATE,new CreateCommand(manageShape,command));
        map.put(CommandEnum.ERASE,new EraseCommand(manageShape,command));
        map.put(CommandEnum.HELP,new HelpCommand());
        map.put(CommandEnum.EXIT,new ExitCommand());
    }

    public void run(){
        if(command==null || command.isEmpty()){
            System.out.println("no command");
            return;
        }
        int index=command.indexOf(" ");
        if(index==-1 && command.length()>0){
            index=command.length()-1;
        }
        String s1=command.substring(0,index);
        s1=s1.toLowerCase(Locale.ROOT);
        CommandEnum com=CommandEnum.getEnum(s1);
        if(map.containsKey(com)){

            map.get(com).execute();
        }
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
