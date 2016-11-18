package main.java.ua.edu.ucu;


import java.util.Objects;

public class Student {

    private double GPA;
    private int year;
    private String name;
    private String surname;

    public Student(String name, String surname, double GPA, int year) {
        this.GPA = GPA;
        this.year = year;
        this.name = name;
        this.surname = surname;
    }

    public double getGPA() {
        return GPA;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Student{name=" + name + ", surname=" + surname + ", " + "GPA=" + GPA + ", year=" + year + '}';
    }
    public boolean equals(Object student){
        return (student instanceof Student) && (Objects.equals(((Student)student).getSurname(), getSurname())) && (Objects.equals(((Student) student
        ).getName(), getName())) && (((Student)student).getGPA() == getGPA()) && (((Student)student).getYear() == getYear());}

}
