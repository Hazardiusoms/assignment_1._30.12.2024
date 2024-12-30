package models;

import java.util.ArrayList;

public class School {
    ArrayList<Person> members = new ArrayList<>();

    public void addMember(Person person) {
        members.add(person);
    }
    public ArrayList<Person> getMembers(){
        return members;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Person member : members) {
            sb.append(member.toString()).append("\n");
        }
        return sb.toString();
    }
}
