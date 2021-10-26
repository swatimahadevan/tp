package seedu.duke.exceptions.food;

import seedu.duke.exceptions.ClickException;

/**
 * Thrown when the user does not issue a date when
 * finding a food record.
 */
public class MissingDateException extends ClickException {
    public MissingDateException() {
        this.message = "Date not found, try again.";
    }

    @Override
    public String getMessage() {
        return message;
    }
}