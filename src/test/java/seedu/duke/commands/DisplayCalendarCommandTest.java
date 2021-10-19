package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.commands.calendar.DisplayCalendarCommand;
import seedu.duke.exceptions.InvalidMonthException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DisplayCalendarCommandTest {

    @Test
    void displayCalendar_wrongMonthValue_throwException() throws InvalidMonthException {
        try {
            Command command = new DisplayCalendarCommand("calendar 22-2021");
        } catch (Exception e) {
            assertEquals("The month has to be a value between 01-12!", e.getMessage());
        }
    }

}