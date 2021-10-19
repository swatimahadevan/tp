package seedu.duke.commands.zoom;

import seedu.duke.commands.Command;
import seedu.duke.exceptions.ClickException;
import seedu.duke.exceptions.FileNotFoundException;
import seedu.duke.storage.Storage;
import seedu.duke.storage.StorageZoom;
import seedu.duke.ui.Ui;

import java.io.IOException;

public class AddZoomCommand extends Command {
    private String moduleName;
    private String zoomLink;

    public AddZoomCommand() {
        syntax = "zoom add [MODULE_CODE] [ZOOM_LINK]";
    }

    public AddZoomCommand(String moduleName, String zoomLink) {
        helpMessage = "Adds zoom links";
        syntax = "zoom add [MODULE_CODE] [ZOOM_LINK]";
        this.moduleName = moduleName;
        this.zoomLink = zoomLink;
    }

    @Override
    public void execute(Ui ui, Storage storage) throws IOException {
        try {
            StorageZoom.saveLink(moduleName, zoomLink);
            System.out.println("Successful");
        } catch (IOException e) {
            System.out.println("Unsuccessful");
        }
    }
}
