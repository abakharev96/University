package comparator.student;

import comparator.StudentComparator;
import models.Student;

public class ResidenceComparator implements StudentComparator {
    @Override
    public int compare(Student o1, Student o2) {
        return Boolean.compare(o1.isRusCitizen(), o2.isRusCitizen());
    }
}
