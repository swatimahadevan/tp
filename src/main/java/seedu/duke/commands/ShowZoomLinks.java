package seedu.duke.commands;

import seedu.duke.storage.Storage;
import seedu.duke.storage.StorageZoom;
import seedu.duke.ui.Ui;

public class ShowZoomLinks extends Command {
    public ShowZoomLinks() {

    }

    @Override
    public void execute(Ui ui, Storage storage) throws Exception {
        try {
            StorageZoom.displayLinks();
        } catch (Exception e) {
            System.out.println("Unable to open the file");
        }
    }
}
