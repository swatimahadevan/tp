package seedu.duke.commands;

import seedu.duke.food.FoodRecord;
import seedu.duke.exceptions.IllegalFoodParameterException;
import seedu.duke.parser.Parser;
import seedu.duke.storage.Storage;
import seedu.duke.storage.StorageFood;
import seedu.duke.task.TaskList;
import seedu.duke.ui.Ui;

import java.io.IOException;
import java.util.Scanner;

/**
 * Command to add a food item to the existing  list.
 * prefix would be food add [FOOD_NAME] [CALORIE_COUNT(kcal)]
 *
 * @author ngnigel99
 */
public class AddFoodCommand extends Command {

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage, Scanner in) throws IllegalFoodParameterException, IOException {
        String userInput = in.nextLine();
        FoodRecord foodRecord  = Parser.parseFoodRecord(userInput);
        storage.whatIAteTodayList.addToList(foodRecord);
        StorageFood.saveList(storage.whatIAteTodayList);
    }
}
