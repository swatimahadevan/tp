package seedu.duke.commands.food;

import seedu.duke.commands.Command;
import seedu.duke.constants.CommandConstants;
import seedu.duke.exceptions.ClickException;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

//@@author ngnigel99
public class FindFoodWithDateCommand extends Command {
    LocalDate dateInput;

    public FindFoodWithDateCommand() {
        this.syntax = "food find [DD-MM-YYYY]";
    }

    public FindFoodWithDateCommand(String dateString) throws DateTimeParseException {
        DateTimeFormatter localDateFormatter = getFormatter();
        this.dateInput = LocalDate.parse(dateString, localDateFormatter);
    }

    /**
     * Gets a formatter of the syntax dd-MM-yyyy.
     * @return localDateFormatter the formatter needed to parse dates.
     */
    private DateTimeFormatter getFormatter() {
        DateTimeFormatter localDateFormatter = DateTimeFormatter.ofPattern(CommandConstants.DATE_CONSTANT);
        return localDateFormatter;
    }

    @Override
    public void execute(Ui ui, Storage storage) {
        storage.whatIAteTodayList.printFoodWithFoundDate(dateInput);
    }
}
