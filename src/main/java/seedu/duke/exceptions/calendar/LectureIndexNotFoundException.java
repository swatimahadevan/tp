package seedu.duke.exceptions.calendar;

public class LectureIndexNotFoundException extends Exception {
    public LectureIndexNotFoundException() {
        System.out.println("Cannot find index of lecture to delete! Use 'calendar list lec' first"
                + "to find desired lecture index");
    }
}
