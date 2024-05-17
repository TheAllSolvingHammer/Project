package sit.tu_varna.bg.project.menu;

import sit.tu_varna.bg.project.contracts.ManageShape;

public class PrintCommand implements MenuCommand{
    private ManageShape manageShape;
    private String command;

    public PrintCommand(ManageShape manageShape, String command) {
        this.manageShape = manageShape;
        this.command = command;
    }

    @Override
    public void execute() {
        if(command.equalsIgnoreCase("print")){
            String s1=manageShape.getItemsToUser();
            System.out.println(s1);
        }

    }
}
