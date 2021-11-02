package seedu.duke.exceptions.food;

import seedu.duke.exceptions.ClickException;

/**
 * Thrown when the user does not issue a date when
 * finding a food record.
 */
public class MissingDateException extends ClickException {
    public MissingDateException() {
        super("Date not found, try again.");
    }
}
