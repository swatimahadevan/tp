package seedu.duke.commands.module;

import seedu.duke.exceptions.ClickException;

public class StorageModuleException extends ClickException {

    public StorageModuleException() {
        super("Something is wrong with the storage file. A new file has been created");
    }
}
