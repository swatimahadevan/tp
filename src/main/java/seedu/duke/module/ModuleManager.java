package seedu.duke.module;

import seedu.duke.exceptions.module.IllegalModuleIndexException;
import seedu.duke.parser.module.ParserModule;
import seedu.duke.storage.StorageModule;

import java.io.IOException;

public class ModuleManager {
    static GradePoints gradePoints = new GradePoints();
    static double expectedCap = 0.0;
    static StorageModule storageModule = new StorageModule();
    static ParserModule parserModule = new ParserModule();

    public void addNewModule(Module module) throws IOException {
        ModuleList moduleList = storageModule.readDataFromFile();
        moduleList.addModule(module);
        storageModule.saveDataToFile(moduleList);
    }

    public void deleteModule(int moduleIndex) throws IOException, IllegalModuleIndexException {
        ModuleList moduleList = storageModule.readDataFromFile();
        boolean isValidIndex = (moduleIndex >= 0) && (moduleIndex < moduleList.getNumberOfModules());
        if (!isValidIndex) {
            throw new IllegalModuleIndexException();
        }
        moduleList.removeModuleByIndex(moduleIndex);
        storageModule.saveDataToFile(moduleList);
    }

    public double getExpectedCap() throws IOException {
        expectedCap = 0.0;
        ModuleList moduleList = storageModule.readDataFromFile();
        for (Module module : moduleList.getModules()) {
            double point = gradePoints.getPoint(module.getExpectedGrade());
            if (point != -1) {
                expectedCap += point;
            }
        }
        return expectedCap;
    }

}
