package seedu.duke.commands.food;

import seedu.duke.commands.Command;
import seedu.duke.exceptions.ClickException;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FindFoodWithDateCommand extends Command {
    LocalDate dateInput;

    public FindFoodWithDateCommand() {
        this.syntax = "food find [DD-MM-YYYY]";
    }

    public FindFoodWithDateCommand(String dateString) throws DateTimeParseException {
        DateTimeFormatter localDateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.dateInput = LocalDate.parse(dateString, localDateFormatter);
    }

    @Override
    public void execute(Ui ui, Storage storage) {
        storage.whatIAteTodayList.printFoodWithFoundDate(dateInput);
    }
}
