package com.student.management.model;

public class Student extends Person {
    private String major;
    private double gpa;
    private int year;

    public Student(String id, String name, String email, String major, double gpa, int year) {
        super(id, name, email);
        this.major = major;
        this.gpa = gpa;
        this.year = year;
    }

    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }
    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    @Override
    public String getRole() {
        return "Student";
    }

    // Polymorphic method (can be overridden by subclasses)
    public String getStudentType() {
        return "General Student";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Major: %s, GPA: %.2f, Year: %d", major, gpa, year);
    }
}
