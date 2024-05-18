package sit.tu_varna.bg.project.menu.commands;

import sit.tu_varna.bg.project.contracts.MenuCommand;

public class ExitCommand implements MenuCommand {

    @Override
    public void execute() {
        System.exit(1);
    }
}
