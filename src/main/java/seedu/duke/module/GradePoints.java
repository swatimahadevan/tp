package seedu.duke.module;

import java.util.Map;

public class GradePoints {
    Map<String, Double> gradePoints;

    public GradePoints() {
        gradePoints.put("A+", 5.0);
        gradePoints.put("A", 5.0);
        gradePoints.put("A-", 4.5);
        gradePoints.put("B+", 4.0);
        gradePoints.put("B", 3.5);
        gradePoints.put("B-", 3.0);
        gradePoints.put("C+", 2.5);
        gradePoints.put("C", 2.0);
        gradePoints.put("D+", 1.5);
        gradePoints.put("D", 1.0);
        gradePoints.put("F", 0.0);
        gradePoints.put("CS", -1.0);
        gradePoints.put("CU", -1.0);
        gradePoints.put("NA", -1.0);
    }

    public Double getPoint(String rawGrade) {
        return gradePoints.get(rawGrade);
    }

    public boolean isValidGrade(String rawGrade) {
        return gradePoints.containsKey(rawGrade);
    }
}
