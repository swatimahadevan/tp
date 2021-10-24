package seedu.duke.journal;

import java.util.ArrayList;

public class CollectionOfEntries {
    private static ArrayList<Entry> entries = new ArrayList<>();

    public CollectionOfEntries() {
        this.entries = new ArrayList<>();
    }

    /**
     * Returns list of entries.
     *
     * @return list of entries
     */
    public ArrayList<Entry> getEntriesArrayList() {
        return entries;
    }

    /**
     * Adds entry to collection of entries.
     *
     * @param nameOfNote contains notebook name in which to add entry
     * @param nameOfEntry contains name of entry
     */
    public static void addEntry(String nameOfNote, String nameOfEntry) {
        entries.add(new Entry(nameOfNote, nameOfEntry));
    }

    /**
     * Deletes entry from the notebook based on its index.
     *
     * @param indexOfEntry contains index of entry to be deleted
     */
    public static void deleteEntry(String noteName, int indexOfEntry) {
        for (Entry entry: entries) {
            if (entry.getEntryNoteName().equals(noteName)) {

                entries.remove(indexOfEntry - 1);
            }
        }
    }
}