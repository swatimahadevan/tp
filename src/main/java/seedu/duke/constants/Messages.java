package seedu.duke.constants;

public class Messages {

    public static final String LOGO = "\t" + " _____ _  _     _\n"
            + "\t" + "/  __ \\ |(_)   | |\n"
            + "\t" + "| /  \\/ |_  ___| | __\n"
            + "\t" + "| \\__/\\ | | (__|   <\n"
            + "\t" + "\\_____/_|_|\\___|_|\\_\\\n\n";

    public static final String EMPTY_STRING = "";
    public static final String LINE_PREFIX = "\t";
    public static final String LINE_SEPARATOR = System.lineSeparator();
    public static final String NEW_LINE = LINE_SEPARATOR + LINE_PREFIX;
    public static final String HORIZONTAL_LINE = LINE_PREFIX + "__________________________________________________";

    public static final String MESSAGE_GREETING = LINE_PREFIX + "Hello! I'm Click"
            + NEW_LINE + "What can I do for you?";
    public static final String MESSAGE_GOODBYE = "Bye. Hope to see you again soon!";

    // Food partition
    public static final String PRINT_DONE_CLEAR_LIST = "Cleared food record list for today!";
    public static final String PRINT_ADD_FOOD_SYNTAX = "Please enter the name of the food n/ [TEXT] "
                                                        + "followed by the calorie count c/ [INT]"
                                                        + "optional d/ {DD-MM-YYYY}";
    public static final String NON_NULL_INPUT = "Please do not leave fields empty!";
    public static final String RECORD_ATTRIBUTE_DIVIDER = " : ";
    public static final String LIST_PROPER_FEATURE  =  "Please list a proper feature tagged with ";
    public static final String PRINT_NOT_AN_INT = "Please only enter Integers";
    public static final String PRINT_ERROR_MESSAGE_GENERAL = "Oops, error encountered.";
    public static final String PRINT_DONE_DELETE_INDEX = "Deleted food record ";
    //end of Food

    //@author swatim
    //SCHEDULE BEGIN
    public static String CALENDAR_HEADER_LINE = "________________________________________________________";
    public static final String INVALID_CALENDAR_INPUT = " Invalid Input for Calendar Command! ";
    public static final int MONTH_UPPER_LIMIT = 12;
    public static final int MONTH_LOWER_LIMIT = 1;
    public static final String TASK_FORMATTER = "  |";
    public static final String CALENDER_DATE_FORMATTER = "               |";
    public static final String SEPARATOR_DISPLAY = "|";
    public static final String EMPTY_SPACE = "";
    public static final int NUMBER_OF_DAYS_IN_WEEK = 7;
    public static final String LEAVE_EMPTY_IN_DISPLAY = "  ";
    public static final String[] DAYS_IN_MONTH = {"01", "02", "03", "04", "05",
        "06", "07", "08", "09", "10", "11", "12", "13",
        "14", "15", "16", "17", "18", "19", "20", "21",
        "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    public static final String TODO = "todo";
    public static final int INDEX_TODO_DESCRIPTION = 1;
    public static final int INDEX_TODO_DATE = 2;
    public static final int TOTAL_SIZE = 32;
    public static final String ADDED_TASK = "Task has been added successfully!";
    public static final String LIST_TASKS_HEADER = "Here's your task list:";
    public static final String DISPLAY_LINE = "-------------------------"
            + "----------------------------------------"
            + "---------------------------------------"
            + "-----------------------";
    public static final String DAY_DEMARCATION = "|";
    public static final String NO_TASK_IN_DAY = "                 |";
    public static final String DELETED_TASK = "Task has been deleted!";
    public static final String CALENDAR_INVALID_ARGS = "'calendar' should be followed by a suffixed command!";
    public static final String CALENDAR_EDIT_DELETE_INVALID_ARGS = "Task index not entered...";
    public static final String NAME_ABSENT = " Task name not found after n/";
    public static final String DELIMITER_DATE = "-";
    public static final int CALENDAR_COMMAND_SPLIT = 9;
    public static final int INDEX_ZERO = 0;
    public static final int INDEX_ONE = 1;
    public static final String LECTURE_TASK_SPLIT = " **------------**  **------------** "
                    + " **------------**  **------------**  "
                    + "**------------**  **------------**  **------------** ";
    //SCHEDULE END

    //HELP BEGIN
    public static final String HELP_MESSAGE = "List of valid commands:\n1. module\n2. calendar\n3. food\n"
            + "4. exit\nType help <COMMAND_NAME> to get a detailed description";
    public static final String HELP_MESSAGE_MODULE = "";
    public static final String HELP_MESSAGE_CALENDAR = "";
    public static final String HELP_MESSAGE_FOOD = "food add n/ [FOOD_NAME] c/ [CALORIE]\nfood list\nfood clear";
    public static final String HELP_MESSAGE_EXIT = "Saves your current progress and exits the application";
    //HELP END
}
