package seedu.duke.exceptions.calendar;

public class DuplicateTaskException extends Exception {
    public DuplicateTaskException(String message) {
        System.out.println(message);
    }
}
