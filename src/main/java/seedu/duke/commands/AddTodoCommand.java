package seedu.duke.commands;

import java.util.ArrayList;

import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;
import seedu.duke.task.TaskList;

//@author swatim
public class AddTodoCommand extends Command {

    public AddTodoCommand(ArrayList<String> arguments) {
        super();
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
    }

}