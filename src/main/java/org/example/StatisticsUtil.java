package org.example;


import models.Statistics;
import models.Student;
import models.University;
import org.apache.commons.lang3.StringUtils;
import profiles.StudyProfile;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StatisticsUtil {
    private StatisticsUtil() {}
    public static ArrayList<Statistics> calculateStatistics(ArrayList<Student> students, ArrayList<University> universities){
        ArrayList<Statistics> statisticsArrayList = new ArrayList<>();
        Set<String> universitySet = universities.stream()
                .map(University::getFullName)
                .collect(Collectors.toSet());
        Set<StudyProfile> studyProfiles = universities.stream()
                .map(University::getMainProfile)
                .collect(Collectors.toSet());
        System.out.println(studyProfiles.toString());
/*
        universities.stream()
                .forEach(university -> {
                    Statistics statistics = new Statistics();
                    statisticsArrayList.add(statistics);
                    statistics.setUniversityName(university.getFullName());
                    statistics.setMainProfile(university.getMainProfile());
                });*/
/*
        universities.forEach(university -> {
            Statistics statistics = new Statistics();
            statisticsArrayList.add(statistics);
            statistics.setUniversityName(university.getFullName());
            statistics.setMainProfile(university.getMainProfile());
        });*/
        universitySet.forEach(universityOfSet -> {
            Statistics statistics = new Statistics();
            statisticsArrayList.add(statistics);
            statistics.setUniversityName(universityOfSet);

            List<String> profileUniversityIds = universities.stream()
                    .filter(university -> university.getFullName().equals(universityOfSet))
                    .map(University::getId)
                    .collect(Collectors.toList());
            statistics.setUniversitiesCountByProfile(profileUniversityIds.size());
            statistics.setUniversityName(StringUtils.EMPTY);
            universities.stream()
                    .filter(university -> profileUniversityIds.contains(university.getFullName()))
                    .map(University::getMainProfile)
                    .forEach();

        });

        /*
        Set<StudyProfile> studyProfiles = universities.stream()
                .map(University :: getMainProfile)
                .collect(Collectors.toSet());

        studyProfiles.forEach(studyProfile -> {
            Statistics statistics = new Statistics();
            statisticsArrayList.add(statistics);
            statistics.setMainProfile(studyProfile);

            List<String> profileUniversityIds = universities.stream()
                    .filter(university -> university.getMainProfile().equals(studyProfile))
                    .map(University::getId)
                    .collect(Collectors.toList());
            statistics.setUniversitiesCountByProfile(profileUniversityIds.size());
            statistics.setUniversityName(StringUtils.EMPTY);
            universities.stream()
                    .filter(university -> profileUniversityIds.contains(university.getId()))
                    .map(University::getFullName)
                    .forEach(fullNameUniversity -> statistics.setUniversityName(
                            statistics.getUniversityName() + fullNameUniversity + ";"));
            List<Student> profileStudents = students.stream()
                    .filter(student -> profileUniversityIds.contains(student.getUniversityId()))
                    .collect(Collectors.toList());
            statistics.setStudentsCountByProfile(profileStudents.size());
            OptionalDouble avgExamScore = profileStudents.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average();
            statistics.setAvgExamScore(0);
            avgExamScore.ifPresent(value -> statistics.setAvgExamScore(
                    (float) BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue()));
        });
        */

        return statisticsArrayList;
    }
}
