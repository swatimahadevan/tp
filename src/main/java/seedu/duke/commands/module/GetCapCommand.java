package seedu.duke.commands.module;

import seedu.duke.commands.Command;
import seedu.duke.module.ModuleManager;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.io.IOException;

//@@author nvbinh15
public class GetCapCommand extends Command {
    public static final String MESSAGE_EXPECTED_CAP = "Your expected CAP is: ";
    public static final String CAP_FORMAT = "%,.2f";
    private static ModuleManager moduleManager = new ModuleManager();

    /**
     * Class constructor.
     */
    public GetCapCommand() {
        this.helpMessage = "Get the expected CAP";
        this.syntax = "module cap";
    }

    /**
     * Executes the GetCapCommand.
     *
     * @param ui      The component of Duke that deals with the interaction with the user.
     * @param storage The component of Duke that deals with loading tasks from the file and saving tasks in the file.
     * @throws IOException If there is an exception while reading data from file.
     */
    @Override
    public void execute(Ui ui, Storage storage) throws IOException {
        System.out.print(MESSAGE_EXPECTED_CAP);
        System.out.println(String.format(CAP_FORMAT, moduleManager.getExpectedCap()));
    }
}
