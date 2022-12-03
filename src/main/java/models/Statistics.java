package models;

import profiles.StudyProfile;

public class Statistics {
    private StudyProfile mainProfile;
    private float avgExamScore;
    private int studentsCountByProfile;
    private int universitiesCountByProfile;
    private float avgExamScoreByUniversities;
    private float avgExamScoreByProfile;
    private int universityName;

    public Statistics(StudyProfile mainProfile, float avgExamScore, int studentsCountByProfile, int universitiesCountByProfile, float avgExamScoreByUniversities, float avgExamScoreByProfile, int universityName) {
        this.mainProfile = mainProfile;
        this.avgExamScore = avgExamScore;
        this.studentsCountByProfile = studentsCountByProfile;
        this.universitiesCountByProfile = universitiesCountByProfile;
        this.avgExamScoreByUniversities = avgExamScoreByUniversities;
        this.avgExamScoreByProfile = avgExamScoreByProfile;
        this.universityName = universityName;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public int getStudentsCountByProfile() {
        return studentsCountByProfile;
    }

    public void setStudentsCountByProfile(int studentsCountByProfile) {
        this.studentsCountByProfile = studentsCountByProfile;
    }

    public int getUniversitiesCountByProfile() {
        return universitiesCountByProfile;
    }

    public void setUniversitiesCountByProfile(int universitiesCountByProfile) {
        this.universitiesCountByProfile = universitiesCountByProfile;
    }

    public int getUniversityName() {
        return universityName;
    }

    public void setUniversityName(int universityName) {
        this.universityName = universityName;
    }

    public float getAvgExamScoreByUniversities() {
        return avgExamScoreByUniversities;
    }

    public void setAvgExamScoreByUniversities(float avgExamScoreByUniversities) {
        this.avgExamScoreByUniversities = avgExamScoreByUniversities;
    }

    public float getAvgExamScoreByProfile() {
        return avgExamScoreByProfile;
    }

    public void setAvgExamScoreByProfile(float avgExamScoreByProfile) {
        this.avgExamScoreByProfile = avgExamScoreByProfile;
    }
}
