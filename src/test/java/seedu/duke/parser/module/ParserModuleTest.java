package seedu.duke.parser.module;

import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.StorageException;
import seedu.duke.module.Module;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ParserModuleTest {

    @Test
    void formatModuleToStore_sampleModule_respectiveStringRepOfSampleModule() {
        Module sampleModule = new Module("CS2113T", "Software Engineering", 4, "A");
        String data = ParserModule.formatModuleToStore(sampleModule);
        String expectedData = "CS2113T|Software Engineering|A|4\n";
        assertEquals(data, expectedData);
    }

    @Test
    void retrieveStoredModule_validData_expectedModule() throws StorageException {
        String data = "CS2113T|Software Engineering|A|4";
        Module retrievedModule = ParserModule.retrieveStoredModule(data);
        Module expectedModule = new Module("CS2113T", "Software Engineering", 4, "A");
        assertEquals(retrievedModule.toString(), expectedModule.toString());
    }

    @Test
    void retrieveStoredModule_invalidData_StorageExceptionThrown() {
        String invalidData = "CS2113T|Software Engineering|A";
        assertThrows(StorageException.class, () -> ParserModule.retrieveStoredModule(invalidData));
    }

    @Test
    void formatCapInfoToStore_sampleCapInfo_respectiveFormattedData() {
        double cap = 4.5;
        int totalMc = 50;
        String data = ParserModule.formatCapInfoToStore(cap, totalMc);
        String expectedData = "4.5|50\n";
        assertEquals(data, expectedData);
    }

    @Test
    void retrieveStoredCapInfo_invalidData_StorageExceptionThrown() {
        String invalidData = "4.5|";
        assertThrows(StorageException.class, () -> ParserModule.retrieveStoredCapInfo(invalidData));
    }

}