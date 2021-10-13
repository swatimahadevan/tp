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
        String[] todoArguments = commandArgs.split(" ");
        if (todoArguments.length == INDEX_ONE) {
            throw new IncorrectNumberOfArgumentsException("I need the task name and task date to add it!");
        } else if (todoArguments.length == 2 && todoArguments[INDEX_ONE].equals("n/")) {
            throw new IncorrectNumberOfArgumentsException("Task name not found after n/ !");
        } else if (todoArguments.length == 4 && todoArguments[3].equals("d/")) {
            throw new IncorrectNumberOfArgumentsException("Task date not found after d/ !");
        }
        boolean isNameArgumentPresent = false;
        boolean isDateArgumentPresent = false;
        for (String todoArgument : todoArguments) {
            if (todoArgument.equals("n/")) {
                isNameArgumentPresent = true;
            }
            if (todoArgument.equals("d/")) {
                isDateArgumentPresent = true;
            }
        }
        if (isNameArgumentPresent && isDateArgumentPresent) {
            return parseTodoArgumentsArray(input);
        } else if (isNameArgumentPresent) {
            throw new IncorrectNumberOfArgumentsException("Date argument not found!");
        } else if (isDateArgumentPresent) {
            throw new IncorrectNumberOfArgumentsException("Name argument not found!");
        }
        return null;
    }

    //modified from @author SvethaMahadevan
    /**
     * Parsing of todo arguments.
     *
     * @param input from user.
     * @return Returning arguments of todo command.
     * @throws IncorrectNumberOfArgumentsException to check if correct number of arguments.
     */
    public static ArrayList<String> parseTodoArgumentsArray(String input) throws IncorrectNumberOfArgumentsException {
        ArrayList<String> argumentsTodoCommand = new ArrayList<>();
        String todoDetails = input.trim().split("todo")[INDEX_ONE];
        String descriptionAndDate;
        try {
            descriptionAndDate = todoDetails.split("n/")[INDEX_ONE].trim();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IncorrectNumberOfArgumentsException("Task name not found!");
        }
        String description = descriptionAndDate.split("d/")[INDEX_ZERO].trim();
        if (description.equals("")) {
            throw new IncorrectNumberOfArgumentsException("Task name not found!");
        }
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
}
