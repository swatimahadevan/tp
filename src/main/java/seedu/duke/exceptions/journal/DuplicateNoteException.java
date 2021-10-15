package seedu.duke.exceptions.journal;

public class DuplicateNoteException extends Exception {
    public DuplicateNoteException() {
        System.out.println("Error ! The notebook already exists");
    }
}
