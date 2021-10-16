package seedu.duke.exceptions.journal;

public class EmptyNoteArgumentsException extends Exception {
    public EmptyNoteArgumentsException() {
        System.out.println("No arguments found for notebook.");
    }
}