package sit.tu_varna.bg.project.menu;

public class ExitCommand implements MenuCommand{

    @Override
    public void execute() {
        System.exit(1);
    }
}
