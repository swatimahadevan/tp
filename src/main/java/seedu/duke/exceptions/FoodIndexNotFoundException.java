package seedu.duke.exceptions;

public class FoodIndexNotFoundException extends ClickException {
    public FoodIndexNotFoundException() {
        System.out.println("Cannot find index of food record to delete! Use 'food list' first"
                + " to find desired food record index");
    }
}
