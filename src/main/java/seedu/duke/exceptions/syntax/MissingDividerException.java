package seedu.duke.exceptions.syntax;

import seedu.duke.constants.Messages;
import seedu.duke.exceptions.ClickException;

public class MissingDividerException extends ClickException {
    public MissingDividerException(String Divider) {
        super(Messages.PRINT_MISSING_DIVIDER + Divider);
    }
}
