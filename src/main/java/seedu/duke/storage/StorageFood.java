package seedu.duke.storage;


import seedu.duke.food.FoodRecord;
import seedu.duke.food.WhatIAteList;
import seedu.duke.parser.Parser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This class deals with passing food records to and fro a save file.
 * Note: i used my IP implementation, TBD on final format.
 * @author ngnigel99
 */
public class StorageFood {
    private static final String STORAGE_DIVISOR = "\\|";
    private static final String folderName = "data/";
    private static final String fileName = "food.txt";
    private static String filePath;

    public StorageFood(String filePathToInput) {
        filePath = filePathToInput;
    }

    /**
     * Creates directory if directory folderName is not found.
     *
     * @throws IOException case where directory not found
     */
    private static void checkAndAddDirectory() throws IOException {
        String home = new File("").getAbsolutePath() + '/';
        File dirCheck = new File(home + folderName);
        if (dirCheck.isDirectory()) {
            return;
        }
        System.out.println("Hey, I didn't find directory " + folderName);
        System.out.println("adding " + folderName + " into repository...");
        Files.createDirectories(Paths.get(home + folderName));
    }

    /**
     * Saves list to save file.
     *
     * @param whatIAteList food record list to save
     * @throws IOException if file/ directory not found
     *                     - handled by creating new directory/ file if necessary
     */
    public static void saveList(WhatIAteList whatIAteList) throws IOException {
        checkAndAddDirectory();
        File newList = new File(folderName + fileName);
        FileWriter fw = new FileWriter(folderName + fileName);
        for (FoodRecord f : whatIAteList.getList()) {
            fw.write(f.toSaveListFormat());
        }
        fw.close();
    }

    /**
     * Parses text to a <code>Food Record</code>.
     *
     * @param readLine       line of text to read
     * @param taskListToSave task list to add food record
     */
    private static void addTaskToArray(String readLine, WhatIAteList taskListToSave) {
        FoodRecord foodRecord = Parser.parseFoodSavedListToRecord(readLine);
        taskListToSave.addToList(foodRecord);
    }

}
