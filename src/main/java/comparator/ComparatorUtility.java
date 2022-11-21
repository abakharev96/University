package comparator;

import comparator.enums.StudentComparatorsEnum;
import comparator.enums.UniversityComparatorsEnum;
import comparator.student.*;
import comparator.student.FullNameComparator;
import comparator.university.IdComparator;
import comparator.university.*;

public class ComparatorUtility {
    private ComparatorUtility() {};

    public static StudentComparator studentComparator (StudentComparatorsEnum studentComparatorsEnum) {
        switch (studentComparatorsEnum) {
            case STUDENT_ID_OF_UNIVERSITY -> {
                return new UniversityIdComparator();
            }
            case STUDENT_FULL_NAME -> {
                return new FullNameComparator();
            }
            case STUDENT_CURRENT_COURSE -> {
                return new CurrentCourseComparator();
            }
            case STUDENT_AVG_EXAM_SCORE -> {
                return new AvgExamScoreComparator();
            }
            case STUDENT_RUS_RESIDENCE -> {
                return new ResidenceComparator();
            }
            default -> {
                return new StudentClearFilter();
            }
        }
    }

    public static UniversityComparator universityComparator (UniversityComparatorsEnum universityComparatorsEnum) {
        switch (universityComparatorsEnum) {
            case UNIVERSITY_ID -> {
                return new IdComparator();
            }
            case UNIVERSITY_FULL_NAME -> {
                return new comparator.university.FullNameComparator();
            }
            case UNIVERSITY_SHORT_NAME -> {
                return new ShortNameComparator();
            }
            case UNIVERSITY_YEAR_OF_FOUNDATION -> {
                return new YearOfFoundationComparator();
            }
            case UNIVERSITY_MAIN_PROFILE -> {
                return new ProfileComparator();
            }
            case UNIVERSITY_LOCATION -> {
                return new LocationComparator();
            }
            default -> {
                return new UniversityClearFilter();
            }
        }
    }
}
