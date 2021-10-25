package seedu.duke.exceptions.journal;

public class EmptyEntryArgumentsException extends Exception {
    public EmptyEntryArgumentsException() {
        System.out.println("No arguments found for entry.");
    }
}
