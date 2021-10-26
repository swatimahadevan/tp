package seedu.duke.food;

//@@author ngnigel99

import seedu.duke.foodreferencelists.StallsDataAndLogic;

import java.util.ArrayList;

/**
 * A reference list containing items sold: name, calorie count
 * to be easily referenced by the user in addition.
 * For Click in particular, we limit the scope for food courts
 * to technoEdge as a reference. The user can simply add in their
 * own food name and calories if needed without referring to this list.
 */
public class ReferenceLists {
    private static ReferenceLists lists = null;
    private StallsDataAndLogic technoEdge = new StallsDataAndLogic();
    public ArrayList<WhatIAteList> storeData;

    //singleton design as only one food court is viewed
    private ReferenceLists() {
        technoEdge = new StallsDataAndLogic();
    }

    public static ReferenceLists getLists() {
        if (lists == null) {
            lists = new ReferenceLists();
        }
        return lists;
    }

    public StallsDataAndLogic getTechnoEdge() {
        return technoEdge;
    }

}
