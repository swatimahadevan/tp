package seedu.duke.commands.calendar;

import seedu.duke.commands.Command;
import seedu.duke.storage.Storage;
import seedu.duke.storage.StorageTasks;
import seedu.duke.schedule.task.TaskList;
import seedu.duke.ui.Ui;

import java.io.IOException;

public class ListTasksCommand extends Command {

    public ListTasksCommand() {
        this.helpMessage = "List all tasks";
        this.syntax = "calendar list";
    }

    /**
     * Executes listing of tasks.
     *
     * @param ui The component of CLICK that deals with the interaction with the user.
     * @param storage The component of CLICK that deals with loading tasks from the file and saving tasks in the file.
     * @throws IOException If command entered is wrong.
     */
    @Override
    public void execute(Ui ui, Storage storage) throws IOException {
        TaskList tasks = StorageTasks.readTaskList();
        Ui.printTaskList(tasks.getTaskList());
    }
}