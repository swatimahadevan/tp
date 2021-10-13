package seedu.duke.parser.journal;

import seedu.duke.exceptions.DuplicateNoteException;
import seedu.duke.exceptions.EmptyEntryArgumentsException;
import seedu.duke.exceptions.EmptyNoteArgumentsException;
import seedu.duke.exceptions.EmptyNoteNameException;
import seedu.duke.exceptions.EmptyEntryNameException;
import seedu.duke.exceptions.NotebookArgumentNotFoundException;
import seedu.duke.exceptions.NotebookNotFoundForEntryAddition;
import seedu.duke.journal.Note;
import seedu.duke.parser.Parser;
import seedu.duke.storage.Storage;

import java.util.ArrayList;

public class ParserJournal {

    /**
     * Returns the name of the notebook.
     *
     * @param input contains notebook information
     * @return noteName a string which contains the name of the notebook
     * @throws DuplicateNoteException if notebook with same name has been added before
     */
    public static String parseAddNoteCommand(String input, Storage storage) throws DuplicateNoteException,
            EmptyNoteNameException, EmptyNoteArgumentsException {
        if (isValidNotebookCommand(input)) {
            ArrayList<Note> notes = storage.collectionOfNotes.getNotesArrayList();
            String noteName = checkDuplicateOrNot(input, notes);
            return noteName;
        }
        return null;
    }

    /**
     * Checking if addition of notebook will result in duplicates.
     *
     * @param input getting userInput regarding notebook
     * @param notes list of notes
     * @return notebook name if it is not duplicate
     * @throws DuplicateNoteException checks for duplicate note
     */
    public static String checkDuplicateOrNot(String input, ArrayList<Note> notes) throws DuplicateNoteException {
        String noteNameDetails = input.trim().split("notebook")[1];
        String noteName = noteNameDetails.split("n/")[1].trim();
        for (Note note : notes) {
            if (note.getNoteName().equals(noteName)) {
                throw new DuplicateNoteException();
            }
        }
        return noteName;
    }

    /**
     * To check if notebook command is valid, else false.
     *
     * @param input user input
     * @return true if notebook command is valid, else false
     * @throws EmptyNoteArgumentsException checks if note arguments are empty
     * @throws EmptyNoteNameException checks if notebook name is not entered
     */
    public static boolean isValidNotebookCommand(String input) throws EmptyNoteArgumentsException,
            EmptyNoteNameException {
        final String[] commandTypeAndParams = Parser.splitCommandAndArgs(input);
        final String commandArgs = commandTypeAndParams[1];
        String[] noteArguments = commandArgs.split(" ");
        if (noteArguments.length == 1) {
            throw new EmptyNoteArgumentsException();
        }
        if (noteArguments.length == 2 && noteArguments[1].equals("n/")) {
            throw new EmptyNoteNameException();
        }
        return true;
    }


    /**
     * Returns the name of the notebook and entry to allow for adding of entry.
     *
     * @param input contains information about entry and the desired notebook from user
     * @return a String array which stores notebook name and entry name
     * @throws EmptyEntryArgumentsException if no arguments found after entry
     * @throws EmptyNoteNameException if no note name found after n/
     * @throws EmptyEntryNameException if no entry name found after e/
     * @throws NotebookArgumentNotFoundException note or entry argument not found when adding entry.
     * @throws NotebookNotFoundForEntryAddition if notebook to add entry doesn't exist
     */
    public static String[] parseAddEntryCommand(String input, Storage storage) throws EmptyEntryArgumentsException,
            EmptyNoteNameException, EmptyEntryNameException, NotebookArgumentNotFoundException,
            NotebookNotFoundForEntryAddition {
        final String[] commandTypeAndParams = Parser.splitCommandAndArgs(input);
        final String commandArgs = commandTypeAndParams[1];
        ArrayList<Note> notes = storage.collectionOfNotes.getNotesArrayList();
        String[] noteArguments = commandArgs.split(" ");
        if (noteArguments.length == 1) {
            throw new EmptyEntryArgumentsException();
        }
        if (noteArguments.length == 2 && noteArguments[1].equals("n/")) {
            throw new EmptyNoteNameException();
        }
        if (noteArguments.length == 4 && noteArguments[3].equals("e/")) {
            throw new EmptyEntryNameException();
        }
        boolean isNoteArgumentPresent = false;
        boolean isEntryArgumentPresent = false;
        for (String noteArgument : noteArguments) {
            if (noteArgument.equals("n/")) {
                isNoteArgumentPresent = true;
            }
            if (noteArgument.equals("e/")) {
                isEntryArgumentPresent = true;
            }
        }
        if (isEntryArgumentPresent && isNoteArgumentPresent) {
            String[] noteEntryNames = parseNoteEntryName(input);
            int flagNotebook = notes.stream().anyMatch(note -> note.getNoteName().equals(noteEntryNames[0])) ? 1 : 0;
            if (flagNotebook == 0) {
                throw new NotebookNotFoundForEntryAddition();
            } else {
                return new String[]{noteEntryNames[0], noteEntryNames[1]};
            }
        } else if (isEntryArgumentPresent && !isNoteArgumentPresent) {
            throw new NotebookArgumentNotFoundException("Note argument not found!");
        } else if (!isEntryArgumentPresent && isNoteArgumentPresent) {
            throw new NotebookArgumentNotFoundException("Entry argument not found!");
        }
        return null;
    }

    /**
     * Parsing notebook and entry name.
     *
     * @param input from user
     * @return notebook name and entry name in form of string array
     */
    public static String[] parseNoteEntryName(String input) {
        String noteNameDetails = input.trim().split("entry")[1];
        String noteAndEntryName = noteNameDetails.split("n/")[1].trim();
        String entryName = noteAndEntryName.split("e/")[1].trim();
        String noteName = noteAndEntryName.split("e/")[0].trim();
        return new String[]{noteName, entryName};
    }
}