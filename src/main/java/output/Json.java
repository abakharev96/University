package output;

import comparator.ComparatorUtility;
import comparator.StudentComparator;
import comparator.UniversityComparator;
import comparator.enums.StudentComparatorsEnum;
import comparator.enums.UniversityComparatorsEnum;
import models.Student;
import models.University;
import org.example.JsonUtil;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Json {
    private static final Logger log = Logger.getLogger(Json.class.getName());

    public static void writeJson(ArrayList<Student> students, ArrayList<University> universities) {
        String timeStamp = new SimpleDateFormat("dd.MM.yyyy_HH.mm.ss").format(Calendar.getInstance().getTime());
        String fileNameUniversities = "src/main/resources/JSON/Universities_" + timeStamp + ".json";
        String fileNameStudents = "src/main/resources/JSON/Students_" + timeStamp + ".json";

        writeStudentsJson(students, fileNameStudents);
        writeUniversitiesJson(universities, fileNameUniversities);
    }

    private static void writeStudentsJson(ArrayList<Student> students, String fileNameStudents) {
        StudentComparator studentComparator = ComparatorUtility.studentComparator(StudentComparatorsEnum.STUDENT_AVG_EXAM_SCORE);
        students.sort(studentComparator);
        String studentSerializedJson = JsonUtil.studentListSerialize(students);
        try {
            FileOutputStream osStudents = new FileOutputStream(fileNameStudents);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(osStudents));
            bufferedWriter.append(studentSerializedJson);
            bufferedWriter.close();
            log.log(Level.INFO, "Writing in JSON students file was successful");
        } catch (IOException e) {
            log.log(Level.SEVERE, "Error in writing in JSON students file", e);
            throw new RuntimeException(e);
        }
        /*System.out.println(studentSerializedJson);
        ArrayList<Student> studentListFromJson = JsonUtil.studentListDeserialize(studentSerializedJson);
        students.forEach(student -> {
            String studentSerialized = JsonUtil.studentSerialize(student);
            //System.out.println(studentSerialized);
            Student studentDeserialize = JsonUtil.studentDeserialize(studentSerialized);
            //System.out.println(studentDeserialize);
        });*/
    }

    private static void writeUniversitiesJson(ArrayList<University> universities, String fileNameUniversities) {
        UniversityComparator universityComparator = ComparatorUtility.universityComparator(UniversityComparatorsEnum.UNIVERSITY_YEAR_OF_FOUNDATION);
        universities.sort(universityComparator);
        String universitySerializedJson = JsonUtil.universityListSerialize(universities);
        try {
            FileOutputStream osUniversities = new FileOutputStream(fileNameUniversities);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(osUniversities));
            bufferedWriter.append(universitySerializedJson);
            bufferedWriter.close();
            log.log(Level.INFO, "Writing in JSON universities file was successful");
        } catch (IOException e) {
            log.log(Level.SEVERE, "Error in writing in JSON universities file", e);
            throw new RuntimeException(e);
        }
        /*System.out.println(universitySerializedJson);
        ArrayList<University> universityListFromJson = JsonUtil.universityListDeserialize(universitySerializedJson);
        //System.out.println(universityListFromJson.size() == universities.size());
        universities.forEach(university -> {
            String universitySerialized = JsonUtil.universitySerialize(university);
            //System.out.println(universitySerialized);
            University universityDeserialized = JsonUtil.universityDeserialize(universitySerialized);
            //System.out.println(universityDeserialized);
        });*/
    }
}
