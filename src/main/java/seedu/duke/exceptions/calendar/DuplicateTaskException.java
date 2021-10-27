package seedu.duke.exceptions.calendar;

import seedu.duke.ui.Ui;

public class DuplicateTaskException extends Exception {
    public DuplicateTaskException(String message) {
        Ui.printMessage(message);
    }
}
