package comparator.student;

import comparator.StudentComparator;
import comparator.UniversityComparator;
import models.Student;

public class AvgExamScoreComparator implements StudentComparator {
    @Override
    public int compare(Student o1, Student o2) {
        return Float.compare(o1.getAvgExamScore(), o2.getAvgExamScore());
    }
}
