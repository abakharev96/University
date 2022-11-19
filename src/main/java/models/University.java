package models;

import profiles.StudyProfile;

public class University {
    String id;
    String fullName;
    String shortName;
    int yearOfFoundation;
    StudyProfile mainProfile;
    String location;

    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainProfile, String location) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
        this.location = location;
    }

    public University() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "University full name: " + fullName + ";\n" +
                "University short name: " + shortName + ";\n" +
                "University id: " + id + ";\n" +
                "University year of foundation: " + yearOfFoundation + ";\n" +
                "University main profile: " + mainProfile + ";\n" +
                "University location: " + location + ".\n";
    }
}
