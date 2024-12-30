package models;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private int id;
    private List<Integer> grades;
    private static int counter = 1000;
    public Student(String name, String surname, int age, String gender) {
        super(name, surname, age, gender);
        this.id = counter++;
        this.grades = new ArrayList<>();
    }

    public void addGrade(int grade) {
        if (grade >=0 && grade <= 100) {
            grades.add(grade);
        } else {
            System.out.println("Invalid grade");
        }
    }

    public double calculateGPA(){
        double sumGPA = 0;
        for (Integer grade : grades) {
            sumGPA += convertGradeToGPA(grade);
        }

        return sumGPA / grades.size();
    }

    private static double convertGradeToGPA(int grade) {
        if (grade >= 95) return 4.0;
        if (grade >= 90) return 3.67;


        return 0;
    }
    @Override
    public String toString() {
        return "I am student with student ID" + id;
    }
    public static void main(String[] args) {

    }

}
