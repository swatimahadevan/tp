package seedu.duke.exceptions.module;

import seedu.duke.exceptions.ClickException;

import static seedu.duke.constants.ExceptionMessages.MESSAGE_ILLEGAL_MODULE;

//@@author nvbinh15

/**
 * A class that represents exceptions thrown when a Module is illegal.
 */
public class IllegalModuleException extends ClickException {

    public IllegalModuleException() {
        super(MESSAGE_ILLEGAL_MODULE);
    }
}
