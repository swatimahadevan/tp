package seedu.duke.exceptions.calendar;

import seedu.duke.exceptions.ClickException;

public class IncorrectNumberOfArgumentsException extends ClickException {
    public IncorrectNumberOfArgumentsException(String message) {
        super(message);
    }
}
