package seedu.duke.task;

public class Todo extends Task {

    public Todo(String description, String date) {
        super(description, date);
    }

    /**
     * Returns in format for storage file.
     *
     * @return storage file in string format.
     */
    @Override
    public String toSaveFileFormat() {
        return "todo" + "|" + description + "|" + date;
    }

    /**
     * Returns todo information in format for printing.
     *
     * @return todo information in format for printing
     */
    @Override
    public String toString() {
        return super.toString() + " (on: " + date + ")";
    }

}
