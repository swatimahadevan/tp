package seedu.duke.parser.journal;

public class ParserJournal {
    //@author SvethaMahadevan
    public static String parseAddNoteCommand(String input) {
        String noteNameDetails = input.trim().split("add")[1];
        String noteName = noteNameDetails.split("n/")[1].trim();
        return noteName;
    }
}
