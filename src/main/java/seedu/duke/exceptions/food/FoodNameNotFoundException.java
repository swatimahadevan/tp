package seedu.duke.exceptions.food;

import seedu.duke.exceptions.ClickException;

public class FoodNameNotFoundException extends ClickException {
    public FoodNameNotFoundException() {
        super("Please enter a name divider: n/");
    }
}
