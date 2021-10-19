package seedu.duke.commands.food;

import seedu.duke.commands.Command;
import seedu.duke.exceptions.food.FoodIndexNotFoundException;
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
    private final int indexNotFoundConstant =  -1; 
    private String inputString; //represents index to delete

    public DeleteFoodCommand() {
        syntax = "food delete [INDEX]";

    }

    public DeleteFoodCommand(String inputString) {
        super();
        this.inputString = inputString.trim();
        helpMessage = "Deletes aa food item from a list given a valid index";
        syntax = "food delete [INDEX]";
    }

    /**
     * Executes delete food command.
     * @param ui      The component of Duke that deals with the interaction with the user.
     * @param storage The component of Duke that deals with loading tasks from the file and saving tasks in the file.
     * @throws FoodIndexNotFoundException If index is not in list.
     * @throws IOException If there is an error saving updated list to save file.
     */
    @Override
    public void execute(Ui ui, Storage storage) throws FoodIndexNotFoundException, IOException {
        int indexToDelete = getIndexToDelete();
        checkIndexAndThrowException(storage, indexToDelete);
        FoodRecord toDelete = storage.whatIAteTodayList.getList().get(indexToDelete - 1);
        deleteFoodRecordAndSave(storage, indexToDelete, toDelete);
    }

    /**
     * Given an input string, parses it to an integer.
     * Note: capability to handle multiple strings,
     *       perhaps in later versions.
     * @return indexToDelete integer parsed.
     */
    private int getIndexToDelete() {
        try {
            ArrayList<Integer> indexesToDelete = Parser.parseStringToIntegerList(inputString);
            int indexToDelete = indexesToDelete.get(0);
            return indexToDelete;
        } catch (NumberFormatException e) {
            Ui.printOnlyIntegers();
        }
        return indexNotFoundConstant;  //if integer is not given
    }

    /**
     * Assumes index in list at this point, then delete item.
     * @param storage  The component of Duke that deals with loading tasks from the file and saving tasks in the file.
     * @param indexToDelete Index of food item to be deleted.
     * @param toDelete Food record to delete.
     * @throws IOException If there is an error saving updated list to save file.
     *
     * @author ngnigel99
     */
    private void deleteFoodRecordAndSave(Storage storage, int indexToDelete, FoodRecord toDelete) throws IOException {
        try {
            storage.whatIAteTodayList.getList().remove(toDelete);
        } catch (Exception e) {
            Ui.printErrorMessageGeneral();
        } finally {
            Ui.printDoneDeleteFood(toDelete, indexToDelete);
            StorageFood.saveList(storage.whatIAteTodayList);
        }
    }

    /**
     * Verifies index used exists in given list.
     * In particular, for food items.
     * @param storage Storage object that contains list.
     * @param indexToDelete Index of food item in list to delete.
     * @throws FoodIndexNotFoundException If index is not in list range.
     *
     * @author ngnigel99
     */
    private void checkIndexAndThrowException(Storage storage, int indexToDelete) throws FoodIndexNotFoundException {
        if (indexToDelete < 0
                || indexToDelete >= storage.whatIAteTodayList.getList().size()) {
            throw new FoodIndexNotFoundException();
        }
    }
}
