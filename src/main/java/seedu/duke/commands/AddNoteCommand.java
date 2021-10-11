package seedu.duke.commands;

import seedu.duke.storage.Storage;
import seedu.duke.storage.StorageNotes;
import seedu.duke.ui.Ui;
import seedu.duke.parser.journal.ParserJournal;

import java.io.IOException;

public class AddNoteCommand extends Command {

    public String userInput;

    public AddNoteCommand(String userInput) {
        this.userInput = userInput;
    }

    @Override
    public void execute(Ui ui, Storage storage) throws IOException {
        String noteName = ParserJournal.parseAddNoteCommand(userInput);
        storage.collectionOfNotes.addNote(noteName);
        //ui.printAddedNoteMessage(noteName);
        System.out.println("note added!");
        StorageNotes.writeCollectionOfNotes(storage.collectionOfNotes);
    }
}
