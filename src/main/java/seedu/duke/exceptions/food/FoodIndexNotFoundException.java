package seedu.duke.exceptions.food;

import seedu.duke.exceptions.ClickException;

//@@author ngnigel99
public class FoodIndexNotFoundException extends ClickException {
    public FoodIndexNotFoundException() {
       super("Cannot find index of food record to delete! Use 'food list' or 'food view' first"
                + " to find desired food record index");
    }
}
