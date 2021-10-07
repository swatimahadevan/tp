package seedu.duke.task;

public abstract class Task {

    protected String description;
    private boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); //return tick or X symbols
    }

    @Override
    public String toString() {
        return description + "[" + getStatusIcon() + "] ";
    }
}
