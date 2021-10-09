package seedu.duke.commands;

import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

/**
 * Clears the current list  of food, and clear entries in storage.
 * @author  ngnigel99
 */
public class ClearFoodCommand extends Command {
    @Override
    public void execute(Ui ui, Storage storage) {
        storage.whatIAteTodayList.clearList();
    }
}
