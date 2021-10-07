package seedu.duke.task;

public class Todo extends Task {

    private String todoDate;

    public Todo(String description, String todoDate) {
        super(description);
        this.todoDate = todoDate;
    }

    @Override
    public String toString() {
        return super.toString() + " (on: " + todoDate + ")" + "[T]";
    }
}
