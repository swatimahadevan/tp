package seedu.duke.commands.calendar;

import seedu.duke.commands.Command;
import seedu.duke.schedule.lecture.LectureList;
import seedu.duke.schedule.task.TaskList;
import seedu.duke.storage.Storage;
import seedu.duke.storage.StorageLecture;
import seedu.duke.storage.StorageTasks;
import seedu.duke.ui.Ui;

import java.io.IOException;

public class ListLecturesCommand extends Command {

    public ListLecturesCommand() {
        this.helpMessage = "List all lectures";
        this.syntax = "calendar list lec";
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
        LectureList lectures = StorageLecture.readLectureList();
        Ui.printLectureList(lectures.getLectureList());
    }
}