package seedu.duke;

import java.time.YearMonth;
import java.util.Scanner;
import seedu.duke.schedule.Schedule;

public class Duke {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        // @author swatim
        // display calendar at beginning
        YearMonth currentYearMonth = YearMonth.now();
        Schedule.displayCalendar(currentYearMonth);

        System.out.println("What is your name?");
        Scanner in = new Scanner(System.in);
        System.out.println("Hello " + in.nextLine());
    }
}