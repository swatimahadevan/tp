package seedu.duke.exceptions.calendar;

import seedu.duke.exceptions.ClickException;

/**
 * Represents exception thrown when index of task
 * to delete is not found.
 */
public class DuplicateTaskException extends ClickException {
    public DuplicateTaskException(String message) {
        super(message);
    }
}
