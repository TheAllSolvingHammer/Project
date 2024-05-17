package sit.tu_varna.bg.project.shapes;

import sit.tu_varna.bg.project.contracts.FileInterface;
import sit.tu_varna.bg.project.contracts.FileManage;
import sit.tu_varna.bg.project.contracts.ManageShape;
import sit.tu_varna.bg.project.enums.CommandEnum;
import sit.tu_varna.bg.project.file.FileWorker;
import sit.tu_varna.bg.project.file.write.SaveFile;
import sit.tu_varna.bg.project.menu.Menu;

import java.util.Scanner;

public class Application {
    public static void runProgram(){
        Scanner scanner= new Scanner(System.in);
        ManageShape manageShape= new ShapeManager();
        FileWorker f1= FileWorker.getInstance("\\fig.svg");
        Menu m1 = new Menu(f1,manageShape);

    CommandEnum c1 = CommandEnum.getEnum("print");
        System.out.println(c1);
        do{
            String command=scanner.nextLine();


            m1.setCommand(command);
            m1.run();
        }while (true);


    }
}
