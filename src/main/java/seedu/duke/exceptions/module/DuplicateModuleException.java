package seedu.duke.exceptions.module;

import seedu.duke.exceptions.ClickException;

public class DuplicateModuleException extends ClickException {

    public DuplicateModuleException() {
        super("The module already exists. Type module list to see the list of module.");
    }
}
