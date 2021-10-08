package seedu.duke.commands;

import seedu.duke.storage.Storage;
import seedu.duke.task.TaskList;
import seedu.duke.ui.Ui;

/**
 * Clears the current list  of food, and clear entries in storage.
 * @author  ngnigel99
 */
public class ClearFoodCommand extends Command {
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        //TODO integrate into storage
        //storage.whatIAteTodayList.clearList();
    }
}
