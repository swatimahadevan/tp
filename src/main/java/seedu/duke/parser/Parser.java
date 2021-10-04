package seedu.duke.parser;

import seedu.duke.exceptions.IllegalDateTimeException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Parser {

    static final String INPUT_DATE_TIME_FORMAT = "dd-MM-yyyy HHmm";
    static final String OUTPUT_DATE_TIME_FORMAT = "MMM dd yyyy HH:mm";


    /**
     * Converts date and time in string format to a LocalDateTime object.
     *
     * @param string Date and time in string format.
     * @return A LocalDateTime object that represents the given date and time.
     * @throws IllegalDateTimeException If the input date time is invalid.
     */
    public static LocalDateTime stringToDateTime(String string) throws IllegalDateTimeException {
        try {
            return LocalDateTime.parse(string, DateTimeFormatter.ofPattern(INPUT_DATE_TIME_FORMAT));
        } catch (Exception e) {
            throw new IllegalDateTimeException();
        }
    }

    /**
     * Converts date and time in LocalDateTime format to a string
     *
     * @param dateTime A LocalDateTime object that represents the given date and time.
     * @return The string representation of the given LocalDateTime object.
     */
    public static String dateTimeToString(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern(OUTPUT_DATE_TIME_FORMAT));
    }

    /**
     * Formats the user's input date time.
     *
     * @param rawDateTime The raw date time from user's input.
     * @return The string representation of other form of the given date time.
     * @throws IllegalDateTimeException If the input date time is invalid.
     */
    public static String formatDateTime(String rawDateTime) throws IllegalDateTimeException {
        try {
            return dateTimeToString(stringToDateTime(rawDateTime));
        } catch (IllegalDateTimeException e) {
            throw new IllegalDateTimeException();
        }
    }
}

