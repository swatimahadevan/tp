package seedu.duke.exceptions.calendar;

import seedu.duke.ui.Ui;

public class IncorrectCommandException extends Exception {
    public IncorrectCommandException(String message) {
        Ui.printMessage(message);
    }
}
