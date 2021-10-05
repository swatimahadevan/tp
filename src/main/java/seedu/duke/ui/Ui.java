package seedu.duke.ui;

import seedu.duke.calories.FoodRecord;
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
     * Prints the name of the record, as well as the calorie count.
     * @author ngnigel99
     * @param record record to be added
     */
    //TODO  remove messages, may be neater
    public static void printAddRecord(FoodRecord record)  {
        System.out.println(Messages.ADD_RECORD_GREET
                + record.getFoodName()
                + Messages.ADD_RECORD_TTL
                + Messages.ADD_RECORD_CONNECTOR
                + record.getCalorieCount()
                + Messages.ADD_RECORD_FINAL);
    }

    /**
     * Prints success on clear message to user.
     *
     * @author ngnigel99
     */
    public static void printDoneClearList() {
        System.out.println(Messages.PRINT_DONE_CLEAR_LIST);
    }

    //UI for journal
    public static void printIntroMessage()
    {
        System.out.println("Hello, I am Journal Bud.");
        System.out.println("How may I help you?");
    }

    public static void printAddedNoteMessage(String noteName)
    {
        System.out.println("Great you have added the note: " + noteName);
    }
    //end of UI for journal

}
