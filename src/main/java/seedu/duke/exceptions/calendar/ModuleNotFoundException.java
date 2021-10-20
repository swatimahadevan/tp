package seedu.duke.exceptions.calendar;

public class ModuleNotFoundException extends Exception {
    public ModuleNotFoundException() {
        System.out.println("You have to add a module before you can add a lecture to it !");
    }
}
