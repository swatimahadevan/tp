package seedu.duke.commands.food;

import seedu.duke.commands.Command;
import seedu.duke.exceptions.ArgumentsNotFoundException;
import seedu.duke.food.FoodRecord;
import seedu.duke.exceptions.IllegalFoodParameterException;
import seedu.duke.parser.Parser;
import seedu.duke.storage.Storage;
import seedu.duke.storage.StorageFood;
import seedu.duke.ui.Ui;

import java.io.IOException;

/**
 * Command to add a food item to the existing  list.
 * prefix would be food add [FOOD_NAME] [CALORIE_COUNT(kcal)]
 *
 * @author ngnigel99
 */
public class AddFoodCommand extends Command {
    private String inputString; //name + calorie

    public AddFoodCommand(String inputString) {
        super();
        this.inputString = inputString;
        this.helpMessage = "Adds a food item to a list";
        this.syntax = "food add n/ [FOOD_NAME] c/ [CALORIE]";
    }

    /**
     * Executes add food command.
     * @param ui      The component of Duke that deals with the interaction with the user.
     * @param storage The component of Duke that deals with loading tasks from the file and saving tasks in the file.
     * @throws IllegalFoodParameterException If syntax is not followed.
     * @throws IOException If there is an error while reading/ saving data to file.
     *
     * @author ngnigel99
     */
    @Override
    public void execute(Ui ui, Storage storage) throws IllegalFoodParameterException, IOException {
        FoodRecord foodRecord  = null;
        try {
            foodRecord = Parser.parseFoodRecord(inputString);
        } catch (ArgumentsNotFoundException e) {
            e.printStackTrace();    //dividers are not aligned with syntax
        }
        storage.whatIAteTodayList.addToList(foodRecord, false);
        StorageFood.saveList(storage.whatIAteTodayList);
    }


}
