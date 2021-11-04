package seedu.duke.exceptions.syntax;

import seedu.duke.exceptions.ClickException;

public class ArgumentsNotFoundException extends ClickException {
    public ArgumentsNotFoundException() {
        super("Missing arguments!");
    }
}
