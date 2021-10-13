package seedu.duke.exceptions;

public class InvalidDateException extends Exception {
    private static String message = "Invalid date given, use format DD-MM-YYYY!";
    public InvalidDateException() {
        System.out.println(message);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
