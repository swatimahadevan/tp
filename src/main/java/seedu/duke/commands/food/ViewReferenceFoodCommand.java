package seedu.duke.commands.food;
//@@author ngnigel99

import seedu.duke.commands.Command;
import seedu.duke.exceptions.ClickException;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

/**
 * Command to display a reference list to the user.
 * In particular, this would involve listing the stall names
 * as well as allowing the user to view the specific items
 * sold by a store.
 */
public class ViewReferenceFoodCommand extends Command {

    public ViewReferenceFoodCommand() {
        this.syntax = "";
    }

    public ViewReferenceFoodCommand(String userInput) {

    }

    @Override
    public void execute(Ui ui, Storage storage) throws ClickException, Exception {

    }
}
