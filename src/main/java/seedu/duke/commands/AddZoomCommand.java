package seedu.duke.commands;

import seedu.duke.exceptions.ClickException;
import seedu.duke.exceptions.FileNotFoundException;
import seedu.duke.storage.Storage;
import seedu.duke.storage.StorageZoom;
import seedu.duke.ui.Ui;

import java.io.IOException;

public class AddZoomCommand extends Command {
    private String moduleName;
    private String zoomLink;

    public AddZoomCommand(String moduleName, String zoomLink) {
        this.helpMessage = "Displays all important zoom links";
        this.moduleName = moduleName;
        this.zoomLink = zoomLink;
    }

    @Override
    public void execute(Ui ui, Storage storage) throws IOException {
        try {
            StorageZoom.saveLink(moduleName, zoomLink);
        } catch (IOException e) {
            System.out.println("Unsuccessful");
        }
    }
}
