package seedu.duke.exceptions.food;

import seedu.duke.Click;
import seedu.duke.exceptions.ClickException;

public class FoodCaloriesNotFoundException extends ClickException {
    public FoodCaloriesNotFoundException() {
        super("Please enter the calories divider c/");
    }
}
