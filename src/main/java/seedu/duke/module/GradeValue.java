package seedu.duke.module;

import java.util.EnumMap;

public class GradeValue {
    EnumMap<Grade, Double> gradeValue;

    public GradeValue() {
        gradeValue.put(Grade.A_PLUS, 5.0);
        gradeValue.put(Grade.A, 5.0);
        gradeValue.put(Grade.A_MINUS, 4.5);
        gradeValue.put(Grade.B_PLUS, 4.0);
        gradeValue.put(Grade.B, 3.5);
        gradeValue.put(Grade.B_MINUS, 3.0);
        gradeValue.put(Grade.C_PLUS, 2.5);
        gradeValue.put(Grade.C, 2.0);
        gradeValue.put(Grade.D_PLUS, 1.5);
        gradeValue.put(Grade.D, 1.0);
        gradeValue.put(Grade.F, 0.0);
        gradeValue.put(Grade.CS, -1.0);
        gradeValue.put(Grade.CU, -1.0);
        gradeValue.put(Grade.NA, -1.0);
    }
