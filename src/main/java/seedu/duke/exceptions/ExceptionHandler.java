package seedu.duke.exceptions;

import seedu.duke.ui.Ui;

import java.time.format.DateTimeParseException;

/**
 * A class that handles exceptions thrown by Duke.
 */
public class ExceptionHandler {

    private static Ui ui = new Ui();

    /**
     * Handles duke exceptions.
     *
     * @param e Exception of type DukeException thrown by Duke.
     */
    public static void handleDukeExceptions(ClickException e, String userInput) {
        ui.printLine();
        ui.printMessage(e.getMessage());
        ui.printLine();
    }

    /**
     * Handles other exceptions.
     *
     * @param e Exception of types other than DukeException thrown by Duke.
     */
    public static void handleOtherExceptions(Exception e) {
        if (e instanceof NumberFormatException) {
            Ui.printOnlyIntegers();
        } else if (e instanceof NullPointerException) {
            e.printStackTrace();
        } else if (e instanceof DateTimeParseException) {
            ui.printLine();
            ui.printMessage("Please follow the format DD-MM-YYYY!");
            ui.printLine();
        } else if (e instanceof WrongDividerOrderException) {
            ui.printLine();
            ui.printMessage("Wrong divider order!");
            ui.printLine();
        } else {
            ui.printLine();
            ui.printMessage("OOPs, invalid command, try help for more commands.");
            ui.printLine();
        }
    }
}
