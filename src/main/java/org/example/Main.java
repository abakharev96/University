package org.example;

import models.Student;
import models.University;

import java.util.ArrayList;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    private static final Logger log = LogManager.getLogManager().getLogger(Main.class.getName());
    public static void main(String[] args) {
        ReadingXLSX.readXlsx("src/main/resources/universityInfo.xlsx");
        ArrayList<University> universities = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        universities = (ArrayList<University>) ReadingXLSX.universities.clone();
        students = (ArrayList<Student>) ReadingXLSX.students.clone();

        //let's display list of universities
        for (int i = 0; i < universities.size(); i++){
            System.out.println(universities.get(i));
        }

        //let's display list of students
        for(int i = 0; i < students.size(); i++){
            System.out.println(students.get(i));
        }


    }
}