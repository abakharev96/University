package models;

import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Student")
@XmlAccessorType(XmlAccessType.FIELD)

public class Student {
    //private String fullName;
    //private String universityId;
    //private int currentCourseNumber;
    //private float avgExamScore;
    //private boolean isRusCitizen;
    @XmlElement(name = "Student name")
    @SerializedName("Student name") private String fullName;
    @XmlElement(name = "Student university id")
    @SerializedName("Student university id") private String universityId;
    @XmlElement(name = "Student current course number")
    @SerializedName("Student current course number") private int currentCourseNumber;
    @XmlElement(name = "Student average exam score")
    @SerializedName("Student average exam score") private float avgExamScore;
    @SerializedName("Russian residence of student") private boolean isRusCitizen;
    public Student(String fullName, String universityId, int currentCourseNumber, float avgExamScore, boolean isRusCitizen, String fullname) {
        this.fullName = fullname;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
        this.isRusCitizen = isRusCitizen;
    }

    public Student() {}

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullname) {
        this.fullName = fullname;
    }

    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public void setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public boolean isRusCitizen() {
        return isRusCitizen;
    }

    public void setRusCitizen(boolean rusCitizen) {
        isRusCitizen = rusCitizen;
    }

    @Override
    public String toString() {
        return "Student name: " + fullName + ";\n" +
                "Student university id: " + universityId + ";\n" +
                "Student current course number: " + currentCourseNumber + ";\n" +
                "Student average exam score: " + avgExamScore + ";\n" +
                "Russian residence of students: " + isRusCitizen + ".\n";
    }




}
