package seedu.duke.exceptions.calendar;

public class IncorrectCommandException extends Exception {
    public IncorrectCommandException(String message) {
        System.out.println(message);
    }
}
