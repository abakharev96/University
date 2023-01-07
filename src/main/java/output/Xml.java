package output;

import models.Student;
import models.University;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Xml {
    private static final Logger log = Logger.getLogger(Xml.class.getName());

    public static void writeXml(ArrayList<Student> students, ArrayList<University> universities) {
        String timeStamp = new SimpleDateFormat("dd.MM.yyyy_HH.mm.ss").format(Calendar.getInstance().getTime());
        String fileNameUniversity = "src/main/resources/XML/Universities_" + timeStamp + ".xml";
        String fileNameStudents = "src/main/resources/XML/Students_" + timeStamp + ".xml ";

        writeStudentsXml(students, fileNameStudents);
        writeUniversityXml(universities, fileNameUniversity);
    }

    private static void writeStudentsXml(ArrayList<Student> students, String fileNameStudents) {
        Document doc = new Document();
        doc.setRootElement(new Element("Students", Namespace.getNamespace("Students")));
        for (Student student : students) {
            Element studentElement = new Element("Student", Namespace.getNamespace("Students"));
            studentElement.setAttribute("FullName", student.getFullName());
            studentElement.addContent(new Element("UniversityID", Namespace.getNamespace("Students")).setText(student.getUniversityId()));
            studentElement.addContent(new Element("CourseNumber", Namespace.getNamespace("Students")).setText(String.valueOf(student.getCurrentCourseNumber())));
            studentElement.addContent(new Element("AvgExamScore", Namespace.getNamespace("Students")).setText(String.valueOf(student.getAvgExamScore())));
            studentElement.addContent(new Element("RusCitizen", Namespace.getNamespace("Students")).setText(String.valueOf(student.isRusCitizen())));
            doc.getRootElement().addContent(studentElement);
        }

        XMLOutputter xmlOutputterStudents = new XMLOutputter(Format.getPrettyFormat());

        try {
            xmlOutputterStudents.output(doc, new FileOutputStream(fileNameStudents));
            log.log(Level.INFO, "Writing in XML students file was successful");
        } catch (IOException e) {
            log.log(Level.SEVERE, "Error in writing in XML students file", e);
            throw new RuntimeException(e);
        }
    }

    private static void writeUniversityXml(ArrayList<University> universities, String fileNameUniversity) {
        Document doc = new Document();
        doc.setRootElement(new Element("Universities", Namespace.getNamespace("Universities")));
        for (University university : universities) {
            Element universityElement = new Element("University", Namespace.getNamespace("Universities"));
            universityElement.setAttribute("UniversityID", university.getId());
            universityElement.addContent(new Element("FullName", Namespace.getNamespace("Universities")).setText(university.getFullName()));
            universityElement.addContent(new Element("ShortName", Namespace.getNamespace("Universities")).setText(university.getShortName()));
            universityElement.addContent(new Element("Location", Namespace.getNamespace("Universities")).setText(university.getLocation()));
            universityElement.addContent(new Element("MainProfile", Namespace.getNamespace("Universities")).setText(String.valueOf(university.getMainProfile())));
            universityElement.addContent(new Element("YearOfFoundation", Namespace.getNamespace("Universities")).setText(String.valueOf(university.getYearOfFoundation())));
            doc.getRootElement().addContent(universityElement);
        }

        XMLOutputter xmlOutputterUniversity = new XMLOutputter(Format.getPrettyFormat());

        try {
            xmlOutputterUniversity.output(doc, new FileOutputStream(fileNameUniversity));
            log.log(Level.INFO, "Writing in XML university file was successful");
        } catch (IOException e) {
            log.log(Level.SEVERE, "Error in writing in XML university file", e);
            throw new RuntimeException(e);
        }
    }
}
