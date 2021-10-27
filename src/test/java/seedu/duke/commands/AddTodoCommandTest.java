package seedu.duke.commands;

import org.junit.jupiter.api.Test;

import seedu.duke.commands.calendar.AddTodoCommand;
import seedu.duke.exceptions.calendar.InvalidDateException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddTodoCommandTest {

    @Test
    void addTodoCommand_checkDate_returnFalse() {
        Boolean isValidDate = AddTodoCommand.isValid("11-22-2021");
        assertEquals(false, isValidDate);
    }

    @Test
    void addTodoCommand_checkDate_throwInvalidDateException() throws InvalidDateException {
        String todoDateStringFormat = "22-22-2021";
        try {
            AddTodoCommand.checkIfDateValid(todoDateStringFormat);
        } catch (Exception e) {
            assertEquals("Invalid date given!", e.getMessage());
        }
    }

}