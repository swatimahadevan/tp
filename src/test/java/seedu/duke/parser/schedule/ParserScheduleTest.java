package seedu.duke.parser.schedule;

import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.IncorrectNumberOfArgumentsException;

import java.time.YearMonth;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@author swatim
class ParserScheduleTest {

    static ParserSchedule parser = new ParserSchedule();

    @Test
    void formatYearMonth() {
        assertEquals(YearMonth.of(2021, 10), parser.parseCalendarCommandForJunit("calendar 10-2021"));
    }

    @Test
    void parseTodoCommand_noTaskName_returnNullArguments() throws IncorrectNumberOfArgumentsException {
        ArrayList<String> todoArguments = null;
        try {
            todoArguments = parser.parseTodoArgumentsArray("calendar todo n/ ");
        } catch (Exception e) {
            assertEquals(null, todoArguments);
        }

    }

}