package seedu.duke.ui;

import seedu.duke.calories.foodRecord;
import seedu.duke.constants.Messages;

import java.util.Scanner;

import static seedu.duke.constants.Messages.HORIZONTAL_LINE;
import static seedu.duke.constants.Messages.LOGO;
import static seedu.duke.constants.Messages.MESSAGE_GOODBYE;
import static seedu.duke.constants.Messages.MESSAGE_GREETING;

public class Ui {

    /**
     * Reads the text entered by the user.
     *
     * @param in The Scanner to read user input.
     * @return line Full line entered by the user.
     */
    public static String getUserInput(Scanner in) {
        String line = in.nextLine();
        return line;
    }

    /**
     * Prints the divider HORIZONTAL_LINE.
     */
    public static void printLine() {
        System.out.println(HORIZONTAL_LINE);
    }

    /**
     * Prints the greeting message to standard output.
     */
    public static void printGreeting() {
        printMessage(LOGO + MESSAGE_GREETING);
    }

    /**
     * Prints the goodbye message to standard output.
     */
    public static void printGoodBye() {
        printMessage(MESSAGE_GOODBYE);
    }

    /**
     * Prints message to the standard output.
     *
     * @param message The message to be printed.
     */
    public static void printMessage(String message) {
        System.out.println(HORIZONTAL_LINE);
        System.out.println(message);
        System.out.println(HORIZONTAL_LINE);
    }

    /**
     * Prints the name of the record, as well as the calorie count
     * @param record
     */
    public static void printAddRecord(foodRecord record)  {
        System.out.println(Messages.ADD_RECORD_GREET +
                record.getFoodName()
                + Messages.ADD_RECORD_TTL
                + Messages.ADD_RECORD_CONNECTOR
                + record.getCalorieCount()
                + Messages.ADD_RECORD_FINAL);
    }
}
