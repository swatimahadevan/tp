package seedu.duke.commands;

import seedu.duke.exceptions.ClickException;
import seedu.duke.task.TaskList;
import seedu.duke.ui.Ui;
import seedu.duke.storage.Storage;

import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.Scanner;

//@@author nvbinh15

/**
 * An abstract representation of Command.
 */
public abstract class Command implements Comparator<Command> {


    public String helpMessage = "Sorry no help doc exists for this command!";
    public String syntax = "Sorry there is no defined syntax for this command";

    /**
     * Executes command.
     *
     * @param ui      The component of Duke that deals with the interaction with the user.
     * @param storage The component of Duke that deals with loading tasks from the file and saving tasks in the file.
     * @throws ClickException If there is an exception of type ClickException occurs.
     * @throws Exception      If there is an exception of type other than DukeException occurs.
     */

    public abstract void execute(Ui ui, Storage storage) throws ClickException, Exception;

    public void help() {
        Ui.printHelpMessage(helpMessage, syntax);
    }

    /**
     * Prints command name in a readable format for help.
     *
     * @author ngnigel99
     */
    public void printClassNameAndSyntax() {
        Class currentClass = getClass();
        String fullClassName = currentClass.getSimpleName();
        String[] r = fullClassName.split("(?=\\p{Upper})"); //format by camel case
        for (String s : r) {
            if (!s.equals("Command")) {
                System.out.print(s + " ");
            }
        }
        System.out.println(" : " + syntax);
    }

    /**
     * For comparing commands by name of the class file.
     * Note we sort lexicographically so A appears first etc.
     * @param command1 some command to compare.
     * @param command2 some command to compare.
     * @return index of whichever command has a lower ASCII value name.
     *
     * @author ngnigel99
     */
    @Override
    public int compare(Command command1, Command command2) {
        String className1 = command1.getClass().getSimpleName();
        String className2 = command2.getClass().getSimpleName();
        return className1.compareTo(className2);
    }
}