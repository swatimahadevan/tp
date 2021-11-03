package seedu.duke.constants;

import static seedu.duke.constants.Messages.NEW_LINE;

public class ExceptionMessages {

    public static final String MESSAGE_ILLEGAL_COMMAND = "Illegal command. Type help to get the supported commands.";

    public static final String MESSAGE_ILLEGAL_MODULE_INDEX = "Illegal module index."
            + " Index must be an integer between 1 and the total of modules you have.";
    public static final String MESSAGE_ILLEGAL_TOTAL_MC_TAKEN = "Number of total MC taken must be a positive integer.";
    public static final String MESSAGE_ILLEGAL_CURRENT_CAP = "CAP must be a real number between 0.0 and 5.0";
    public static final String MESSAGE_ILLEGAL_EXPECTED_GRADE = "Illegal expected grade."
            + "The supported grades are A+, A, A-, B+, B, B-, C+, C, D+, D, F, CS, CU, and NA.";
    public static final String MESSAGE_ILLEGAL_MODULE = "Illegal module." + NEW_LINE
            + "Please follow the syntax module add c/MODULE_CODE {n/MODULE_NAME mc/MODULAR CREDITS e/EXPECTED_GRADE}";
    public static final String MESSAGE_ILLEGAL_MODULAR_CREDIT = "The modular credit must be a positive integer.";
    public static final String MESSAGE_DUPLICATE_MODULE = "The module already exists. "
            + "Type module list to see the list of module.";

}