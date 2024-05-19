package sit.tu_varna.bg.project.menu.commands;

import sit.tu_varna.bg.project.contracts.MenuCommand;
import sit.tu_varna.bg.project.shapes.ShapeManager;
/**
 * Клас за командата Print
 */
public class PrintCommand implements MenuCommand {
    /**
     * Метод обработващ командата
     * @param command командата която се подава
     */
    @Override
    public void execute(String command) {
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
