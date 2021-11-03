package seedu.duke.exceptions;

import seedu.duke.Click;
import seedu.duke.constants.Messages;

public class HelpException extends ClickException {
    public HelpException() {
        super(Messages.PRINT_ONLY_HELP);
    }
}
