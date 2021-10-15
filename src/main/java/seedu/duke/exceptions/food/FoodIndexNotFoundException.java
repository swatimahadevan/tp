package seedu.duke.exceptions.food;

import seedu.duke.exceptions.ClickException;

public class FoodIndexNotFoundException extends ClickException {
    public FoodIndexNotFoundException() {
        System.out.println("Cannot find index of food record to delete! Use 'food list' first"
                + " to find desired food record index");
    }
}
