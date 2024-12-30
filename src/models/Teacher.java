package models;

public class Teacher extends Person {
    private String subject;
    private int yearsOfExperience;
    private int salary;

    public Teacher(String name, String surname, int age, String gender,
                   String subject, int yearsOfExperience, int salary) {
        super(name, surname, age, gender);
        this.subject = subject;
        this.yearsOfExperience = yearsOfExperience;
        this.salary = salary;
    }

    public void giveRaise(int percent) {
        this.salary = (percent + 100) / 100;
    }
    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() + "I teach " + subject + ".";
    }
}
