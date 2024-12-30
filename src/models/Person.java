package models;

public class Person {
    private String name;
    private String surname;
    private int age;
    private boolean gender;

    // Constructor
    public Person(String name, String surname, int age, String gender) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender.equalsIgnoreCase("Male");
    }
    public String getName() {
        return name;
    }


    public String getSurname() {
        return surname;
    }
    @Override
    public String toString() {
        return "Name: " + name + " " + surname +
                ", Age: " + age +
                ", Gender: " + (gender ? "Male" : "Female");
    }
}
