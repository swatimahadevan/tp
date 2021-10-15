package seedu.duke.exceptions.journal;

public class EmptyJournalArgumentException extends Exception {
    public EmptyJournalArgumentException() {
        System.out.println("No arguments found for journal.");
    }
}
