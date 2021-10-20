package seedu.duke.exceptions.journal;

public class EmptyNoteNameException extends Exception {
    public EmptyNoteNameException() {
        System.out.println("No note name entered after 'n/' ");
    }
}