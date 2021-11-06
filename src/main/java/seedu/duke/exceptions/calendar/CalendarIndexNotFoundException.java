package seedu.duke.exceptions.calendar;

import seedu.duke.constants.ExceptionMessages;
import seedu.duke.exceptions.ClickException;

public class CalendarIndexNotFoundException extends ClickException {
    public CalendarIndexNotFoundException() {
        super(ExceptionMessages.MESSAGE_ILLEGAL_CALENDAR_INDEX);
    }
}
