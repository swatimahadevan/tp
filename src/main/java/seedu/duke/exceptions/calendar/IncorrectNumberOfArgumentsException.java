package seedu.duke.exceptions.calendar;

import seedu.duke.ui.Ui;

public class IncorrectNumberOfArgumentsException extends Exception {
    public IncorrectNumberOfArgumentsException(String message) {
        Ui.printMessage(message);
    }
}
