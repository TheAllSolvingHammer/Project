package sit.tu_varna.bg.project.menu.commands;

import sit.tu_varna.bg.project.contracts.MenuCommand;
import sit.tu_varna.bg.project.file.FileWorker;
import sit.tu_varna.bg.project.readers.SvgReader;

import java.util.Scanner;

public class OpenFileCommand implements MenuCommand {
    private String command;

    public OpenFileCommand(String command) {
        this.command = command;
    }

    @Override
    public void execute() {
        if(command==null){
            System.out.println("command is empty");
            return;
        }
        Scanner scanner=new Scanner(command);
        if(!scanner.hasNext()){
            return;
        }
        String s1=scanner.next();
        if(!s1.equalsIgnoreCase("open")){
            return;
        }
        if(!scanner.hasNext()){
            return;
        }
        FileWorker worker= FileWorker.getInstance();
        worker.setPath(scanner.next());
        worker.open();
        worker.read();
        SvgReader svgReader = new SvgReader(worker.getContent());
        svgReader.readAllItems();
    }
}