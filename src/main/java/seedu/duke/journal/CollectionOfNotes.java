package seedu.duke.journal;

import java.util.ArrayList;

public class CollectionOfNotes {
    private static ArrayList<Note> notes = new ArrayList<>();

    public CollectionOfNotes() {
        this.notes = new ArrayList<>();
    }

    /**
     * Returns list of notes.
     *
     * @return list of notes.
     */
    public ArrayList<Note> getNotesArrayList() {
        return notes;
    }

    /**
     * Adds notebooks to a collection of notebooks.
     *
     * @param nameOfNote contains notebook name
     */
    public static void addNote(String nameOfNote) {
        notes.add(new Note(nameOfNote));
    }

    /**
     * Deletes notebooks from a collection of notebooks.
     *
     * @param indexOfNote contains index of notebook to be deleted
     */
    public static void deleteNote(int indexOfNote) {
        notes.remove(indexOfNote - 1);
    }

}