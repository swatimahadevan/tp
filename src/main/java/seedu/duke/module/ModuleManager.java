package seedu.duke.module;

import seedu.duke.exceptions.module.IllegalExpectedGradeException;
import seedu.duke.exceptions.module.IllegalModuleIndexException;
import seedu.duke.parser.module.ParserModule;
import seedu.duke.storage.StorageModule;

import java.io.IOException;

//@@author nvbinh15

/**
 * A class that deals with the operations related to Modules.
 */
public class ModuleManager {
    public static final String MESSAGE_DELETE_MODULE = "I have deleted this module:";

    private static GradePoints gradePoints = new GradePoints();
    private static StorageModule storageModule = new StorageModule();
    private static ParserModule parserModule = new ParserModule();
    private static double currentCap = 0.0;
    private static int totalMcTaken = 0;

    /**
     * Default constructor.
     */
    public ModuleManager() {

    }

    /**
     * Adds a new module to the ModuleList.
     *
     * @param module The Module to be added.
     * @throws IOException If there is an exceptions when reading or writing data to file.
     * @throws IllegalExpectedGradeException If the expected grade of the Module is illegal.
     */
    public void addNewModule(Module module) throws IOException, IllegalExpectedGradeException {
        ModuleList moduleList = storageModule.readDataFromFile();
        String expectedGrade = module.getExpectedGrade();
        if (!gradePoints.isValidGrade(expectedGrade)) {
            throw new IllegalExpectedGradeException();
        }
        moduleList.addModule(module);
        storageModule.saveDataToFile(moduleList);
    }

    /**
     * Deletes a module from the ModuleList.
     *
     * @param moduleIndex Index of the Module to be deleted.
     * @throws IOException If there is an exceptions when reading or writing data to file.
     * @throws IllegalModuleIndexException If the index of the Module is illegal.
     */
    public void deleteModule(int moduleIndex) throws IOException, IllegalModuleIndexException {
        ModuleList moduleList = storageModule.readDataFromFile();
        boolean isValidIndex = (moduleIndex >= 0) && (moduleIndex < moduleList.getNumberOfModules());
        if (!isValidIndex) {
            throw new IllegalModuleIndexException();
        }
        System.out.println(MESSAGE_DELETE_MODULE);
        System.out.println(moduleList.getModuleByIndex(moduleIndex));
        moduleList.removeModuleByIndex(moduleIndex);
        storageModule.saveDataToFile(moduleList);
    }

    public static void setCapInfo(double cap, int mc) {
        currentCap = cap;
        totalMcTaken = mc;
    }

    public double getCurrentCap() {
        return currentCap;
    }

    public int getTotalMcTaken() {
        return totalMcTaken;
    }

    /**
     * Returns the expected Cumulative Average Point (CAP).
     *
     * @return The expected CAP.
     * @throws IOException If there is an exceptions when reading data to file.
     */
    public double getExpectedCap() throws IOException {
        double totalPoints = currentCap * totalMcTaken;
        int totalModularCredits = totalMcTaken;
        ModuleList moduleList = storageModule.readDataFromFile();
        for (Module module : moduleList.getModules()) {
            double point = gradePoints.getPoint(module.getExpectedGrade());
            if (point != -1) {
                int credits = module.getModularCredits();
                totalPoints += point * credits;
                totalModularCredits += credits;
            }
        }
        return totalPoints / totalModularCredits;
    }

}
