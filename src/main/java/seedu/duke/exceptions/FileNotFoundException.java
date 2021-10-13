package seedu.duke.exceptions;

public class FileNotFoundException extends Exception {
    public FileNotFoundException() {
        System.out.println("Error: File not found");
    }
}
