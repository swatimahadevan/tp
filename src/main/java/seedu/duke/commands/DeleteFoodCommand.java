package seedu.duke.commands;

import seedu.duke.exceptions.ClickException;
import seedu.duke.exceptions.FoodIndexNotFoundException;
import seedu.duke.food.FoodRecord;
import seedu.duke.parser.Parser;
import seedu.duke.storage.Storage;
import seedu.duke.storage.StorageFood;
import seedu.duke.ui.Ui;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Deletes a food item from a list given  a  valid index.
 * @author ngnigel99
 */
public class DeleteFoodCommand extends Command {

    private String inputString; //represents index to delete

    public DeleteFoodCommand(String inputString) {
        super();
        this.inputString = inputString;
    }

    @Override
    public void execute(Ui ui, Storage storage) throws ClickException, IOException {
        ArrayList<Integer> indexesToDelete = Parser.stringToIntegerList(inputString);
        int indexToDelete = indexesToDelete.get(0);
        if (indexToDelete < 0
                || indexToDelete >= storage.whatIAteTodayList.getList().size()) {
            throw new FoodIndexNotFoundException();
        }
        FoodRecord toDelete = storage.whatIAteTodayList.getList().get(indexToDelete - 1);
        try {
            storage.whatIAteTodayList.getList().remove(toDelete);
        } catch (Exception e) {
            Ui.printErrorMessageGeneral();
        } finally {
            Ui.printDoneDeleteFood(toDelete, indexToDelete);
            StorageFood.saveList(storage.whatIAteTodayList);
        }
    }
}
