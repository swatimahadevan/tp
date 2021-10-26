package seedu.duke.commands.zoom;

import seedu.duke.commands.Command;
import seedu.duke.storage.Storage;
import seedu.duke.storage.StorageZoom;
import seedu.duke.ui.Ui;

public class ListZoomLinks extends Command {
    public ListZoomLinks() {
        syntax = "zoom list";
    }

    @Override
    public void execute(Ui ui, Storage storage) throws Exception {
        ui.printLine();
        try {
            StorageZoom.displayLinks();
            ui.printLine();
        } catch (Exception e) {
            System.out.println("Unable to open the file");
            ui.printLine();
        }
    }
}
