package seedu.duke.commands.journal;

import seedu.duke.commands.Command;
import seedu.duke.exceptions.journal.DuplicateNoteException;
import seedu.duke.exceptions.journal.EmptyNoteArgumentsException;
import seedu.duke.exceptions.journal.EmptyNoteNameException;
import seedu.duke.exceptions.journal.NotebookArgumentNotFoundException;
import seedu.duke.parser.journal.ParserJournal;
import seedu.duke.storage.Storage;
import seedu.duke.storage.StorageNotes;
import seedu.duke.ui.Ui;

import java.io.IOException;

public class DeleteNoteCommand extends Command {


    public String userInput;

    public DeleteNoteCommand() {
        syntax = "journal delete NOTE_INDEX";
    }

    /**
     * Constructor for the DeleteNoteCommand.
     *
     * @param userInput input from the user.
     */
    public DeleteNoteCommand(String userInput) {
        this.userInput = userInput;
        helpMessage = "Delete a notebook from list";
        syntax = "journal delete_notebook n/ NOTEBOOK_NAME";
    }


    /**
     * Deletes the notebooks from a collection of notebooks.
     *
     * @param ui allows for printing that note is added
     * @param storage to allow for storage of notes
     * @throws EmptyNoteNameException No note name entered after 'n/'.
     * @throws EmptyNoteArgumentsException if no arguments found for notebook.
     */
    @Override
    public void execute(Ui ui, Storage storage) throws IOException {
        int indexOfNotebookToDelete = ParserJournal.parseDeleteNoteCommand(userInput);
        ui.printDeletedNotebookMessage(indexOfNotebookToDelete);
        storage.collectionOfNotes.deleteNote(indexOfNotebookToDelete);
        StorageNotes.writeCollectionOfNotes(storage.collectionOfNotes);
    }
}
