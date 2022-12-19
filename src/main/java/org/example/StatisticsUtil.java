package org.example;


import models.Statistics;
import models.Student;
import models.University;
import profiles.StudyProfile;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class StatisticsUtil {
    private StatisticsUtil() {}
    public static ArrayList<Statistics> calculateStatistics(ArrayList<Student> students, ArrayList<University> universities){
        ArrayList<Statistics> statisticsArrayList = new ArrayList<>();
        Set<String> universitySet = universities.stream()
                .map(University::getFullName)
                .collect(Collectors.toSet());
        Set<String> studentSet = students.stream()
                .map(Student::getFullName)
                .collect(Collectors.toSet());

        universitySet.forEach(universityOfSet -> {
            Statistics statistics = new Statistics();
            statisticsArrayList.add(statistics);
            statistics.setUniversityName(universityOfSet);
            statistics.setMainProfile(findUniversityStudyProfile(universities, universityOfSet));
            statistics.setAvgExamScore(calculateAvgExamScore(students));
            statistics.setStudentsCountByProfile(calculateStudentsCountByProfile(universities, students,
                    statistics.getMainProfile()));
            statistics.setUniversitiesCountByProfile(calculateUniversitiesCountByProfile(universities,
                    statistics.getMainProfile()));
            statistics.setAvgExamScoreByUniversities(calculateAvgExamScoreByUniversities(universities, students,
                    universityOfSet));
            statistics.setAvgExamScoreByProfile(calculateAvgExamScoreByProfile(universities, students,
                    statistics.getMainProfile()));
        });

        return statisticsArrayList;
    }

    private static StudyProfile findUniversityStudyProfile (ArrayList<University> universities, String universityOfSet){
        StudyProfile currentStudyProfile = universities.stream()
                .filter(university -> university.getFullName().equals(universityOfSet))
                .findFirst()
                .get()
                .getMainProfile();
        return currentStudyProfile;
    }

    private static float calculateAvgExamScore (ArrayList<Student> students) {
        OptionalDouble avgExamScoreOD = students.stream()
                .mapToDouble(Student::getAvgExamScore)
                .average();
        avgExamScoreOD.ifPresent(value -> BigDecimal.valueOf(value).doubleValue());
        BigDecimal avgExamScoreBD = new BigDecimal(String.valueOf(avgExamScoreOD.getAsDouble()));
        avgExamScoreBD = avgExamScoreBD.setScale(2, RoundingMode.HALF_UP);
        float avgExamScore = avgExamScoreBD.floatValue();
        return avgExamScore;
    }

    private static int calculateStudentsCountByProfile(ArrayList<University> universities, ArrayList<Student> students,
                                                       StudyProfile studyProfile) {
        int count = 0;
        List<String> idsWithCurrentProfiles = universities.stream()
                .filter(university -> university.getMainProfile().equals(studyProfile))
                .map(University::getId)
                .collect(Collectors.toList());
        count = (int) students.stream()
                .filter(student -> idsWithCurrentProfiles.contains(student.getUniversityId()))
                .count();
        return count;
    }

    private static int calculateUniversitiesCountByProfile(ArrayList<University> universities,
                                                           StudyProfile studyProfile){
        int count = (int) universities.stream()
                .filter(university -> university.getMainProfile().equals(studyProfile))
                .count();
        return count;
    }

    private static float calculateAvgExamScoreByUniversities (ArrayList<University> universities,
                                                            ArrayList<Student> students, String universityOfSet) {
        Optional<String> idOfUniversity = universities.stream()
                .filter(university -> university.getFullName().equals(universityOfSet))
                .map(University::getId)
                .findFirst();
        String idOfUniversityS = idOfUniversity.get();

        OptionalDouble avgExamScoreOD = students.stream()
                .filter(student -> student.getUniversityId().equals(idOfUniversityS))
                .mapToDouble(Student::getAvgExamScore)
                .average();
        if (!avgExamScoreOD.isPresent()) {
            avgExamScoreOD = OptionalDouble.of(0);
        }
        BigDecimal avgExamScoreBD = BigDecimal.valueOf(avgExamScoreOD.getAsDouble());
        avgExamScoreBD = avgExamScoreBD.setScale(2, RoundingMode.HALF_UP);
        float avgExamScore = avgExamScoreBD.floatValue();

        return avgExamScore;
    }

    private static float calculateAvgExamScoreByProfile (ArrayList<University> universities,
                                                         ArrayList<Student> students, StudyProfile studyProfile){
        List<String> idsWithCurrentProfiles = universities.stream()
                .filter(university -> university.getMainProfile().equals(studyProfile))
                .map(University::getId)
                .collect(Collectors.toList());

        OptionalDouble avgExamScoreOD = students.stream()
                .filter(student -> idsWithCurrentProfiles.contains(student.getUniversityId()))
                .mapToDouble(Student::getAvgExamScore)
                .average();
        if (avgExamScoreOD.isEmpty()) {
            avgExamScoreOD = OptionalDouble.of(0);
        }
        avgExamScoreOD.ifPresent(value -> BigDecimal.valueOf(value).doubleValue());
        BigDecimal avgExamScoreBD = new BigDecimal(String.valueOf(avgExamScoreOD.getAsDouble()));
        avgExamScoreBD = avgExamScoreBD.setScale(2, RoundingMode.HALF_UP);

        return avgExamScoreBD.floatValue();
    }
}
