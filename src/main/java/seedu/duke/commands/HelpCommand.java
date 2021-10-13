package seedu.duke.commands;

import seedu.duke.parser.Parser;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class HelpCommand extends Command {
    /*
        Update the validCommands list for new commands
     */

    private ArrayList<String> validCommands = new ArrayList<>(Arrays.asList("help"));

    public HelpCommand(String helpMessage) {
        this.helpMessage = createHelpMessage(); //Overwrite the helpMessage variable in your class constructors
        this.syntax = "";
    }

    public String createHelpMessage() {
        String helpMessage = "List of valid commands:\n";
        for(int i = 0; i < validCommands.size(); i++) {
            helpMessage = helpMessage + String.valueOf(i+1) + ". " + validCommands.get(i) + "\n";
        }
        return helpMessage;
    }

    @Override
    public void execute(Ui ui, Storage storage)  {}

}
