package seedu.duke.exceptions.calendar;

public class MissingTodoArgumentsException extends Exception {
    public MissingTodoArgumentsException(String message) {
        System.out.println(message);
    }
}
