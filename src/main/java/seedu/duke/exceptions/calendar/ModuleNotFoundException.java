package seedu.duke.exceptions.calendar;

import seedu.duke.ui.Ui;

public class ModuleNotFoundException extends Exception {
    public ModuleNotFoundException() {
        Ui.printMessage("You have to add a module before you can add a lecture to it !");
    }
}
