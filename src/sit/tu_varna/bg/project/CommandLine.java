package sit.tu_varna.bg.project;

import java.util.Scanner;

public class CommandLine {
    public static void executeCommand() {
        Scanner scanner = new Scanner(System.in);
        String command;
        do {
            System.out.print("Enter a command: ");
            command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "open":
                    // class file open
                    break;
                case "close":
                    // class file CloseFile
                    break;
                case "save":
                    // class saver
                    break;
                case "save as":
                    System.out.println("where to save");
                    break;
                case "help":
                    //help menu

                    break;
                case "exit":

                    break;
                default:
                    //invalid command statemnt will be aserted
                    break;
            }
        } while (!command.equalsIgnoreCase("exit"));

        scanner.close();
    }
}
