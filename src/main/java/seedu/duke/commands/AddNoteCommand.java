package seedu.duke.commands;

import seedu.duke.storage.Storage;
import seedu.duke.task.TaskList;
import seedu.duke.ui.Ui;
import seedu.duke.parser.journal.ParserJournal;

import java.util.ArrayList;

public class AddNoteCommand extends Command {

    private ArrayList<String> noteList = new ArrayList<>();
    public String userInput;

    public AddNoteCommand(String userInput) {
        this.userInput = userInput;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        String noteName = ParserJournal.parseAddNoteCommand(userInput);
        noteList.add(noteName);
        ui.printAddedNoteMessage(noteName);
    }
}

