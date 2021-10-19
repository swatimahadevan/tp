package seedu.duke.commands.module;

import seedu.duke.commands.Command;
import seedu.duke.exceptions.ClickException;
import seedu.duke.exceptions.module.IllegalModuleException;
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

    public AddModuleCommand() {
        syntax = "module add c/ [MODULE_CODE] n/ [MODULE_NAME] e/ [EXPECTED_GRADE]";
    }

    /**
     * Class constructor.
     *
     * @param commandArgs The command arguments.
     */
    public AddModuleCommand(String commandArgs) {
        this.commandArgs = commandArgs;
        this.helpMessage = "Add a module";
        this.syntax = "module add c/ [MODULE_CODE] n/ [MODULE_NAME] e/ [EXPECTED_GRADE]";
    }

    /**
     * Execute the AddModuleCommand.
     *
     * @param ui The component of Duke that deals with the interaction with the user.
     * @param storage The component of Duke that deals with loading tasks from the file and saving tasks in the file.
     * @throws ClickException If there is an exception of type ClickException occurs.
     * @throws IOException If there is an error while saving data to file.
     */
    public void execute(Ui ui, Storage storage) throws ClickException, IOException {
        int indexOfCode = commandArgs.indexOf("c/");
        int indexOfName = commandArgs.indexOf("n/");
        int indexOfExpectedGrade = commandArgs.indexOf("e/");
        Module module = getModule(indexOfCode, indexOfName, indexOfExpectedGrade);
        ModuleList moduleList = storage.storageModule.readDataFromFile();
        moduleList.addModule(module);
        System.out.println("Added " + module);
        storage.storageModule.saveDataToFile(moduleList);
    }

    /**
     * Returns a new Module based on user's input.
     *
     * @param indexOfCode Index of Module code.
     * @param indexOfName Index of Module name.
     * @param indexOfExpectedGrade Index of Module expected grade.
     * @return A new Module based on user's input.
     * @throws IllegalModuleException If user's input is not in the correct format.
     */
    private Module getModule(int indexOfCode, int indexOfName, int indexOfExpectedGrade) throws IllegalModuleException {
        String code;
        String name;
        Grade expectedGrade;
        Module module;
        boolean isInvalidInput = (indexOfCode == -1) || (indexOfName != -1 && indexOfCode > indexOfName)
                || (indexOfName == -1 && indexOfExpectedGrade != -1)
                || (indexOfExpectedGrade != -1
                && (indexOfName > indexOfExpectedGrade || indexOfCode > indexOfExpectedGrade));
        if (isInvalidInput) {
            throw new IllegalModuleException();
        }
        if (indexOfName != -1 && indexOfExpectedGrade != -1) {
            code = commandArgs.substring(indexOfCode + 2, indexOfName).strip();
            name = commandArgs.substring(indexOfName + 2, indexOfExpectedGrade).strip();
            String rawExpectedGrade = commandArgs.substring(indexOfExpectedGrade + 2).strip();
            expectedGrade
            module = new Module(code, name, expectedGrade);
        } else if (indexOfName != -1) {
            code = commandArgs.substring(indexOfCode + 2, indexOfName).strip();
            name = commandArgs.substring(indexOfName + 2).strip();
            module = new Module(code, name);
        } else { // indexOfName == -1
            code = commandArgs.substring(indexOfCode + 2).strip();
            module = new Module(code);
        }
        return module;
    }
}
