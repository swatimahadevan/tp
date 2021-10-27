package seedu.duke.commands.food;
//@@author ngnigel99

import seedu.duke.commands.Command;
import seedu.duke.exceptions.ClickException;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

/**
 * Command to display a reference list to the user.
 * In particular, this would involve listing the stall names
 * as well as allowing the user to view the specific items
 * sold by a store.
 */
public class ViewReferenceFoodCommand extends Command {
    private String userInput;

    public ViewReferenceFoodCommand() {
        this.syntax = "food view, food view [STORE_INDEX], food view all \n";
    }

    public ViewReferenceFoodCommand(String userInput) {
        this.userInput =  userInput;
    }

    @Override
    public void execute(Ui ui, Storage storage) throws ClickException, NumberFormatException {
        if (userInput.trim().equals("food view")) {
            Storage.reference.getTechnoEdge().printStalls();
        } else if (userInput.trim().equals("food view all")) {
            Storage.reference.getTechnoEdge().printAllItems();
        } else {
            String[] userInputSplit = userInput.split(" ");
            int index = Integer.parseInt(userInputSplit[2]);
            Storage.reference.getTechnoEdge().printItems(index);
        }
    }
}
