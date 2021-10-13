package seedu.duke.exceptions;

public class InvalidMonthException extends ClickException {
    private static String message = "The month has to be a value between 01-12!";
    public InvalidMonthException() {
    }

    @Override
    public String getMessage() {
        return message;
    }

    public static void printMessage() {
        System.out.println(message);
    }
}
