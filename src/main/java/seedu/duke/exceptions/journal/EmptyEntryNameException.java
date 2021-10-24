package seedu.duke.exceptions.journal;

public class EmptyEntryNameException extends Exception {
    public EmptyEntryNameException() {
        System.out.println("No entry name entered after 'e/' ");
    }
}