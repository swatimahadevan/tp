package seedu.duke.commands;

import seedu.duke.exceptions.ClickException;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

public class ListModuleCommand extends Command {

    @Override
    public void execute(Ui ui, Storage storage) throws ClickException, Exception {
        ModuleList moduleList = storage.storageModule.readDataFromFile();
        if (moduleList.getNumberOfModules() <= 0) {
            System.out.println("No modules");
            return;
        }
        for (Module m : moduleList.getModules()) {
            System.out.println(m);
        }
    }
}
