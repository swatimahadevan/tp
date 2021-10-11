package seedu.duke.commands;

import seedu.duke.parser.Parser;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.io.IOException;

public class HelpCommand extends Command {
    private String helpMessage = "";

    public HelpCommand(String helpMessage) {
        this.helpMessage = helpMessage;
    }

    @Override
    public void execute(Ui ui, Storage storage)  {
        ui.printHelpMessage(helpMessage);
    }
}
