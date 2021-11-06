package seedu.duke.commands.journal;

//@@author SvethaMahadevan

import seedu.duke.commands.Command;
import seedu.duke.exceptions.journal.*;
import seedu.duke.journal.Entry;
import seedu.duke.parser.journal.ParserJournal;
import seedu.duke.storage.Storage;
import seedu.duke.storage.StorageEntries;
import seedu.duke.ui.Ui;

import java.io.IOException;
import java.util.ArrayList;

public class DeleteEntryCommand extends Command {
    public String userInput;

    /**
     * Class constructor providing syntax for the HelpCommand.
     */
    public DeleteEntryCommand() {
        syntax = "journal delete_entry n/ [NOTEBOOK_NAME] e/ [ENTRY_NAME]";
    }

    /**
     * Constructor for the DeleteEntryCommand.
     *
     * @param userInput input from the user
     */
    public DeleteEntryCommand(String userInput) {
        this.userInput = userInput;
        this.helpMessage = "Deletes entry from the notebook";
        this.syntax = "journal delete_entry n/ NOTEBOOK_NAME e/ ENTRY_NAME";
    }

    /**
     * Allows for the deleting of entry.
     *
     * @param ui allows for printing of a message to indicate that the entry has been added
     * @param storage to allow for storing of entries
     * @throws InvalidNotebookIndexException
     * @throws NotebookNotFoundForEntry
     * @throws EmptyEntryNameException
     * @throws EntryDoesNotExistException
     * @throws EmptyEntryArgumentsException
     * @throws InvalidDeleteEntryArgumentException
     * @throws IOException in case of error when writing to save file.
     */
    @Override
    public void execute(Ui ui, Storage storage) throws IOException,
            InvalidNotebookIndexException,
            NotebookNotFoundForEntry, EmptyEntryNameException, EmptyNoteNameException,
            EntryDoesNotExistException, EmptyEntryArgumentsException, InvalidDeleteEntryArgumentException {
        String[] notebookNameAndEntryName = ParserJournal.parseDeleteEntryCommand(userInput, storage);
        ArrayList<Entry> entries = storage.collectionOfEntries.getEntriesArrayList();
        boolean isEntryPresent = false;
        int indexOfEntry = 0;
        for (Entry entry: entries) {
            assert notebookNameAndEntryName != null;
            if (entry.getEntryNoteName().equals(notebookNameAndEntryName[0])
                    && (entry.getNameOfJournalEntry().equals(notebookNameAndEntryName[1]))) {
                isEntryPresent = true;
                indexOfEntry = entries.indexOf(entry);
                break;
            }
        }
        if (isEntryPresent) {
            entries.remove(indexOfEntry);
            ui.printDeletedEntryMessage();
            StorageEntries.writeEntries(storage.collectionOfEntries, storage);
        } else {
            throw new EntryDoesNotExistException();
        }
    }
}

