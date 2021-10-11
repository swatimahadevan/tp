package seedu.duke.journal;

import java.util.ArrayList;

public class CollectionOfNotes {
    private static final ArrayList<Note> notes = new ArrayList<>();

    public ArrayList<Note> getNotesArrayList() {
        return notes;
    }

    public static void addNote(String nameOfNote) {
        notes.add(new Note(nameOfNote));
    }

    public static void print()
    {
        for(int i = 0; i < notes.size(); i++) {
            System.out.println(notes.get(i).getNoteName());
        }
    }
}