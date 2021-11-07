package seedu.duke.exceptions.calendar;

import seedu.duke.constants.ExceptionMessages;

public class LectureIndexNotFoundException extends Exception {
    public LectureIndexNotFoundException() {
        super(ExceptionMessages.MESSAGE_ILLEGAL_LECTURE_INDEX);
    }
}
