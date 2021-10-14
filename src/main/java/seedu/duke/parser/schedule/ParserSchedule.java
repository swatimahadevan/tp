package seedu.duke.parser.schedule;

import seedu.duke.exceptions.IncorrectNumberOfArgumentsException;
import seedu.duke.parser.Parser;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static seedu.duke.constants.Messages.TODO;
import static seedu.duke.constants.Messages.CALENDAR_COMMAND_SPLIT;
import static seedu.duke.constants.Messages.DELIMITER_DATE;
import static seedu.duke.constants.Messages.MONTH_UPPER_LIMIT;
import static seedu.duke.constants.Messages.INDEX_ZERO;
import static seedu.duke.constants.Messages.INDEX_ONE;

public class ParserSchedule {

    /**
     * Parsing of calendar command for JUnit.
     *
     * @param input from user.
     * @return year and month
     */
    public static YearMonth parseCalendarCommandForJunit(String input) {
        // takes substring excluding "calendar" from command
        String extractMonthYear = input.substring(CALENDAR_COMMAND_SPLIT);
        var arguments = extractMonthYear.split(DELIMITER_DATE);
        int month = Integer.parseInt(arguments[INDEX_ZERO]);
        assert month <= MONTH_UPPER_LIMIT;
        int year = Integer.parseInt(arguments[1]);
        YearMonth yearMonth = YearMonth.of(year, month);
        return yearMonth;
    }

    //modified from @author SvethaMahadevan
    /**
     * Parsing of todo command.
     *
     * @param input from user.
     * @return Checking for whether arguments are present.
     * @throws IncorrectNumberOfArgumentsException to check if correct number of arguments.
     */
    public static ArrayList<String> parseTodoCommand(String input) throws IncorrectNumberOfArgumentsException {
        final String[] commandTypeAndParams = Parser.splitCommandAndArgs(input);
        assert commandTypeAndParams.length == 2;
        final String commandArgs = commandTypeAndParams[1];
        boolean isNameArgumentPresent = false;
        boolean isDateArgumentPresent = false;
        String[] todoArguments = commandArgs.split(" ");
        for (int i = 0; i < todoArguments.length; i++) {
            throwTaskNameNotFound(i, todoArguments, isNameArgumentPresent);
            throwTaskDateNotFound(i, todoArguments, isDateArgumentPresent);
        }
        if (isNameArgumentPresent && isDateArgumentPresent) {
            return parseTodoArgumentsArray(input);
        }
        if (isNameArgumentPresent) {
            throw new IncorrectNumberOfArgumentsException("Date argument not found!");
        }
        if (isDateArgumentPresent) {
            throw new IncorrectNumberOfArgumentsException("Name argument not found!");
        }
        throw new IncorrectNumberOfArgumentsException("Name and date arguments not found!");
    }

    /**
     * Parsing of todo arguments.
     *
     * @param input from user.
     * @return Returning arguments of todo command.
     * @throws IncorrectNumberOfArgumentsException to check if correct number of arguments.
     */
    public static ArrayList<String> parseTodoArgumentsArray(String input) {
        ArrayList<String> argumentsTodoCommand = new ArrayList<>();
        String todoDetails = input.trim().substring(CALENDAR_COMMAND_SPLIT);
        String descriptionAndDate = todoDetails.split("n/")[INDEX_ONE].trim();
        String description = descriptionAndDate.split("d/")[INDEX_ZERO].trim();
        String date = descriptionAndDate.split("d/")[INDEX_ONE].trim();
        List<String> todoInformation = Arrays.asList(TODO, description, date);
        argumentsTodoCommand.addAll(todoInformation);
        return argumentsTodoCommand;
    }

    /**
     * Parsing of calendar command.
     *
     * @param input from user.
     * @return month and year arguments.
     */
    public static String[] parseCalendarCommand(String input) {
        // takes substring excluding "calendar" from command
        String extractMonthYear = input.substring(CALENDAR_COMMAND_SPLIT);
        String[] arguments = extractMonthYear.split(DELIMITER_DATE);
        return arguments;
    }

    public static void throwTaskNameNotFound(int i, String[] todoArguments, boolean isNameArgumentPresent) throws IncorrectNumberOfArgumentsException {
        if (todoArguments[i].equals("n/")) {
            isNameArgumentPresent = true;
            if (todoArguments.length == i + 1 || todoArguments[i + 1].equals("d/")) {
                throw new IncorrectNumberOfArgumentsException("Task name not found after n/ !");
            }
        }
    }

    public static void throwTaskDateNotFound(int i, String[] todoArguments, boolean isDateArgumentPresent) throws IncorrectNumberOfArgumentsException {
        if (todoArguments[i].equals("d/")) {
            isDateArgumentPresent = true;
            if (todoArguments.length == i + 1) {
                throw new IncorrectNumberOfArgumentsException("Task date not found after d/ !");
            }
        }
    }
}
