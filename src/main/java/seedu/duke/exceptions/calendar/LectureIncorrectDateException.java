package seedu.duke.exceptions.calendar;

import seedu.duke.exceptions.ClickException;

public class LectureIncorrectDateException extends ClickException {
    public LectureIncorrectDateException() {
        super("The start date cannot be after the end date for lecture!");
    }
}
