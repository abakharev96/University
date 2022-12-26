package org.example;

import models.Student;
import models.University;
import profiles.StudyProfile;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ReadingXLSX {
    private ReadingXLSX() {}
    static ArrayList<University> universities = new ArrayList<>();
    static ArrayList<Student> students = new ArrayList<>();
    public static void readXlsx(String URL){
        try (FileInputStream file = new FileInputStream(new File(URL)); XSSFWorkbook universityInfo = new XSSFWorkbook(file)) {
            XSSFSheet sheetUniver = universityInfo.getSheet("Университеты");
            XSSFSheet sheetStudents = universityInfo.getSheet("Студенты");
            universityRead(sheetUniver);
            studentRead(sheetStudents);
            //System.out.println("The file was read successfully.");
        } catch (IOException e) {
            //System.out.println("The file was not read. Check link");
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<University> universityRead(XSSFSheet sheetUniver) {
        Iterator<Row> rows = sheetUniver.iterator();
        rows.next();
        while (rows.hasNext()){
            Row row = rows.next();
            University university = new University();
            university.setId(row.getCell(0).getStringCellValue());
            university.setFullName(row.getCell(1).getStringCellValue());
            university.setShortName(row.getCell(2).getStringCellValue());
            university.setYearOfFoundation((int) row.getCell(3).getNumericCellValue());
            university.setMainProfile(StudyProfile.valueOf(row.getCell(4).getStringCellValue()));
            university.setLocation(row.getCell(5).getStringCellValue());
            universities.add(university);
        }
        return universities;
    }

    public static ArrayList<Student> studentRead(XSSFSheet sheetStudent) {
        Iterator<Row> rows = sheetStudent.iterator();
        rows.next();
        while(rows.hasNext()){
            Row row = rows.next();
            Student student = new Student();
            student.setUniversityId(row.getCell(0).getStringCellValue());
            student.setFullName(row.getCell(1).getStringCellValue());
            student.setCurrentCourseNumber((int) row.getCell(2).getNumericCellValue());
            student.setAvgExamScore((float) row.getCell(3).getNumericCellValue());
            student.setRusCitizen(row.getCell(4).getBooleanCellValue());
            students.add(student);
        }
        return students;
    }

}
