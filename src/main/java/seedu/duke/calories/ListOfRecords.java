package seedu.duke.calories;

import java.util.ArrayList;

/**
 * An abstract class for implementing food record  lists
 * @author ngnigel99
 */
public abstract class ListOfRecords<T> {
    protected ArrayList<T> List =  new  ArrayList<>();

    /**
     * Adds items to a list
     *
     * @author ngnigel99
     * @param recordToAdd
     */
    protected void addToList(T recordToAdd) {
        List.add(recordToAdd);
    }

    /**
     * Prints a list
     *
     * @author ngnigel99
     */
    protected void printList() {
        for (Object listRecord : List) {
            System.out.println(listRecord);
        }
    }

    /**
     * Clears a list,  and wipes  storage
     *
     * @author  ngnigel99
     */
    protected void clearList()  {
        List.clear();
    }
}
