package seedu.duke.exceptions.calendar;

public class IncorrectDateFormatException extends Exception {
    public IncorrectDateFormatException() {
        System.out.println("You have given a date of incorrect format! Try DD-MM-YYY...");
    }
}
