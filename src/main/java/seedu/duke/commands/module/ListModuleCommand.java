package seedu.duke.commands.module;

import seedu.duke.commands.Command;
import seedu.duke.exceptions.ClickException;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

//@@author nvbinh15

/**
 * A representation of the command for listing Modules.
 */
public class ListModuleCommand extends Command {

    public static final String MESSAGE_NO_MODULE = "You don't have any modules";
    public static final String MESSAGE_LISTING_MODULES = "Here are the modules in your list:";

    /**
     * Class constructor.
     */
    public ListModuleCommand() {
        helpMessage = "List all added modules";
        syntax = "module list";
    }

    /**
     * Executes the ListModuleCommand.
     *
     * @param ui      The component of Duke that deals with the interaction with the user.
     * @param storage The component of Duke that deals with loading tasks from the file and saving tasks in the file.
     * @throws ClickException If there is an exception of type ClickException occurs.
     * @throws Exception If there is an exception of type other than ClickException occurs.
     */
    @Override
    public void execute(Ui ui, Storage storage) throws ClickException, Exception {
        ModuleList moduleList = storage.storageModule.readDataFromFile();
        if (moduleList.getNumberOfModules() <= 0) {
            System.out.println(MESSAGE_NO_MODULE);
            return;
        }
        System.out.println(MESSAGE_LISTING_MODULES);
        int i = 1;
        for (Module m : moduleList.getModules()) {
            System.out.println(i + ". " + m);
            i++;
        }
    }
}
