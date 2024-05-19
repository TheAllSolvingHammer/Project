package sit.tu_varna.bg.project.menu.commands;

import sit.tu_varna.bg.project.contracts.MenuCommand;

public class HelpCommand implements MenuCommand {
    @Override
    public void execute(String command) {
        System.out.println("Available Commands:");
        System.out.println("open  - Opens a file");
        System.out.println("save  - Saves the currently opened file");
        System.out.println("saveAs - Saves the content in a new location");
        System.out.println("close - closes opened file");
        System.out.println("print - Prints all figures");
        System.out.println("create - Creates new figure");
        System.out.println("erase - removes figure");
        System.out.println("translate - translates 1 or all figures if no number is assigned figures");
        System.out.println("within - based on a region displays all the figures in it");
        System.out.println("help  - prints this window");
        System.out.println("exit  - Terminates the program");
    }
}
