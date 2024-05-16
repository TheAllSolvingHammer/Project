package sit.tu_varna.bg.project.menu;

import sit.tu_varna.bg.project.contracts.ManageShape;

public class PrintCommand implements MenuCommand{
    private ManageShape manageShape;

    public PrintCommand(ManageShape manageShape) {
        this.manageShape = manageShape;
    }

    @Override
    public void execute() {
        String s1=manageShape.getItemsToUser();
        System.out.println(s1);
    }
}
