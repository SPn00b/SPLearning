package org.example.collection.map;

public class HashMapWithSizeCheck {
    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public HashMapWithSizeCheck(String firstName, String lastName) {
        FirstName = firstName;
        LastName = lastName;
    }

    private String FirstName;
    private String LastName;
}
