package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import models.Student;
import models.University;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

public class JsonUtil {
    private JsonUtil() {}
    private static final Gson gsonBuild = new GsonBuilder().setPrettyPrinting().create();
    private static final Gson gson = new Gson();
    private static final Type collectionStudent = new TypeToken<Collection<Student>>(){}.getType();
    private static final Type collectionUniversity = new TypeToken<Collection<University>>(){}.getType();

    public static String studentSerialize (Student student) {
        String studentSerialize = gsonBuild.toJson(student);
        return studentSerialize;
    }

    public static String universitySerialize (University university) {
        String universitySerialize = gsonBuild.toJson(university);
        return universitySerialize;
    }

    public static String studentListSerialize (ArrayList<Student> students) {
        String studentListSerialize = gsonBuild.toJson(students);
        return studentListSerialize;
    }

    public static String universityListSerialize (ArrayList<University> universities) {
        String universityListSerialize = gsonBuild.toJson(universities);
        return universityListSerialize;
    }

    public static Student studentDeserialize (String studentSerialized) {
        Student studentDeserialized = gson.fromJson(studentSerialized, Student.class);
        return studentDeserialized;
    }

    public static University universityDeserialize (String universitySerialized) {
        University universityDeserialized = gson.fromJson(universitySerialized, University.class);
        return universityDeserialized;
    }

    public static ArrayList<Student> studentListDeserialize (String studentListSerialized){
        ArrayList<Student> studentListDeserialized = gson.fromJson(studentListSerialized, collectionStudent);
        return studentListDeserialized;
    }

    public static ArrayList<University> universityListDeserialize (String universityListSerialized) {
        ArrayList<University> universityListDeserialized = gson.fromJson(universityListSerialized, collectionUniversity);
        return universityListDeserialized;
    }
}
