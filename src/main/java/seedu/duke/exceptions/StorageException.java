package seedu.duke.exceptions;

//@@author nvbinh15

/**
 * A class that represents exception thrown when there is an error with the storage files.
 */
public class StorageException extends ClickException {

    public StorageException() {
        super("There is something wrong with the Storage file");
    }
}
