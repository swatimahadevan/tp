package seedu.duke.commands.food;

import seedu.duke.commands.Command;
import seedu.duke.exceptions.ClickException;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

//@@author ngnigel99
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
        switch (userInput.trim()) {
        case "food view":
            Storage.reference.getTechnoEdge().printStalls();
        case "food view all":
            Storage.reference.getTechnoEdge().printAllItems();
        default:
            String[] userInputSplit = userInput.split(" ");
            int index = Integer.parseInt(userInputSplit[2]);
            Storage.reference.getTechnoEdge().printItems(index);
        }
    }
}
