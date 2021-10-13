package seedu.duke.exceptions;

public class CalendarIndexNotFoundException extends Exception {
    public CalendarIndexNotFoundException() {
        System.out.println("Cannot find index of task to delete! Use 'calendar list' first"
                + "to find desired task index");
    }
}
