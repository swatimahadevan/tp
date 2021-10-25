package seedu.duke.food;

//@@author ngnigel99

import seedu.duke.storage.StorageFood;

/**
 * A reference list containing items sold: name, calorie count
 * to be easily referenced by the user in addition.
 */
public class ReferenceList {
    private String folderName;
    private String fileName;
    private WhatIAteList referenceList;

    public ReferenceList(String folderName, String fileName) {
        this.folderName = folderName;
        this.fileName = fileName;
        this.referenceList = StorageFood.load(folderName, fileName);
    }

    public WhatIAteList getList() {
        return referenceList;
    }

}
