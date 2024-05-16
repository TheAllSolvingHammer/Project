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
    private SaveAsFile saveAsFile;
    private SaveFile saveFile;


    public Menu(FileWorker worker, ManageShape manageShape, String command, SaveAsFile saveAsFile, SaveFile saveFile) {
        this.worker = worker;
        this.manageShape = manageShape;
        this.command = command;
        this.saveAsFile = saveAsFile;
        this.saveFile = saveFile;
        map= new EnumMap<>(CommandEnum.class);
        map.put(CommandEnum.OPEN,new OpenFileCommand(worker));
        map.put(CommandEnum.READ,new ReadFileCommand(worker));
        map.put(CommandEnum.SAVE,new SaveCommand(saveFile));
        map.put(CommandEnum.SAVEAS, new SaveAsCommand(saveAsFile));
        map.put(CommandEnum.CLOSE,new CloseFileCommand(worker));
        map.put(CommandEnum.PRINT,new PrintCommand(manageShape));
        map.put(CommandEnum.CREATE,new CreateCommand(manageShape,command));
        map.put(CommandEnum.ERASE,new EraseCommand(manageShape,command));
        map.put(CommandEnum.HELP,new HelpCommand());
        map.put(CommandEnum.EXIT,new ExitCommand());
    }

    public void run(){
        int index=command.indexOf(" ");
        if(index==-1){
            return;
        }
        String s1=command.substring(0,index);
        s1=s1.toLowerCase(Locale.ROOT);
        if(map.containsKey(s1)){
            map.get(s1).execute();
        }
    }
}
