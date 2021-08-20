package edu.school21.program.models;

import edu.school21.program.PrivateClass;

public class User implements PrivateClass {
    private String firstName;
    private String lastName;
    private Integer height;

    public User() {}

    public User(String firstName, String lastName, Integer height) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.height = height;
    }

    @Override
    public int increment(int i) {
        height += i;
        return height;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", height=" + height +
                '}';
    }


}
