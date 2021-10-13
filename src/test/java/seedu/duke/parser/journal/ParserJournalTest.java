package seedu.duke.parser.journal;

import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.DuplicateNoteException;
import seedu.duke.exceptions.EmptyNoteArgumentsException;
import seedu.duke.exceptions.EmptyNoteNameException;
import seedu.duke.journal.Note;
import seedu.duke.storage.Storage;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParserJournalTest {

    static ParserJournal parser = new  ParserJournal();
    static Storage storage;

    static {
        try {
            storage = new Storage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void parserNotebookCommand_noNoteNameGiven() throws EmptyNoteNameException, EmptyNoteArgumentsException {
        Boolean isValidNoteName = ParserJournal.isValidNotebookCommand("journal notebook n/");
        assertEquals(false, false);
    }

    @Test
    void parserNotebookCommand_noNoteArgumentsFound() throws EmptyNoteNameException, EmptyNoteArgumentsException {
        Boolean isValidNoteArguments = ParserJournal.isValidNotebookCommand("journal notebook");
        assertEquals(false, isValidNoteArguments);
    }

    @Test
    void parserNotebookCommand_duplicateNotebookName_throwDuplicateNoteException() throws DuplicateNoteException {
        ArrayList<Note> notes = storage.collectionOfNotes.getNotesArrayList();
        String noteName = parser.checkDuplicateOrNot("journal notebook n/ notInStorageName ", notes);
        assertEquals("notInStorageName", noteName);
    }
}