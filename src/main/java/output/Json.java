package output;

import comparator.ComparatorUtility;
import comparator.StudentComparator;
import comparator.UniversityComparator;
import comparator.enums.StudentComparatorsEnum;
import comparator.enums.UniversityComparatorsEnum;
import models.Student;
import models.University;
import org.example.JsonUtil;

import java.util.ArrayList;

public class Json {
    public static void createJson(ArrayList<Student> students, ArrayList<University> universities){
        StudentComparator studentComparator = ComparatorUtility.studentComparator(StudentComparatorsEnum.STUDENT_AVG_EXAM_SCORE);
        students.sort(studentComparator);
        students.sort(studentComparator);
        String studentSerializedJson = JsonUtil.studentListSerialize(students);
        //System.out.println(studentSerializedJson);
        ArrayList<Student> studentListFromJson = JsonUtil.studentListDeserialize(studentSerializedJson);
        students.forEach(student -> {
            String studentSerialized = JsonUtil.studentSerialize(student);
            //System.out.println(studentSerialized);
            Student studentDeserialize = JsonUtil.studentDeserialize(studentSerialized);
            //System.out.println(studentDeserialize);
        });
        UniversityComparator universityComparator = ComparatorUtility.universityComparator(UniversityComparatorsEnum.UNIVERSITY_YEAR_OF_FOUNDATION);
        universities.sort(universityComparator);
        String universitySerializedJson = JsonUtil.universityListSerialize(universities);
        //System.out.println(universitySerializedJson);
        ArrayList<University> universityListFromJson = JsonUtil.universityListDeserialize(universitySerializedJson);
        //System.out.println(universityListFromJson.size() == universities.size());
        universities.forEach(university -> {
            String universitySerialized = JsonUtil.universitySerialize(university);
            //System.out.println(universitySerialized);
            University universityDeserialized = JsonUtil.universityDeserialize(universitySerialized);
            //System.out.println(universityDeserialized);
        });
    }
}
