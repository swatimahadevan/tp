package seedu.duke.storage;


import seedu.duke.exceptions.StorageException;
import seedu.duke.exceptions.module.IllegalModuleException;
import seedu.duke.module.Module;
import seedu.duke.ui.Ui;
import seedu.duke.parser.module.ParserModule;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class StorageZoom {
    private static final String folderName = "zoomdata/";
    private static final String fileName = "zoom.txt";
    private static String filePath =  folderName +  fileName;
    private static ParserModule parserModule = new ParserModule();

    public static void saveLink(String moduleName, String zoomLink) throws IOException {
        Storage.checkAndAddDirectory(folderName);
        File newList = new File(folderName + fileName);
        FileWriter fw = new FileWriter(folderName + fileName, true);
        File moduleList = new File("module/module.txt");
        ArrayList<String> listOfModules = new ArrayList<>();

        Scanner scanner = new Scanner(moduleList);
        while (scanner.hasNext()) {
            String module;
            module = scanner.nextLine();
            listOfModules.add(module.split(" ")[0]);
        }

        if (listOfModules.contains(moduleName)) {
            fw.write(moduleName + '-' + zoomLink + "\n");
            fw.close();
        } else {
            System.out.println("Module Not Found!");
        }

    }

    public static void displayLinks() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(folderName + fileName));
            String line;
            while ((line = br.readLine()) != null) {
                String moduleName = line.split("-", 2)[0];
                String zoomLink = line.split("-", 2)[1];
                Ui.displayZoomLink(moduleName, zoomLink);
            }
        } catch (Exception e) {
            System.out.println("File cannot be found!");
        }

    }

}
