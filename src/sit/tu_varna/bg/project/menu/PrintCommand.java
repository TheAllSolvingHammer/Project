package sit.tu_varna.bg.project.menu;

import sit.tu_varna.bg.project.contracts.ManageShape;
import sit.tu_varna.bg.project.contracts.Shape;
import sit.tu_varna.bg.project.shapes.ShapeManager;

public class PrintCommand implements MenuCommand{
    private String command;

    public PrintCommand(String command) {
        this.command = command;
    }

    @Override
    public void execute() {
        if(command==null || command.isEmpty()){
            return;
        }
        ShapeManager manageShape =ShapeManager.getInstance();
        if(command.equalsIgnoreCase("print")){
            String s1=manageShape.getItemsToUser();
            System.out.println(s1);
        }

    }
}
