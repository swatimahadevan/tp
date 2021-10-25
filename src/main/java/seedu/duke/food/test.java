package seedu.duke.food;

import seedu.duke.Click;
import seedu.duke.commands.Command;
import seedu.duke.exceptions.ClickException;
import seedu.duke.food.ReferenceList;
import seedu.duke.logger.ClickLogger;

import java.util.Scanner;

public class test {
    private static void run() {
        }
    public static void main(String[] args) {
        ReferenceList AsianDelights = new ReferenceList("food/", "TE_asian_delights.txt");
        AsianDelights.getList().printList();
    }
}
