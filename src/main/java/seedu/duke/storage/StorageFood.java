package seedu.duke.storage;


import seedu.duke.food.FoodRecord;
import seedu.duke.food.WhatIAteList;
import seedu.duke.logger.ClickLogger;
import seedu.duke.parser.Parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;

/**
 * This class deals with passing food records to and fro a save file.
 * Note: i used my IP implementation, TBD on final format.
 * @author ngnigel99
 */
public class StorageFood {
    private static final String folderName = "fooddata/";
    private static final String fileName = "food.txt";
    private static String filePath =  folderName +  fileName;

    public StorageFood(String filePathToInput) {
        filePath = filePathToInput;
    }


    /**
     * Saves list to save file.
     *
     * @param whatIAteList food record list to save
     * @throws IOException if file/ directory not found
     *                     - handled by creating new directory/ file if necessary
     */
    public static void saveList(WhatIAteList whatIAteList) throws IOException {
        assert !whatIAteList.equals(null) : "Please instantiate the list object correctly";
        Storage.checkAndAddDirectory(folderName);
        File newList = new File(folderName + fileName);
        FileWriter fw = new FileWriter(folderName + fileName);
        ClickLogger.getNewLogger().log(Level.INFO, "Writing to " + folderName + fileName);
        for (FoodRecord f : whatIAteList.getList()) {
            fw.write(f.toSaveListFormat());
        }
        ClickLogger.getNewLogger().log(Level.INFO, "done writing to " + folderName + fileName);
        fw.close();
    }


    /**
     * Returns a food list.
     * format of task per line of save file:
     * [NAME] |  [CALORIES]
     *
     * @return listToReturn food list generated from save file
     *          if save file not found, create new list and return
     */
    public static WhatIAteList load() {
        WhatIAteList listToReturn = new WhatIAteList();
        try {
            Storage.checkAndAddDirectory(folderName);
            File f = new File(filePath);
            Scanner scanList = new Scanner(f);
            while (scanList.hasNext()) {
                String readLine = scanList.nextLine();
                if (readLine.equals("")) {
                    break;
                }
                listToReturn.addToList(Parser.parseFoodSavedListToRecord(readLine), true);
            }
            return listToReturn;
        } catch (FileNotFoundException e) {
            ClickLogger.getNewLogger().log(Level.WARNING, "file not found on load");
            File f = new File(filePath);
            System.out.println("Hey, I didn't find list.txt in " + folderName + "!");
            System.out.println("creating new file...");
            ClickLogger.getNewLogger().log(Level.CONFIG, "create new text file");
        } catch (NullPointerException e) {
            System.out.println("Null Pointer Exception, try again!");
        } catch (IOException e) {
            System.out.println("Hey, Input/ Output exception, returning empty list...");
        }
        return listToReturn;
    }
}
