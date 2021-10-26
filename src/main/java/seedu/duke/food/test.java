package seedu.duke.food;

import seedu.duke.foodreferencelists.*;
import seedu.duke.parser.Parser;
import seedu.duke.storage.StorageFood;


public class test {

    public static void main(String[] args) {
    ReferenceLists techno = ReferenceLists.getLists();
    techno.getTechnoEdge().printStalls();
    techno.getTechnoEdge().printItems(1);
    }
}
