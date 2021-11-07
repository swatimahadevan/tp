package seedu.duke.parser.schedule;

import seedu.duke.exceptions.calendar.IncorrectNumberOfArgumentsException;
import seedu.duke.exceptions.calendar.InvalidDateException;
import seedu.duke.exceptions.syntax.ArgumentsNotFoundException;
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
        return YearMonth.of(year, month);
    }


    /**
     * Parsing of todo command.
     *
     * @param input from user.
     * @return Checking for whether arguments are present.
     * @throws IncorrectNumberOfArgumentsException to check if correct number of arguments.
     */
    public static ArrayList<String> parseTodoCommand(String input)
            throws IncorrectNumberOfArgumentsException, InvalidDateException {
        return parseTodoArgumentsArray(input);
    }

    /**
     * Parsing of todo arguments.
     *
     * @param input from user.
     * @return Returning arguments of todo command.
     * @throws IncorrectNumberOfArgumentsException to check if correct number of arguments.
     * @throws InvalidDateException if date given by user is invalid.
     */
    public static ArrayList<String> parseTodoArgumentsArray(String input)
            throws IncorrectNumberOfArgumentsException, InvalidDateException {
        String todoDetails = input.trim().substring(CALENDAR_COMMAND_SPLIT);

        String descriptionAndDate = todoDetails.substring(todoDetails.indexOf("n/")).trim();
        String description = descriptionAndDate.substring(descriptionAndDate.indexOf("n/")
                + 2, descriptionAndDate.indexOf("d/")).trim();
        String date = descriptionAndDate.substring(descriptionAndDate.indexOf("d/") + 2).trim();
        if (description.equals("")) {
            throw new IncorrectNumberOfArgumentsException("Task name not found after n/...");
        }
        if (date.equals("")) {
            throw new IncorrectNumberOfArgumentsException("Task date not found after d/...");
        } else if (date.length() != 10) {
            throw new InvalidDateException();
        }
        List<String> todoInformation = Arrays.asList(TODO, description, date);
        return new ArrayList<>(todoInformation);
    }

    /**
     * Parsing of calendar command.
     *
     * @param input from user.
     * @return month and year arguments.
     */
    public static String[] parseCalendarCommand(String input) {
        String extractMonthYear = input.substring(17).trim();
        return extractMonthYear.split(DELIMITER_DATE);
    }

    /**
     * Parsing of lecture command.
     *
     * @param input The input from the user.
     * @return the parsed lecture command arguments if the command is correct.
     * @throws IncorrectNumberOfArgumentsException if the user command is incorrect.
     * @throws InvalidDateException if date given by user is invalid.
     */
    public static ArrayList<String> parseLectureCommand(String input)
            throws IncorrectNumberOfArgumentsException, InvalidDateException {
        return parseLectureArgumentsArray(input);
    }

    /**
     * Parsing of lecture arguments.
     *
     * @param input Input from user.
     * @return the name of lecture, start date and end date.
     * @throws IncorrectNumberOfArgumentsException if the user command is incorrect.
     * @throws InvalidDateException if date given by user is invalid.
     */
    public static ArrayList<String> parseLectureArgumentsArray(String input)
            throws IncorrectNumberOfArgumentsException, InvalidDateException {
        String lectureDetails = input.trim().substring(17);

        String nameAndDate = lectureDetails.substring(lectureDetails.indexOf("m/")).trim();
        String name = nameAndDate.substring(nameAndDate.indexOf("m/") + 2, nameAndDate.indexOf("s/")).trim();
        String dayAndLimits = nameAndDate.substring(nameAndDate.indexOf("s/")).trim();
        String fromDate = dayAndLimits.substring(dayAndLimits.indexOf("s/") + 2, dayAndLimits.indexOf("e/")).trim();
        String toDate = dayAndLimits.substring(dayAndLimits.indexOf("e/") + 2).trim();
        if (name.equals("")) {
            throw new IncorrectNumberOfArgumentsException("Module name not found after m/...");
        }
        if (fromDate.equals("")) {
            throw new IncorrectNumberOfArgumentsException("Module name not found after m/...");
        } else if (fromDate.length() != 10) {
            throw new InvalidDateException();
        }
        if (toDate.equals("")) {
            throw new IncorrectNumberOfArgumentsException("Module end date not found after e/...");
        } else if (toDate.length() != 10) {
            throw new InvalidDateException();
        }
        List<String> lectureInformation = Arrays.asList(name, fromDate, toDate);
        return new ArrayList<>(lectureInformation);
    }

}
