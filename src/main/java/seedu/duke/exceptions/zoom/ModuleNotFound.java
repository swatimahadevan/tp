package seedu.duke.exceptions.zoom;

import seedu.duke.ui.Ui;

public class ModuleNotFound extends Exception {
    public ModuleNotFound() {
        Ui.printMessage("Module Not Found");
    }
}
