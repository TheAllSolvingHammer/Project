package sit.tu_varna.bg.project.menu.commands;

import sit.tu_varna.bg.project.contracts.MenuCommand;
/**
 * Клас за командата Exit
 */
public class ExitCommand implements MenuCommand {
    /**
     * Метод за прекратяване на програмата
     * @param command командата която се подава
     */
    @Override
    public void execute(String command) {
        System.exit(1);
    }
}
