package seedu.duke.module;

import java.util.EnumMap;

public class LetterGrade {
    EnumMap<Grade, String> letterGrades;

    public LetterGrade() {
        letterGrades.put(Grade.A_PLUS, "A+");
        letterGrades.put(Grade.A, "A");
        letterGrades.put(Grade.A_MINUS, "A-");
        letterGrades.put(Grade.B_PLUS, "B+");
        letterGrades.put(Grade.B, "B");
        letterGrades.put(Grade.B_MINUS, "B-");
        letterGrades.put(Grade.C_PLUS, "C+");
        letterGrades.put(Grade.C, "C");
        letterGrades.put(Grade.D_PLUS, "D+");
        letterGrades.put(Grade.D, "D");
        letterGrades.put(Grade.F, "F");
        letterGrades.put(Grade.CS, "CS");
        letterGrades.put(Grade.CU, "CU");
        letterGrades.put(Grade.NA, "NA");
    }
}
