package seedu.duke.parser.schedule;

import seedu.duke.exceptions.calendar.IncorrectNumberOfArgumentsException;
import seedu.duke.parser.Parser;

import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static seedu.duke.constants.Messages.TODO;
import static seedu.duke.constants.Messages.CALENDAR_COMMAND_SPLIT;
import static seedu.duke.constants.Messages.DELIMITER_DATE;
import static seedu.duke.constants.Messages.MONTH_UPPER_LIMIT;
import static seedu.duke.constants.Messages.INDEX_ZERO;
import static seedu.duke.constants.Messages.INDEX_ONE;
import static seedu.duke.constants.Messages.NAME_ABSENT;

public class ParserSchedule {

    /**
     * Parsing of calendar command for JUnit.
     *
     * @param input from user.
     * @return year and month.
     */
    public static YearMonth parseCalendarCommandForJunit(String input) {
        // takes substring excluding "calendar" from command
        String extractMonthYear = input.substring(17);
        var arguments = extractMonthYear.split(DELIMITER_DATE);
        int month = Integer.parseInt(arguments[INDEX_ZERO]);
        assert month <= MONTH_UPPER_LIMIT;
        int year = Integer.parseInt(arguments[1]);
        YearMonth yearMonth = YearMonth.of(year, month);
        return yearMonth;
    }

    /**
     * Handles the input when todo date is not given by user.
     *
     * @param input The input from the user.
     * @return The modified input that will hold the current date.
     */
    public static String parseTodoWhenDateNotGiven(String input) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String date = sdf.format(new Date());
        input = input + " " + date;
        return input;
    }

    private static String[] splitTodoCommand(String input) {
        final String[] commandTypeAndParams = Parser.splitCommandAndArgs(input);
        assert commandTypeAndParams.length == 2;
        final String commandArgs = commandTypeAndParams[1];
        return commandArgs.split(" ");
    }

    private static String[] splitLectureCommand(String input) {
        final String[] commandTypeAndParams = Parser.splitCommandAndArgs(input);
        assert commandTypeAndParams.length == 2;
        final String commandArgs = commandTypeAndParams[1];
        return commandArgs.split(" ");
    }

    private static void throwExceptionNoName(String[] todoArguments, int i) throws IncorrectNumberOfArgumentsException {
        if (todoArguments.length == i + 1 || todoArguments[i + 1].equals("d/")) {
            throw new IncorrectNumberOfArgumentsException(NAME_ABSENT);
        }
    }

    private static void throwExceptionNoModuleName(String[] lectureArguments,
        int i) throws IncorrectNumberOfArgumentsException {
        if (lectureArguments.length == i + 1 || lectureArguments[i + 1].equals("s/")) {
            throw new IncorrectNumberOfArgumentsException("Module name not found after m/...");
        }
    }

    private static void throwExceptionNoStartDate(String[] lectureArguments,
        int i) throws IncorrectNumberOfArgumentsException {
        if (lectureArguments.length == i + 1 || lectureArguments[i + 1].equals("e/")) {
            throw new IncorrectNumberOfArgumentsException("Module start date not found after s/...");
        }
    }

    private static void throwExceptionNoEndDate(String[] lectureArguments,
        int i) throws IncorrectNumberOfArgumentsException {
        if (lectureArguments.length == i + 1) {
            throw new IncorrectNumberOfArgumentsException("Module end date not found after e/...");
        }
    }

    private static String handleNoDate(String[] todoArguments, int i, String input) {
        if (todoArguments.length == i + 1) {
            System.out.println("You have not provided a date so "
                    + "I will add the task to today's date..."
                    + "please specify one in DD-MM-YYYY next time!");
            input = parseTodoWhenDateNotGiven(input);
        }
        return input;
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
        String[] todoArguments = splitTodoCommand(input);
        boolean isNameArgumentPresent = false;
        boolean isDateArgumentPresent = false;
        for (int i = 0; i < todoArguments.length; i++) {
            switch (todoArguments[i]) {
            case "n/":
                isNameArgumentPresent = true;
                throwExceptionNoName(todoArguments, i);
                break;
            case "d/":
                isDateArgumentPresent = true;
                input = handleNoDate(todoArguments, i, input);
                break;
            default:
            }
        }
        if (isNameArgumentPresent && isDateArgumentPresent) {
            return parseTodoArgumentsArray(input);
        }
        if (isNameArgumentPresent) {
            throw new IncorrectNumberOfArgumentsException("Date argument 'd/' not found!");
        }
        if (isDateArgumentPresent) {
            throw new IncorrectNumberOfArgumentsException("Name argument 'n/'not found!");
        } else {
            throw new IncorrectNumberOfArgumentsException("Name and date arguments not found!");
        }
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
        String extractMonthYear = input.substring(17).trim();
        String[] arguments = extractMonthYear.split(DELIMITER_DATE);
        return arguments;
    }

    /**
     * Parsing of lecture command.
     *
     * @param input The input from the user.
     * @return the parsed lecture command arguments if the command is correct.
     * @throws IncorrectNumberOfArgumentsException if the user command is incorrect.
     */
    public static ArrayList<String> parseLectureCommand(String input) throws IncorrectNumberOfArgumentsException {
        String[] lectureArguments = splitLectureCommand(input);
        boolean isModulePresent = false;
        boolean isDateStartPresent = false;
        boolean isDateEndPresent = false;
        for (int i = 0; i < lectureArguments.length; i++) {
            switch (lectureArguments[i]) {
            case "m/":
                isModulePresent = true;
                throwExceptionNoModuleName(lectureArguments, i);
                break;
            case "s/":
                isDateStartPresent = true;
                throwExceptionNoStartDate(lectureArguments, i);
                break;
            case "e/":
                isDateEndPresent = true;
                throwExceptionNoEndDate(lectureArguments, i);
                break;
            default:
            }
        }
        if (isModulePresent  && isDateEndPresent && isDateStartPresent) {
            return parseLectureArgumentsArray(input);
        } else {
            throw new IncorrectNumberOfArgumentsException("Incorrect number of arguments!");
        }
    }

    /**
     * Parsing of lecture arguments.
     *
     * @param input Input from user.
     * @return the name of lecture, start date and end date.
     */
    public static ArrayList<String> parseLectureArgumentsArray(String input) {
        ArrayList<String> argumentsLectureCommand = new ArrayList<>();
        String lectureDetails = input.trim().substring(17);

        String nameAndDate = lectureDetails.split("m/")[INDEX_ONE].trim();
        String name = nameAndDate.split("s/")[INDEX_ZERO].trim();
        String dayAndLimits = nameAndDate.split("s/")[INDEX_ONE].trim();
        String fromDate = dayAndLimits.split("e/")[INDEX_ZERO].trim();
        String toDate = dayAndLimits.split("e/")[INDEX_ONE].trim();

        List<String> lectureInformation = Arrays.asList(name, fromDate, toDate);
        argumentsLectureCommand.addAll(lectureInformation);
        return argumentsLectureCommand;
    }

}
