package seedu.duke.constants;

/**
 * A class that contains constants related to Commands.
 */
public class CommandConstants {
    public static final String COMMAND_EXIT = "exit";
    public static final String COMMAND_CALENDAR = "calendar";
    public static final String COMMAND_FOOD     = "food";
    public static final String COMMAND_SUFFIX_ADD = "add";
    public static final String COMMAND_SUFFIX_CLEAR = "clear";
    public static final String COMMAND_SUFFIX_LIST = "list";
    public static final String COMMAND_ADD_NOTE = "notebook";
    public static final String COMMAND_DELETE_NOTE = "delete_notebook";
    public static final String COMMAND_DELETE_ENTRY = "delete_entry";
    public static final String COMMAND_ADD_ENTRY = "entry";
    public static final String COMMAND_JOURNAL_LIST = "list";
    public static final String COMMAND_JOURNAL_TAG = "tag";
    public static final String COMMAND_JOURNAL_FIND = "find";
    public static final String COMMAND_NOTE = "journal";
    public static final String COMMAND_TODO = "todo";
    public static final String COMMAND_DISPLAY = "display";
    public static final String COMMAND_LECTURE = "lecture";

    public static final String COMMAND_MODULE = "module";
    public static final String COMMAND_SUFFIX_DELETE = "delete";
    public static final String COMMAND_SUFFIX_EDIT = "edit";

    public static final String COMMAND_CAP = "cap";
    public static final String COMMAND_SUFFIX_EXPECTED = "expected";

    public static final String COMMAND_HElP = "help";
    public static final String COMMAND_ZOOM = "zoom";
    public static final String COMMAND_ZOOM_SUFFIX_ADD = "add";
    public static final String COMMAND_ZOOM_SUFFIX_OPEN = "open";
    public static final String COMMAND_ZOOM_SUFFIX_LIST = "show";
    public static final String COMMAND_SUFFIX_VIEW = "view";
    public static final String COMMAND_SUFFIX_FIND = "find";
    public static final String COMMAND_SUFFIX_RADD = "radd";

    public static  String HELP_MESSAGES =
        "\tAdd Entry  : journal entry n/ [NOTEBOOK_NAME] e/ [ENTRY_NAME]\n"
            +
        "\tAdd Food  : food add n/ [FOOD_NAME] c/ [CALORIE] d/ {DD-MM-YYYY(DATE_RECORDED)}\n"
            +
        "\tAdd Food From Reference  : food radd s/ [STORE_INDEX] i/ [ITEM_INDEX]\n"
            +
        "\tAdd Lecture  : calendar lecture m/ [MODULE_CODE] s/ [DD-MM-YYYY(START_DATE)] e/ [DD-MM-YYYY(END_DATE)]\n"
            +
        "\tAdd Module  : module add c/ [MODULE_CODE] n/ [MODULE_NAME] e/ [EXPECTED_GRADE]\n"
            +
        "\tAdd Note  : journal notebook n/ [NOTEBOOK_NAME]\n"
            +
        "\tAdd Todo  : calendar todo n/ [TASK_NAME] d/ [DD-MM-YYYY]\n"
            +
        "\tAdd Zoom  : zoom add [MODULE_CODE] [ZOOM_LINK]\n"
            +
        "\tCap Edit Info  : module info\n"
            +
        "\tClear Food  : food clear\n"
            +
        "\tDelete Entry  : journal delete_entry n/ [NOTEBOOK_NAME] e/ [ENTRY_NAME]\n"
            +
        "\tDelete Food  : food delete [INDEX]\n"
            +
        "\tDelete Lecture  : calendar delete lec [LECTURE_INDEX]\n"
            +
        "\tDelete Module  : food add n/ [FOOD_NAME] c/ [CALORIE]\n"
            +
        "\tDelete Note  : journal delete_notebook [NOTE_INDEX]\n"
            +
        "\tDelete Task  : calendar delete task [TASK_INDEX]\n"
            +
        "\tDisplay  : calendar display [MM-YYYY]\n"
            +
        "\tEdit Tasks  : calendar edit [TASK_INDEX]\n"
            +
        "\tFind Food With Date  : food find [DD-MM-YYYY]\n"
            +
        "\tFind Notebooks By Tag  : journal find [TAG_NAME]\n"
            +
        "\tGet Expected Cap  : module cap\n"
            +
        "\tList Food  : food list\n"
            +
        "\tList Journal  : journal list\n"
            +
        "\tList Lectures  : calendar list lec\n"
            +
        "\tList Module  : module list\n"
            +
        "\tList Tasks  : calendar list task\n"
            +
        "\tList Zoom Links  : zoom list\n"
            +
        "\tOpen Zoom Link  : zoom open [MODULE_CODE]\n"
            +
        "\tTag Notebook  : journal tag n/ [NOTE_INDEX] t/ [TAG_NAME]\n"
            +
        "\tView Reference Food  : food view, food view [STORE_INDEX], food view all \n";
}
