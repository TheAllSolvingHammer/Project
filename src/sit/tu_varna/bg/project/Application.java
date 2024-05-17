package sit.tu_varna.bg.project;

import sit.tu_varna.bg.project.contracts.FileInterface;
import sit.tu_varna.bg.project.contracts.FileManage;
import sit.tu_varna.bg.project.contracts.ManageShape;
import sit.tu_varna.bg.project.enums.CommandEnum;
import sit.tu_varna.bg.project.file.FileWorker;
import sit.tu_varna.bg.project.file.write.SaveFile;
import sit.tu_varna.bg.project.menu.Menu;
import sit.tu_varna.bg.project.shapes.ShapeManager;

import java.util.Scanner;

public class Application {
    public static void runProgram(){
        Scanner scanner = new Scanner(System.in);
        Menu m1 = new Menu();

        do {
            System.out.print("Enter command: ");
            String command = scanner.nextLine();
            m1.setCommand(command);
            m1.run();
        } while (true);

    }
}
