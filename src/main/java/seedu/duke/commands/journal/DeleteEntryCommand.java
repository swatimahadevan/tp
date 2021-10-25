package seedu.duke.commands.journal;

import seedu.duke.commands.Command;
import seedu.duke.exceptions.journal.EmptyEntryArgumentsException;
import seedu.duke.exceptions.journal.EmptyEntryNameException;
import seedu.duke.exceptions.journal.EmptyNoteNameException;
import seedu.duke.exceptions.journal.NotebookArgumentNotFoundException;
import seedu.duke.exceptions.journal.NotebookNotFoundForEntryAddition;
import seedu.duke.journal.Note;
import seedu.duke.parser.journal.ParserJournal;
import seedu.duke.storage.Storage;
import seedu.duke.storage.StorageEntries;
import seedu.duke.storage.StorageNotes;
import seedu.duke.ui.Ui;

import java.io.IOException;
import java.util.ArrayList;

public class DeleteEntryCommand extends Command {
    public String userInput;

    public DeleteEntryCommand() {
        syntax = "journal delete_entry n/ NOTEBOOK_NAME e/ ENTRY_INDEX";
    }

    /**
     * Constructor for the DeleteEntryCommand.
     *
     * @param userInput input from the user
     */
    public DeleteEntryCommand(String userInput) {
        this.userInput = userInput;
        this.helpMessage = "Deletes entry from the notebook";
        this.syntax = "journal delete_entry n/ NOTEBOOK_NAME e/ ENTRY_INDEX";
    }

    /**
     * Allows for the deleting of entry.
     *
     * @param ui allows for printing of a message to indicate that the entry has been added
     * @param storage to allow for storing of entries
     */
    @Override
    public void execute(Ui ui, Storage storage) throws IOException {
        String[] notebookNameAndEntryIndex = ParserJournal.parseDeleteEntryCommand(userInput);
        ui.printDeletedEntryMessage();
        storage.collectionOfEntries.deleteEntry(notebookNameAndEntryIndex[0],
                Integer.parseInt(notebookNameAndEntryIndex[1]));
        StorageEntries.writeEntries(storage.collectionOfEntries);
    }
}

