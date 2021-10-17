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

public class AddNoteCommand extends Command {


    public String userInput;

    public AddNoteCommand() {
    }

    /**
     * Constructor for the AddNoteCommand.
     *
     * @param userInput input from the user.
     */
    public AddNoteCommand(String userInput) {
        this.userInput = userInput;
        this.helpMessage = "Add a notebook to list";
        this.syntax = "journal notebook n/ NOTEBOOK_NAME";
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
        assert (noteName != null);
        ui.printAddedNoteMessage(noteName);
        storage.collectionOfNotes.addNote(noteName);
        StorageNotes.writeCollectionOfNotes(storage.collectionOfNotes);
    }
}
