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
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadingXLSX {
    private static final Logger log = Logger.getLogger(ReadingXLSX.class.getName());
    private ReadingXLSX() {}
    static ArrayList<University> universities = new ArrayList<>();
    static ArrayList<Student> students = new ArrayList<>();
    public static void readXlsx(String URL){
        try (FileInputStream file = new FileInputStream(new File(URL)); XSSFWorkbook universityInfo = new XSSFWorkbook(file)) {
            log.log(Level.ALL, "Trying to read excel file..." );
            XSSFSheet sheetUniver = universityInfo.getSheet("Университеты");
            XSSFSheet sheetStudents = universityInfo.getSheet("Студенты");
            universityRead(sheetUniver);
            studentRead(sheetStudents);
            //System.out.println("The file was read successfully.");
            log.log(Level.INFO, "Excel file was read successfully");
        } catch (IOException e) {
            //System.out.println("The file was not read. Check link");
            log.log(Level.SEVERE, "Excel file reading was failed", e);
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
        log.log(Level.ALL, "Universities list was created successfully.");
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
        log.log(Level.ALL, "Students list was created successfully.");
        return students;
    }

}
