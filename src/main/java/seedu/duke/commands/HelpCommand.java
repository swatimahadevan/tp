package seedu.duke.commands;


import seedu.duke.constants.CommandConstants;
import seedu.duke.constants.Messages;
import seedu.duke.exceptions.HelpException;
import seedu.duke.help.ClassPackageReader;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

//@@author ngnigel99
import java.lang.reflect.InvocationTargetException;

public class HelpCommand extends Command {
    boolean runTime = false;

    public HelpCommand() {
        syntax = "help";
    }

    public HelpCommand(String input) throws
            HelpException {
        if (input.equals("help rt")) {
            runTime = !runTime; //toggles runtime
            Ui.printLine();
            Ui.printMessage("***RUNTIME MODE ENABLED***");
            Ui.printMessage("Please revert mode if you're not a developer!");
            Ui.printLine();
        } else {
            throw new HelpException();
        }
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
        if (runTime) {
            ClassPackageReader.getCommandsAndPrintSyntax(); //- to be done using source files (by developers)
        } else {
            Ui.printLine();
            System.out.println(CommandConstants.HELP_MESSAGES);
            Ui.printLine();
        }
    }

}
