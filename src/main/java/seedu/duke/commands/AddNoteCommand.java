package seedu.duke.commands;

import seedu.duke.exceptions.DuplicateNoteException;
import seedu.duke.exceptions.EmptyNoteArgumentsException;
import seedu.duke.exceptions.EmptyNoteNameException;
import seedu.duke.exceptions.NotebookArgumentNotFoundException;
import seedu.duke.parser.journal.ParserJournal;
import seedu.duke.storage.Storage;
import seedu.duke.storage.StorageNotes;
import seedu.duke.ui.Ui;

import java.io.IOException;

public class AddNoteCommand extends Command {

    public String userInput;

    /**
     * Constructor for the AddNoteCommand.
     *
     * @param userInput input from the user.
     */
    public AddNoteCommand(String userInput) {
        this.userInput = userInput;
    }


    /**
     * Adds the notebooks to a collection of notebooks.
     *
     * @param ui allows for printing that note is added
     * @param storage to allow for storage of notes
     * @throws EmptyNoteNameException No note name entered after 'n/'.
     * @throws EmptyNoteArgumentsException if no arguments found for notebook.
     */
    @Override
    public void execute(Ui ui, Storage storage) throws EmptyNoteNameException, EmptyNoteArgumentsException, IOException,
            DuplicateNoteException, NotebookArgumentNotFoundException {
        String noteName = ParserJournal.parseAddNoteCommand(userInput, storage);
        if (noteName == null) {
            throw new NotebookArgumentNotFoundException("Note argument not found!");
        }
        ui.printAddedNoteMessage(noteName);
        storage.collectionOfNotes.addNote(noteName);
        StorageNotes.writeCollectionOfNotes(storage.collectionOfNotes);
    }
}
