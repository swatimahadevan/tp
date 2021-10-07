package seedu.duke.constants;

public class Messages {

    public static final String LOGO = "\t" + " ____        _\n"
            + "\t" + "|  _ \\ _   _| | _____\n"
            + "\t" + "| | | | | | | |/ / _ \\\n"
            + "\t" + "| |_| | |_| |   <  __/\n"
            + "\t" + "|____/ \\__,_|_|\\_\\___|\n\n";

    public static final String OPEN_SQUARE_BRACKET = "[";
    public static final String CLOSE_SQUARE_BRACKET = "]";
    public static final String VERTICAL_BAR = " | ";
    public static final String VERTICAL_BAR_REGEX = " \\| ";
    public static final String EMPTY_STRING = "";

    public static final String LINE_PREFIX = "\t";
    public static final String LINE_SEPARATOR = System.lineSeparator();
    public static final String NEW_LINE = LINE_SEPARATOR + LINE_PREFIX;
    public static final String HORIZONTAL_LINE = LINE_PREFIX + "__________________________________________________";

    public static final String MESSAGE_GREETING = LINE_PREFIX + "Hello! I'm Duke" + NEW_LINE + "What can I do for you?";
    public static final String MESSAGE_GOODBYE = LINE_PREFIX + "Bye. Hope to see you again soon!";

    // Food partition
    public static final String PRINT_DONE_CLEAR_LIST = "Cleared food record list for today!";
    public static final String PRINT_ADD_FOOD_SYNTAX = "Please enter the name of the food [TEXT]"
                                                        + "followed by the calorie count [INT]";
    public static final String NON_NULL_INPUT = "Please do not leave fields empty!";
    public static final String RECORD_ATTRIBUTE_DIVIDER = " : ";
    //end of Food

    //@author swatim
    public static String CALENDAR_HEADER_LINE = "________________________________________________________";
    public static final String INVALID_CALENDAR_INPUT = " Invalid Input! Please "
            + "type command in format:   | calendar MM-YYYY |";
    public static final String INVALID_YEARMONTH = " Invalid Input! Please give "
            + "a month between 1-12 and year between 2021-2025";
    public static final int YEAR_UPPER_LIMIT = 2025;
    public static final int YEAR_LOWER_LIMIT = 2021;
    public static final int MONTH_UPPER_LIMIT = 12;
    public static final int MONTH_LOWER_LIMIT = 1;
    public static final int NUMBER_OF_DAYS_IN_WEEK = 7;
    public static final String LEAVE_EMPTY_IN_DISPLAY = "  ";
    public static final String CALENDAR_COMMAND_SPLIT_DELIMITER = "-";
    public static final int CALENDAR_COMMAND_SPLIT_INDEX = 9;
    public static final String[] DAYS_IN_MONTH = {"01", "02", "03", "04", "05",
        "06", "07", "08", "09", "10", "11", "12", "13",
        "14", "15", "16", "17", "18", "19", "20", "21",
        "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};

    //Storage
    public static final String STORAGE_FILEPATH = "data/tasks.txt";
}
