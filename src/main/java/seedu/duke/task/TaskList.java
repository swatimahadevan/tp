package seedu.duke.task;

import java.util.ArrayList;

public class TaskList {

    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public ArrayList<Task> getTaskList() {
        return tasks;
    }

    /**
     * Allows for adding of task to list of tasks.
     *
     * @param task task to be added.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Allows for deleting of task from list of tasks.
     *
     * @param index index of task to be deleted.
     */
    public void deleteTask(int index) {
        tasks.remove(index - 1);
    }

    public void editTask(int index, String description, String date) {
        Task task = new Todo(description, date);
        tasks.set(index - 1, task);
    }

}