package org.example;

import comparator.ComparatorUtility;
import comparator.UniversityComparator;
import comparator.enums.StudentComparatorsEnum;
import comparator.StudentComparator;
import comparator.enums.UniversityComparatorsEnum;

import java.util.Scanner;

import static org.example.ReadingXLSX.students;
import static org.example.ReadingXLSX.universities;

public class Main {
    static String userChoice;
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Instruction.\n" +
                "You will be prompted to choose between some options of the University base. \n" +
                "Please, follow the next instructions.");
        System.out.println("");
        MainMenu();
    }

    public static void MainMenu() {
        System.out.println("Which block do you want to present? Student or University? \n" +
                "Please, press 1 for University base and 2 for Student base. \n" +
                "To stop the program, press 999.");
        System.out.println("");
        System.out.print("Your option is: ");
        while (userChoice != "999") {
            userChoice = scan.next();
            switch (userChoice) {
                case "1" -> {
                    System.out.println("You selected University base.");
                    ReadingXLSX.readXlsx("src/main/resources/universityInfo.xlsx");
                    PresentUniversities();
                }
                case "2" -> {
                    System.out.println("You selected Student base.");
                    ReadingXLSX.readXlsx("src/main/resources/universityInfo.xlsx");
                    PresentStudents();
                }
                case "999" -> {
                    System.exit(0);
                }
                default -> {
                    System.out.println("There is no such options. Please, check input.");
                }
            }
        }
        System.out.println("");
    }

    public static void PresentUniversities() {
        System.out.println("Please choose from these filter variants. Press the number of an option: \n" +
                "0. Present universities without any filter;\n" +
                "1. University ID;\n" +
                "2. University full name;\n" +
                "3. University short name;\n" +
                "4. University year of foundation;\n" +
                "5. University main profile;\n" +
                "6. University location;\n" +
                "000. Back to main menu;\n" +
                "999. Stop the program.");
        UniversityComparator universityComparator;
        while (userChoice != "999") {
            System.out.print("Your option is: ");
            userChoice = scan.next();
            switch (userChoice) {
                case "0" -> {
                    universityComparator = ComparatorUtility.universityComparator(UniversityComparatorsEnum.CLEAR);
                    universities.stream()
                            .sorted(universityComparator)
                            .forEach(System.out::println);
                }
                case "1" -> {
                    universityComparator = ComparatorUtility.universityComparator(UniversityComparatorsEnum.UNIVERSITY_ID);
                    universities.stream()
                            .sorted(universityComparator)
                            .forEach(System.out::println);
                }
                case "2" -> {
                    universityComparator = ComparatorUtility.universityComparator(UniversityComparatorsEnum.UNIVERSITY_FULL_NAME);
                    universities.stream()
                            .sorted(universityComparator)
                            .forEach(System.out::println);
                }
                case "3" -> {
                    universityComparator = ComparatorUtility.universityComparator(UniversityComparatorsEnum.UNIVERSITY_SHORT_NAME);
                    universities.stream()
                            .sorted(universityComparator)
                            .forEach(System.out::println);
                }
                case "4" -> {
                    universityComparator = ComparatorUtility.universityComparator(UniversityComparatorsEnum.UNIVERSITY_YEAR_OF_FOUNDATION);
                    universities.stream()
                            .sorted(universityComparator)
                            .forEach(System.out::println);
                }
                case "5" -> {
                    universityComparator = ComparatorUtility.universityComparator(UniversityComparatorsEnum.UNIVERSITY_MAIN_PROFILE);
                    universities.stream()
                            .sorted(universityComparator)
                            .forEach(System.out::println);
                }
                case "6" -> {
                    universityComparator = ComparatorUtility.universityComparator(UniversityComparatorsEnum.UNIVERSITY_LOCATION);
                    universities.stream()
                            .sorted(universityComparator)
                            .forEach(System.out::println);
                }
                case "000" -> MainMenu();
                case "999" -> System.exit(0);
                default -> System.out.println("There is no such options. Please, check input.");
            }
            System.out.println("Do you want to proceed with University base?\n" +
                    "Press 1 to proceed, press 000 back in main menu");
            userChoice = scan.next();
            if (userChoice.equals("1")) {
                System.out.println("Ok, let's choose another filter option.");
            } else if (userChoice.equals("000")) {
                System.out.println("You are in the Main menu. Press 1 to choose University base or 2 to choose" +
                        "Student base.");
                break;
            } else {
                System.out.println("There is no such options. Please, check input.");
            }
        }
    }

    public static void PresentStudents() {
        System.out.println("Please choose from these filter variants. Press the number of an option: \n" +
                "0. Present students without any filter;\n" +
                "1. University ID;\n" +
                "2. Student full name;\n" +
                "3. Student current course; \n" +
                "4. Student average exam score;\n" +
                "5. Is student russian resident;\n" +
                "000. Back to main menu;\n" +
                "999. Stop the program.");
        StudentComparator studentComparator;
        while (userChoice != "999") {
            System.out.print("Your option is: ");
            userChoice = scan.next();
            switch (userChoice) {
                case "0" -> {
                    studentComparator = ComparatorUtility.studentComparator(StudentComparatorsEnum.CLEAR);
                    students.stream()
                            .sorted(studentComparator)
                            .forEach(System.out::println);
                }
                case "1" -> {
                    studentComparator = ComparatorUtility.studentComparator(StudentComparatorsEnum.STUDENT_ID_OF_UNIVERSITY);
                    students.stream()
                            .sorted(studentComparator)
                            .forEach(System.out::println);
                }
                case "2" -> {
                    studentComparator = ComparatorUtility.studentComparator(StudentComparatorsEnum.STUDENT_FULL_NAME);
                    students.stream()
                            .sorted(studentComparator)
                            .forEach(System.out::println);
                }
                case "3" -> {
                    studentComparator = ComparatorUtility.studentComparator(StudentComparatorsEnum.STUDENT_CURRENT_COURSE);
                    students.stream()
                            .sorted(studentComparator)
                            .forEach(System.out::println);
                }
                case "4" -> {
                    studentComparator = ComparatorUtility.studentComparator(StudentComparatorsEnum.STUDENT_AVG_EXAM_SCORE);
                    students.stream()
                            .sorted(studentComparator)
                            .forEach(System.out::println);
                }
                case "5" -> {
                    studentComparator = ComparatorUtility.studentComparator(StudentComparatorsEnum.STUDENT_RUS_RESIDENCE);
                    students.stream()
                            .sorted(studentComparator)
                            .forEach(System.out::println);
                }
                case "000" -> MainMenu();
                case "999" -> System.exit(0);
                default -> System.out.println("There is no such options. Please, check input.");
            }
            System.out.println("Do you want to proceed with University base?\n" +
                    "Press 1 to proceed, press 000 back in main menu");
            userChoice = scan.next();
            if (userChoice.equals("1")) {
                System.out.println("Ok, let's choose another filter option.");
            } else if (userChoice.equals("000")) {
                System.out.println("You are in the Main menu. Press 1 to choose University base or 2 to choose" +
                        "Student base.");
                break;
            } else {
                System.out.println("There is no such options. Please, check input.");
            }
        }
    }
}