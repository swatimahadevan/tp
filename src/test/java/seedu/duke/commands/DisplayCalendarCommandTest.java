package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.commands.calendar.DisplayCommand;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DisplayCalendarCommandTest {

    @Test
    void displayCalendar_wrongMonthValue_throwException() {
        try {
            Command command = new DisplayCommand("calendar 22-2021");
        } catch (Exception e) {
            assertEquals("The month has to be a value between 01-12!", e.getMessage());
        }
    }

}