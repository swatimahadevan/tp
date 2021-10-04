package seedu.duke.parser;

import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.IllegalDateTimeException;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    static Parser parser = new Parser();

    @Test
    void sampleTest() throws IllegalDateTimeException {
        assertEquals("Oct 01 2021 23:59", parser.formatDateTime("01-10-2021 2359"));
    }

}