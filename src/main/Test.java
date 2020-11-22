package main;

import model.Student;
import service.StudentService;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("Enter filePath : ");
        Scanner s=new Scanner(System.in);
        String filePath=s.next();
        Student[] students=StudentService.readStudentsFromFile(filePath);
        if(students!=null){
            StudentService.printInfoAllStudents(students);

            StudentService.printFullNames(students);//Task1:Print full names of students
            StudentService.maleStudents(students);//Task2:Print all male students
            StudentService.markGreaterThenFifty(students);//Task3:Print all female students who has mark greater then 50.4
            StudentService.studentsWithMinMark(students);//Task4:Print student information having the minimal mark
            StudentService.biggestMaleStudentInfo(students);//Task5:Print biggest male student information
            StudentService.sortedByMark(students);//Task6:Print students sorted by mark
            StudentService.sortedByYear(students);//Task7:Print female students sorted by year
        }
    }
}
