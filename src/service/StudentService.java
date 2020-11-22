package service;

import model.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService {
    public static Student createStudent() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter this fields about student");
        System.out.println("FirstName : ");
        String firstName = s.next();
        System.out.println("LastName : ");
        String lastName = s.next();
        System.out.println("BirthDate : ");
        int date = s.nextInt();
        System.out.println("Gender : ");
        char gender = s.next().charAt(0);
        System.out.println("Mark : ");
        double mark = s.nextDouble();
        return new Student(firstName, lastName, date, gender, mark);
    }

    public static void printInfoStudent(Student student) {
        System.out.println("----Information about student----");
        System.out.println("FirstName : " + student.getFirstName());
        System.out.println("LastName :" + student.getLastName());
        System.out.println("Year : " + student.getYear());
        System.out.println("Gender : " + student.getGender());
        System.out.println("Mark " + student.getMark());
        System.out.println("---------------------------------");
    }

    public static void printInfoAllStudents(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            System.out.println("---" + (i + 1) + "---");
            printInfoStudent(students[i]);
        }
    }

    public static Student[] readStudentsFromFile(String filePath) {
        List<Student> students = new ArrayList<Student>();
        Student[] result = null;
        File file = new File(filePath);
        String s;
        Scanner sc = null;
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                s = sc.nextLine();
                String[] arr = s.split(",");
                students.add(new Student(arr[0], arr[1], Integer.parseInt(arr[2]), arr[3].charAt(0), Double.parseDouble(arr[4])));
                result = students.toArray(new Student[students.size()]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("ErrorMessage : " + e.getMessage());
        }
        return result;
    }

    //    Task 1: Print full names of students
    public static void printFullNames(Student[] students) {
        System.out.println("******* Full names pf students ********");
        for (int i = 0; i < students.length; i++)
            System.out.println((i + 1) + ". FullName : " + students[i].getFirstName() + " " + students[i].getLastName());
        System.out.println("****************************************");
    }

    //    Task 2: Print all male students
    public static void maleStudents(Student[] students) {
        System.out.println("******* All Male students ********");
        for (int i = 0; i < students.length; i++) {
            if (students[i].getGender() == 'm') {
                System.out.println("---" + (i + 1) + "---");
                printInfoStudent(students[i]);
            }
        }
        System.out.println("****************************************");
    }

    //    Task 3: Print all female students who has mark greater then 50.4
    public static void markGreaterThenFifty(Student[] students) {
        System.out.println("******* All female students who has mark greater then 50.4 ********");
        for (int i = 0; i < students.length; i++) {
            if (students[i].getGender() == 'm' && students[i].getMark() > 50.4) {
                System.out.println("---" + (i + 1) + "---");
                printInfoStudent(students[i]);
            }
        }
        System.out.println("****************************************");
    }

    //    Task 4: Print student information having the minimal mark
    public static void studentsWithMinMark(Student[] students) {
        System.out.println("******* Student information having the minimal mark ********");

        double minMark = students[0].getMark();
        for (int i = 1; i < students.length; i++) {
            if (students[i].getMark() < minMark) {
                minMark = students[i].getMark();
            }
        }
        for (int i = 0; i < students.length; i++) {
            if (students[i].getMark() == minMark) {
                System.out.println("---" + (i + 1) + "---");
                printInfoStudent(students[i]);
            }
        }
        System.out.println("****************************************");
    }

    //Task 5: Print biggest male student information
    public static void biggestMaleStudentInfo(Student[] students) {
        System.out.println("******* Biggest male student information ********");
        int maxYear = 0, i = 0;
        Student biggestMaleStudent = null;
        for (; i < students.length; i++) {
            if (students[i].getGender() == 'm') {
                maxYear = students[i].getYear();
                biggestMaleStudent = students[i];
                break;
            }
        }
        for (; i < students.length; i++) {
            if (students[i].getYear() < maxYear) {
                maxYear = students[i].getYear();
                biggestMaleStudent = students[i];
            }
        }
        if (maxYear != 0) {
            System.out.println("Biggest male student->");
            printInfoStudent(biggestMaleStudent);
        } else {
            System.out.println("There's no male student in this group");
        }
        System.out.println("****************************************");
    }

    //    Task 6: Print students sorted by mark
    public static void sortedByMark(Student[] students) {
        System.out.println("******* Students sorted by mark ********");
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - 1 - i; j++) {
                if (students[j].getMark() > students[j + 1].getMark()) {
                    Student tmp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = tmp;
                }
            }
        }
        printInfoAllStudents(students);
        System.out.println("****************************************");
    }

    //    Task 7: Print female students sorted by year
    public static void sortedByYear(Student[] students) {
        System.out.println("******* Students sorted by year ********");
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - 1 - i; j++) {
                if (students[j].getYear() > students[j + 1].getYear()) {
                    Student tmp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = tmp;
                }
            }
        }
        printInfoAllStudents(students);
        System.out.println("****************************************");
    }
}

