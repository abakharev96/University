package comparator.university;

import comparator.UniversityComparator;
import models.University;
import org.apache.commons.lang3.StringUtils;

public class ProfileComparator implements UniversityComparator {
    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(String.valueOf(o1.getMainProfile()), (String.valueOf(o2.getMainProfile())));
    }
}
