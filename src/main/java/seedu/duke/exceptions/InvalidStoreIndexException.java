package seedu.duke.exceptions;

import seedu.duke.constants.Messages;

public class InvalidStoreIndexException extends ClickException {
    public InvalidStoreIndexException(int storeIndex) {
        super(Messages.PRINT_INVALID_STORE + storeIndex);
    }
}
