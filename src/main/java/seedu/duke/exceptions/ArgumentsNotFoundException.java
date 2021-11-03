package seedu.duke.exceptions;

public class ArgumentsNotFoundException extends ClickException {
    public ArgumentsNotFoundException() {
        super("Missing arguments!");
    }
}
