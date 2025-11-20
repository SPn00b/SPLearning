package org.example.collection.map;

import java.util.Objects;

public class HashMapWithSizeCheckCustomHashCode {
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

    public HashMapWithSizeCheckCustomHashCode(String firstName, String lastName) {
        FirstName = firstName;
        LastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        HashMapWithSizeCheckCustomHashCode that = (HashMapWithSizeCheckCustomHashCode) o;
        return Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getLastName(), that.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName());
    }

    private String FirstName;
    private String LastName;
}
