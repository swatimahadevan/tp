package seedu.duke.exceptions.module;

import seedu.duke.exceptions.ClickException;

import static seedu.duke.constants.ExceptionMessages.MESSAGE_ILLEGAL_MODULAR_CREDIT;

public class IllegalModularCreditException extends ClickException {

    public IllegalModularCreditException() {
        super(MESSAGE_ILLEGAL_MODULAR_CREDIT);
    }
}
