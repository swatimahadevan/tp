package seedu.duke.ui.schedule;

import java.time.YearMonth;

//@author swatim
public class UiSchedule {

    private static String HORIZONTAL_LINE = "________________________________________________________";

    public static void printCalenderTitle(YearMonth inputYearMonth) {
        System.out.println("                     " + inputYearMonth.getMonth() + " "
                + inputYearMonth.getYear());
        System.out.println(HORIZONTAL_LINE);
    }

}
