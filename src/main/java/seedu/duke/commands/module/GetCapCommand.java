package seedu.duke.commands.module;

import seedu.duke.commands.Command;
import seedu.duke.module.ModuleManager;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.io.IOException;

//@@author nvbinh15
public class GetCapCommand extends Command {
    public static final String MESSAGE_EXPECTED_CAP = "Your expected CAP is: ";
    private static ModuleManager moduleManager = new ModuleManager();

    public GetCapCommand() {
        this.helpMessage = "Get the expected CAP";
        this.syntax = "module cap";
    }

    @Override
    public void execute(Ui ui, Storage storage) throws IOException {
        System.out.print(MESSAGE_EXPECTED_CAP);
        System.out.println(String.format("%,.2f", moduleManager.getExpectedCap()));
    }
}
