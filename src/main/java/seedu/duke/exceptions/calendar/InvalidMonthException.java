package seedu.duke.exceptions.calendar;

import seedu.duke.exceptions.ClickException;
import seedu.duke.ui.Ui;

public class InvalidMonthException extends ClickException {
    private static String message = "The month has to be a value between 01-12!";

    public InvalidMonthException() {
    }

    @Override
    public String getMessage() {
        return message;
    }

    public static void printMessage() {
        Ui.printMessage(message);
    }
}
