package seedu.duke.commands;

import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.io.IOException;

//@@author nvbinh15

/**
 * A representation of the command for adding a Module.
 */
public class AddModuleCommand extends Command {

    String commandArgs;

    /**
     * Class constructor.
     *
     * @param commandArgs The command arguments.
     */
    public AddModuleCommand(String commandArgs) {
        this.commandArgs = commandArgs;
    }

    /**
     * Execute the AddModuleCommand.
     *
     * @param ui The component of Duke that deals with the interaction with the user.
     * @param storage The component of Duke that deals with loading tasks from the file and saving tasks in the file.
     * @throws IOException If there is an error while saving data to file.
     */
    public void execute(Ui ui, Storage storage) throws IOException {
        int indexOfCode = commandArgs.indexOf("c/");
        int indexOfName = commandArgs.indexOf("n/");
        int indexOfExpectedGrade = commandArgs.indexOf("e/");
        String code;
        String name;
        String expectedGrade;
        Module module;
        if (indexOfName != -1 && indexOfExpectedGrade != -1) {
            code = commandArgs.substring(indexOfCode + 2, indexOfName).strip();
            name = commandArgs.substring(indexOfName + 2, indexOfExpectedGrade).strip();
            expectedGrade = commandArgs.substring(indexOfExpectedGrade + 2).strip();
            module = new Module(code, name, expectedGrade);
        } else if (indexOfName != -1) {
            code = commandArgs.substring(indexOfCode + 2, indexOfName).strip();
            name = commandArgs.substring(indexOfName + 2).strip();
            module = new Module(code, name);
        } else { // indexOfName == -1
            code = commandArgs.substring(indexOfCode + 2).strip();
            module = new Module(code);
        }

        ModuleList moduleList = storage.storageModule.readDataFromFile();
        moduleList.addModule(module);
        System.out.println("Added " + module);
        storage.storageModule.saveDataToFile(moduleList);
    }
}
