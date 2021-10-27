package seedu.duke.exceptions.calendar;

import seedu.duke.ui.Ui;

public class CalendarIndexNotFoundException extends Exception {
    public CalendarIndexNotFoundException() {
        Ui.printMessage("Cannot find index of task to delete! Use 'calendar list task' first"
                + "to find desired task index");
    }
}
