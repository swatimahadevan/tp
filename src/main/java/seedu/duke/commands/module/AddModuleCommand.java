package seedu.duke.commands.module;

import seedu.duke.commands.Command;
import seedu.duke.exceptions.ClickException;
import seedu.duke.exceptions.module.IllegalModuleException;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.module.ModuleManager;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.io.IOException;

//@@author nvbinh15

/**
 * A representation of the command for adding a Module.
 */
public class AddModuleCommand extends Command {
    ModuleManager moduleManager = new ModuleManager();
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
        int indexOfMc = commandArgs.indexOf("mc/");
        int indexOfExpectedGrade = commandArgs.indexOf("e/");
        Module module = getModule(indexOfCode, indexOfName, indexOfMc, indexOfExpectedGrade);
        moduleManager.addNewModule(module);
        System.out.println("I have added this module:");
        System.out.println(module);
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
    private Module getModule(int indexOfCode, int indexOfName, int indexOfMc, int indexOfExpectedGrade)
            throws IllegalModuleException {
        String code;
        String name;
        int modularCredits;
        String expectedGrade;
        Module module;

        boolean isValidIndexes = isValidIndexes(indexOfCode, indexOfName, indexOfMc, indexOfExpectedGrade);

        if (!isValidIndexes) {
            throw new IllegalModuleException();
        }

        if (indexOfName == -1 && indexOfMc == -1 && indexOfExpectedGrade == -1) {
            code = commandArgs.substring(indexOfCode + 2).strip();
            module = new Module(code);
        } else if (indexOfMc == -1 && indexOfExpectedGrade == -1) {
            code = commandArgs.substring(indexOfCode + 2, indexOfName).strip();
            name = commandArgs.substring(indexOfName + 2).strip();
            module = new Module(code, name);
        } else if (indexOfExpectedGrade == -1) {
            code = commandArgs.substring(indexOfCode + 2, indexOfName).strip();
            name = commandArgs.substring(indexOfName + 2, indexOfMc).strip();
            modularCredits = Integer.parseInt(commandArgs.substring(indexOfMc + 3).strip());
            module = new Module(code, name, modularCredits);
        } else {
            code = commandArgs.substring(indexOfCode + 2, indexOfName).strip();
            name = commandArgs.substring(indexOfName + 2, indexOfMc).strip();
            modularCredits = Integer.parseInt(commandArgs.substring(indexOfMc + 3, indexOfExpectedGrade).strip());
            expectedGrade = commandArgs.substring(indexOfExpectedGrade + 2).strip();
            module = new Module(code, name, modularCredits, expectedGrade);
        }

        return module;
    }

    private boolean isValidIndexes(int indexOfCode, int indexOfName, int indexOfMc, int indexOfExpectedGrade) {
        boolean hasCode = indexOfCode != -1;
        boolean isValidCodeOnly = (indexOfName == -1) && (indexOfMc == -1) && (indexOfExpectedGrade == -1);
        boolean isValidCodeAndName = (indexOfName != -1) && (indexOfMc == -1) && (indexOfExpectedGrade == -1)
                && (indexOfName > indexOfCode);
        boolean isValidCodeNameAndMc = (indexOfName != -1) && (indexOfMc != -1) && (indexOfExpectedGrade == -1)
                && (indexOfName > indexOfCode) && (indexOfMc > indexOfName);
        boolean isValidCodeNameMcAndGrade = (indexOfName != -1) && (indexOfMc != -1) && (indexOfExpectedGrade != -1)
                && (indexOfName > indexOfCode) && (indexOfMc > indexOfName) && (indexOfExpectedGrade > indexOfMc);

        boolean isValidIndexes = hasCode && (isValidCodeOnly || isValidCodeAndName
                || isValidCodeNameAndMc || isValidCodeNameMcAndGrade);
        return isValidIndexes;
    }
}
