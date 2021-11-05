package seedu.duke.exceptions.module;

import seedu.duke.exceptions.ClickException;

public class DuplicateModuleParamException extends ClickException {

    public DuplicateModuleParamException() {
        super("Duplicate parameters.");
    }
}
