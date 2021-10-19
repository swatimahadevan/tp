package seedu.duke.schedule.lecture;

import java.util.ArrayList;

public class LectureList {

    private ArrayList<Lecture> lectures;

    public LectureList() {
        this.lectures = new ArrayList<>();
    }

    public ArrayList<Lecture> getLectureList() {
        return lectures;
    }

    public void addLecture(Lecture lecture) {
        lectures.add(lecture);
    }

    public void deleteLecture(int index) {
        lectures.remove(index - 1);
    }

}