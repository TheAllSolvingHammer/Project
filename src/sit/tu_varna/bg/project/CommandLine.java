package sit.tu_varna.bg.project;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandLine {
    public static void run(){
    Scanner scanner = new Scanner(System.in);
    Map<Integer, Runnable> options = new HashMap<>();

        options.put(1, CommandLine::open);
        options.put(2, CommandLine::close);
        options.put(3, CommandLine::save);
        options.put(4, CommandLine::saveAs);
        options.put(5, CommandLine::help);
        options.put(6, () -> System.out.println("Exit"));

    int choice;
        do {
        displayMenu();
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();

        Runnable action = options.get(choice);
        if (action != null) {
            action.run();
        } else {
            System.out.println("Invalid choice. ");
        }
    } while (choice != 6);

        scanner.close();
}

    private static void displayMenu() {
        System.out.println("MENU");
        System.out.println("1. Open");
        System.out.println("2. Close");
        System.out.println("3. Save");
        System.out.println("4. Save as");
        System.out.println("5. Help");
        System.out.println("6. Exit");
    }

    private static void open() {

// will have info about later
    }

    private static void close() {
        System.out.println("zatvarqne");

    }

    private static void save() {


    }
    private static void saveAs() {


    }
    private static void help() {
        System.out.println("i need help also");

    }
}
