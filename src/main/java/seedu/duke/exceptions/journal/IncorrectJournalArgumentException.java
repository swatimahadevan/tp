package seedu.duke.exceptions.journal;

public class IncorrectJournalArgumentException extends Exception {
    public IncorrectJournalArgumentException() {
        System.out.println("Incorrect arguments found for journal.");
    }
}
