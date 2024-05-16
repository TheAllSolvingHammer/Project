package sit.tu_varna.bg.project.menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Menu {/*
    private final Map<String, Command> commands = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);

    public Menu() {
        FileOpener fileOpener = FileOpener.getInstance();
        FileReader fileReader = new FileReader(fileOpener);
        FileSaver fileSaver = new FileSaver(fileOpener);
        ShapePrinter shapePrinter = new ShapePrinter();
        ShapeCreator shapeCreator = new ShapeCreator();
        CommandLister commandLister = new CommandLister();

        commands.put("open", new OpenFileCommand(fileOpener, scanner));
        commands.put("read", new ReadFileCommand(fileReader));
        commands.put("save", new SaveFileCommand(fileSaver));
        commands.put("saveAs", new SaveAsFileCommand(fileSaver, scanner));
        commands.put("print", new PrintCommand(shapePrinter));
        commands.put("create", new CreateShapeCommand(shapeCreator, scanner));
        commands.put("help", new HelpCommand(commandLister));
        commands.put("exit", new ExitCommand());
    }

    public void display() {
        System.out.println("Menu:");
        System.out.println("1. open");
        System.out.println("2. read");
        System.out.println("3. save");
        System.out.println("4. saveAs");
        System.out.println("5. print");
        System.out.println("6. create");
        System.out.println("7. help");
        System.out.println("8. exit");
    }

    public void executeCommand(String commandName) {
        Command command = commands.get(commandName);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Invalid command. Type 'help' to see available commands.");
        }
    }
    */
}
