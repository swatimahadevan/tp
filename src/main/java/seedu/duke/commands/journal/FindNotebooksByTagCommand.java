package seedu.duke.commands.journal;

//@@author SvethaMahadevan

import seedu.duke.commands.Command;
import seedu.duke.exceptions.journal.InvalidTagNameException;
import seedu.duke.journal.Note;
import seedu.duke.parser.journal.ParserJournal;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.io.IOException;
import java.util.ArrayList;

public class FindNotebooksByTagCommand extends Command {

    public String userInput;

    /**
     * Class constructor providing syntax for the HelpCommand.
     */
    public FindNotebooksByTagCommand() {
        syntax = "journal find [TAG_NAME]";
    }


    /**
     * Constructor for the FindNotebookByTagCommand.
     *
     * @param userInput input from the user.
     */
    public FindNotebooksByTagCommand(String userInput) {
        this.userInput = userInput;
        helpMessage = "Find notebooks with the tag";
        syntax = "journal find TAG_NAME";
    }


    /**
     * Finds notebooks based on tag.
     *
     * @param ui allows for printing that note is added
     * @param storage to allow for storage of notes
     */
    @Override
    public void execute(Ui ui, Storage storage) throws IOException, InvalidTagNameException {
        String tagName = ParserJournal.parseTagForFinding(userInput);
        ArrayList<Note> notes = storage.collectionOfNotes.getNotesArrayList();
        ui.printLine();
        ui.printMessage("Notebooks with the tag " + tagName.trim() + " are: ");
        for (Note note: notes) {
            if (note.getTag().equals(tagName.trim())) {
                ui.printMessage(note.getNoteName());
            }
        }
        ui.printLine();
    }
}