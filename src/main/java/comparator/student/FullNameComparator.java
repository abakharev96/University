package comparator.student;

import comparator.StudentComparator;
import models.Student;
import org.apache.commons.lang3.StringUtils;

public class FullNameComparator implements StudentComparator {
    @Override
    public int compare(Student o1, Student o2) {
        return StringUtils.compare(o1.getFullName(), o2.getFullName());
    }
}
