package seedu.duke.exceptions.calendar;

import seedu.duke.exceptions.ClickException;

public class DuplicateTaskException extends ClickException {
    public DuplicateTaskException(String message) {
        super(message);
    }
}
