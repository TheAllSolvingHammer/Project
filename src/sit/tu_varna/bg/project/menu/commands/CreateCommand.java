package sit.tu_varna.bg.project.menu.commands;

import sit.tu_varna.bg.project.contracts.MenuCommand;
import sit.tu_varna.bg.project.contracts.Shape;
import sit.tu_varna.bg.project.factory.FlyWeightCreator;
import sit.tu_varna.bg.project.shapes.ShapeManager;

public class CreateCommand implements MenuCommand {

    private String command;

    public CreateCommand(String command) {
        this.command = command;
    }

    @Override
    public void execute() {
        if(command==null || command.isEmpty()){
            return;
        }
        ShapeManager manageShape = ShapeManager.getInstance();

        if(command.startsWith("create")){
            command=command.substring(7);
        }

        int index=command.indexOf(" ");
        if(index==-1){
            System.out.println("Index is wrong");
            return;
        }

        String s2=command.substring(0,index);
        String s3=command.substring(index+1);
        FlyWeightCreator f1 = FlyWeightCreator.getInstance();
        Shape shape = f1.getProduct(s2,s3);
        manageShape.addShape(shape);
    }
}
