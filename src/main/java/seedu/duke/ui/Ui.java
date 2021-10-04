package seedu.duke.ui;

public class Ui {

    private static String HORIZONTAL_LINE = "------------------------";

    public static void printMessage(String message) {
        System.out.println(HORIZONTAL_LINE);
        System.out.println(message);
        System.out.printf(HORIZONTAL_LINE);
    }
}
