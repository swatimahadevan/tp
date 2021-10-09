package seedu.duke.commands;

import seedu.duke.storage.Storage;
import seedu.duke.task.TaskList;
import seedu.duke.ui.Ui;

import java.util.Scanner;

//@@author nvbinh15

/**
 * A representation of the command for exiting the program.
 */
public class ExitCommand extends Command {

    /**
     * Executes the exit command.
     *  @param ui The component of Duke that deals with the interaction with the user.
     * @param storage The component of Duke that deals with loading tasks from the file and saving tasks in the file.
     * @param in Scanner  to read input
     */
    @Override
    public void execute(Ui ui, Storage storage, Scanner in) {
        ui.printGoodBye();
        System.exit(0);
    }
}
