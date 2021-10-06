package seedu.duke.parser.journal;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author SvethaMahadevan
 */
class ParserJournalTest {

    static ParserJournal parser = new ParserJournal();

    //@author SvethaMahadevan
    @Test
    void sampleTest() {
        assertEquals("testnotename", parser.parseAddNoteCommand("add n/ testnotename"));
    }

}