import models.Person;
import models.Student;
import models.Teacher;
import models.School;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        try {
            School school = new School();
            File studentFile = new File("src/students.txt");
            Scanner studentScanner = new Scanner(studentFile);

            while (studentScanner.hasNext()) {
                String name = studentScanner.next();
                String surname = studentScanner.next();
                int age = studentScanner.nextInt();
                String gender = studentScanner.next();
                Student student = new Student(name, surname, age, gender);

                while (studentScanner.hasNextInt()) {
                    student.addGrade(studentScanner.nextInt());
                }

                school.addMember(student);
            }
            studentScanner.close();


            File teacherFile = new File("src/teachers.txt");
            Scanner teacherScanner = new Scanner(teacherFile);

            while (teacherScanner.hasNext()) {
                String name = teacherScanner.next();
                String surname = teacherScanner.next();
                int age = teacherScanner.nextInt();
                String gender = teacherScanner.next();
                String subject = teacherScanner.next();
                int yearsOfExperience = teacherScanner.nextInt();
                int salary = teacherScanner.nextInt();

                Teacher teacher = new Teacher(name, surname, age, gender, subject, yearsOfExperience, salary);
                if (yearsOfExperience > 10) {
                    teacher.giveRaise(10); // 10% raise
                }
                school.addMember(teacher);
            }
            teacherScanner.close();

            System.out.println("School Members:");
            System.out.println(school);

            System.out.println("\nTesting Specific Methods:");
            System.out.println("GPA:");
            for (Person member : school.getMembers()) {
                if (member instanceof Student) {
                    Student student = (Student) member;
                    System.out.println(student.getName() + " " + student.getSurname() +
                            "'s GPA: " + student.calculateGPA());
                }
            }
            System.out.println("\nRaised salaries:");
            for (Person member : school.getMembers()) {
                if (member instanceof Teacher) {
                    Teacher teacher = (Teacher) member;
                    System.out.println(teacher.getName() + " " + teacher.getSurname() +
                            "'s Salary: " + teacher.getSalary());
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(" " + e.getMessage());
        } catch (Exception e) {
            System.err.println(" " + e.getMessage());
        }
    }
}
