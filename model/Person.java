package com.student.management.model;

public abstract class Person {
    private String id;
    private String name;
    private String email;

    public Person(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // Abstract method to enforce polymorphic behavior
    public abstract String getRole();

    @Override
    public String toString() {
        return String.format("%s [ID: %s, Name: %s, Email: %s]", getRole(), id, name, email);
    }
}
