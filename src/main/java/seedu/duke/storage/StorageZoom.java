package seedu.duke.storage;


import seedu.duke.ui.Ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StorageZoom {
    private static final String folderName = "zoomdata/";
    private static final String fileName = "zoom.txt";
    private static String filePath =  folderName +  fileName;

    public static void saveLink(String moduleName, String zoomLink) throws IOException {
        File newList = new File(folderName + fileName);
        FileWriter fw = new FileWriter(folderName + fileName, true);
        fw.write(moduleName + '-' + zoomLink + "\n");
        fw.close();
    }

    public static void displayLinks() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(folderName + fileName));
            String line;
            while ((line = br.readLine()) != null) {
                String moduleName = line.split("-")[0];
                String zoomLink = line.split("-")[1];
                Ui.displayZoomLink(moduleName, zoomLink);
            }
        } catch (Exception e) {
            System.out.println("File cannot be found!");
        }

    }

}
