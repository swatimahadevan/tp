package seedu.duke.exceptions.calendar;

import seedu.duke.ui.Ui;

public class InvalidDateException extends Exception {
    private static String message = "Invalid date given!";

    public InvalidDateException() {
        Ui.printMessage(message);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
