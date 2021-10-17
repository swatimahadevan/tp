package seedu.duke.commands;


import seedu.duke.help.ClassPackageReader;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.lang.reflect.InvocationTargetException;

public class HelpCommand extends Command {

    public HelpCommand() {
    }

    /**
     * Finds all valid commands at runtime and prints syntax to user.
     * @param ui      The component of Duke that deals with the interaction with the user.
     * @param storage The component of Duke that deals with loading tasks from the file and saving tasks in the file.
     * @throws InvocationTargetException If printSyntax method fails to run.
     * @throws InstantiationException If printSyntax method fails to run.
     * @throws IllegalAccessException If printSyntax method fails to run.
     *
     * @author ngnigel99
     */
    @Override
    public void execute(Ui ui, Storage storage) throws InvocationTargetException,
            InstantiationException, IllegalAccessException {
        ClassPackageReader.getCommandsAndPrintSyntax();
    }

}
