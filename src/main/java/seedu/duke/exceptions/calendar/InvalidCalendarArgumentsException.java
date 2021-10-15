package seedu.duke.exceptions.calendar;

public class InvalidCalendarArgumentsException extends Exception {
    public InvalidCalendarArgumentsException() {
        System.out.println("Incorrect arguments found for calendar!");
    }
}
