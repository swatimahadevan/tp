package seedu.duke.exceptions.calendar;

import seedu.duke.ui.Ui;

public class LectureIndexNotFoundException extends Exception {
    public LectureIndexNotFoundException() {
        Ui.printMessage("Cannot find index of lecture to delete! Use 'calendar list lec' first"
                + "to find desired lecture index");
    }
}
