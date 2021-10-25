package seedu.duke.commands.module;

import seedu.duke.commands.Command;
import seedu.duke.exceptions.ClickException;
import seedu.duke.exceptions.module.IllegalCurrentCapException;
import seedu.duke.exceptions.module.IllegalTotalMcTakenException;
import seedu.duke.module.ModuleManager;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.io.IOException;
import java.util.Scanner;

public class CapInfoCommand extends Command {

    ModuleManager moduleManager = new ModuleManager();

    public CapInfoCommand() {
        helpMessage = "Get user's information to calculate expected CAP";
        syntax = "module info";
    }

    @Override
    public void execute(Ui ui, Storage storage) throws ClickException, IOException {
        ui.printLine();
        ui.printMessage("What is your current cumulative average point (CAP)?");
        Scanner scanner = new Scanner(System.in);
        double currentCap = Double.parseDouble(ui.getUserInput(scanner));
        if (currentCap < 0.0 || currentCap > 5.0) {
            throw new IllegalCurrentCapException();
        }
        ui.printMessage("How many modular credits contributing to CAP you have taken?");
        int totalMcTaken = Integer.parseInt(ui.getUserInput(scanner));
        if (totalMcTaken < 0) {
            throw new IllegalTotalMcTakenException();
        }
        ui.printMessage("Thank you for your information. "
                + "You can view your expected CAP by keying in cap expected");
        ui.printLine();
        moduleManager.setCapInfo(currentCap, totalMcTaken);
    }
}
