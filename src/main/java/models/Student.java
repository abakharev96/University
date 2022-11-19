package models;

public class Student {
    String fullName;
    String universityId;
    int currentCourseNumber;
    float avgExamScore;
    boolean isRusCitizen;

    public Student(String fullName, String universityId, int currentCourseNumber, float avgExamScore, boolean isRusCitizen) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
        this.isRusCitizen = isRusCitizen;
    }

    public Student() {

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
