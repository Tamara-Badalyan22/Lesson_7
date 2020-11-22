package model;

public class Student {
    private String firstName;
    private String lastName;
    private int year;
    private char gender;// f/m
    private double mark;

    public Student(String firstName, String lastName, int year, char gender, double mark) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
        this.gender = gender;
        this.mark = mark;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.isEmpty()) {
            System.out.println("Invalid name");
        } else {
            this.firstName = firstName;
        }

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.isEmpty()) {
            System.out.println("Invalid name");
        } else {
            this.lastName = lastName;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year <= 0) {
            System.out.println("Invalit year");
        } else {
            this.year = year;
        }
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        if (gender == 'f' || gender == 'm') {
            this.gender = gender;
        } else {
            System.out.println("Invalid gender");
        }

    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        if (mark < 0) {
            System.out.println("Invalid mark");
        } else {
            this.mark = mark;
        }
    }
}
