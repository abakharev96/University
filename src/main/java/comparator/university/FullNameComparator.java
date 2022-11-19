package comparator.university;

import comparator.UniversityComparator;
import models.University;
import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;

public class FullNameComparator implements UniversityComparator {
    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getFullName(), o2.getFullName());
    }
}
