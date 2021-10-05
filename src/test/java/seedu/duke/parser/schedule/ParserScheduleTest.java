package seedu.duke.parser.schedule;

import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.IllegalDateTimeException;

import java.time.YearMonth;
import static org.junit.jupiter.api.Assertions.assertEquals;

//@author swatim
class ParserScheduleTest {

    static ParserSchedule parser = new ParserSchedule();

    @Test
    void sampleTest() {
        assertEquals(YearMonth.of(2021, 10), parser.parseCalendarCommand("calendar 10-2021"));
    }

}
