package profiles;

public enum StudyProfile {
    medicine("медицина"),
    maths("математика"),
    economic("экономика"),
    physics("физика"),
    computer_science("информатика"),
    chemistry("химия"),
    philosophy("философия"),
    physical_culture("физическая культура"),
    pedagogue("педагогика"),
    psychology("физика"),
    geographic("физика"),
    linguistics("лингвистика");

    public String getProfileName() {
        return profileName;
    }

    private final String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }
}
