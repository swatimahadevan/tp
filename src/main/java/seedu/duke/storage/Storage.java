package seedu.duke.storage;

import seedu.duke.food.WhatIAteList;
import seedu.duke.journal.CollectionOfEntries;
import seedu.duke.journal.CollectionOfNotes;
import seedu.duke.logger.ClickLogger;
import seedu.duke.schedule.lecture.Lecture;
import seedu.duke.schedule.lecture.LectureList;
import seedu.duke.schedule.task.TaskList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.stream.Collectors;

public class Storage {

    /**
     * Synchronised date with food record  list.
     *
     * @author ngnigel99
     * */
    private Date todaysDate;    //TODO sync date with file
    private String tasksFilePath;

    public WhatIAteList whatIAteTodayList =  StorageFood.load();
    public static TaskList tasksList;

    static {
        try {
            tasksList = StorageTasks.readTaskList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CollectionOfNotes collectionOfNotes = StorageNotes.readCollectionOfNotes();
    public CollectionOfEntries collectionOfEntries = StorageEntries.readEntries();
    public StorageModule storageModule = new StorageModule();
    public static LectureList lectureList;

    static {
        try {
            lectureList = StorageLecture.readLectureList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Storage() throws IOException {
    }

    /**
     * Creates directory if directory folderName is not found.
     * access modifier left empty for working in Storage.
     * @param folderName folder name to check
     * @throws IOException case where directory not found
     *
     * @author ngnigel99
     */
    static void checkAndAddDirectory(String folderName) throws IOException {
        assert folderName.contains("/") : "Please follow format [DIR_NAME]/";   //checks syntax of constant
        String home = new File("").getAbsolutePath() + '/';
        File dirCheck = new File(home + folderName);
        ClickLogger.getNewLogger().log(Level.INFO,  "checking if directory exists!");
        if (dirCheck.isDirectory()) {
            ClickLogger.getNewLogger().log(Level.INFO, "nice, directory found!");
            return;
        }
        ClickLogger.getNewLogger().log(Level.CONFIG, "not nice, no directory found,"
                +     "creating  new directory");
        System.out.println("Hey, I didn't find directory " + folderName);
        System.out.println("adding " + folderName + " into repository...");
        Files.createDirectories(Paths.get(home + folderName));
    }

    //@author swatim
    //Loads data in the form of ArrayList<String> data from the save file
    public static ArrayList<String> loadDataFromSaveFile(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList<String> data;
        data = bufferedReader.lines().collect(Collectors.toCollection(ArrayList::new));
        return data;
    }

    //Write data from ArrayList<String> data onto save file
    public static void writeDataOntoSaveFile(String filePath, ArrayList<String> data) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        for (String dataObject : data) {
            bufferedWriter.write(dataObject + '\n');
        }
        bufferedWriter.close();
    }
}
