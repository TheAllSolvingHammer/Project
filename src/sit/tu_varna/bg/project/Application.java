package sit.tu_varna.bg.project;


import sit.tu_varna.bg.project.menu.Menu;


import java.util.Scanner;

public class Application {
    public static void runProgram(){
        Scanner scanner = new Scanner(System.in);
        Menu m1 = new Menu();
        String command;
        while (true) {
            command = scanner.nextLine();
            m1.setCommand(command);
            m1.run();
        }

    }
}
