package seedu.duke.journal;

import java.util.ArrayList;

public class Note {
    protected String noteName;
    private static final ArrayList<Entry> entriesList = new ArrayList<>();

    public Note(String noteName) {
        this.noteName = noteName;
    }

    public String getNoteName() {
        return noteName;
    }

    public static void addEntry(String title)  {
        entriesList.add(new Entry(title));
    }

    public String toSaveFileFormat() {
        return "note" + "|" + noteName;
    }

    public static void print()
    {
        for(int i = 0; i < entriesList.size(); i++) {
            System.out.println(entriesList.get(i).getOfJournalEntry());
        }
    }
}