package sit.tu_varna.bg.project.menu.commands;

import sit.tu_varna.bg.project.contracts.MenuCommand;
import sit.tu_varna.bg.project.contracts.Shape;
import sit.tu_varna.bg.project.exceptions.ManagerException;
import sit.tu_varna.bg.project.factory.FlyWeightCreator;
import sit.tu_varna.bg.project.shapes.ShapeManager;
/**
 * Клас за командата Create
 */
public class CreateCommand implements MenuCommand {
    /**
     * Метод обработващ командата
     * @param command командата която се подава
     */
    @Override
    public void execute(String command) {
        try{
        ShapeManager manageShape = ShapeManager.getInstance();
        command=command.substring(7);
        int index=command.indexOf(" ");
        String s2=command.substring(0,index);
        String s3=command.substring(index+1);
        FlyWeightCreator f1 = FlyWeightCreator.getInstance();
        Shape shape = f1.getProduct(s2,s3);
        manageShape.addShape(shape);
        } catch (ManagerException e) {
            System.out.println(e.getMessage());
        }catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds");
        }
    }
}
