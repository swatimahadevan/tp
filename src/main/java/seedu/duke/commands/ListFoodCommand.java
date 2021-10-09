package seedu.duke.commands;

import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

/**
 * List all current records (assumed today for simplicity).
 *  //TODO integrate storage component into list
 * @author ngnigel99
 */
public class ListFoodCommand extends Command  {

    @Override
    public void execute(Ui ui, Storage storage) {
        storage.whatIAteTodayList.printList();
    }
}
