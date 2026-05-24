package com.student.management.model;

public class GraduateStudent extends Student {
    private String thesisTitle;
    private String supervisor;

    public GraduateStudent(String id, String name, String email, String major, double gpa, int year, String thesisTitle, String supervisor) {
        super(id, name, email, major, gpa, year);
        this.thesisTitle = thesisTitle;
        this.supervisor = supervisor;
    }

    public String getThesisTitle() { return thesisTitle; }
    public void setThesisTitle(String thesisTitle) { this.thesisTitle = thesisTitle; }
    public String getSupervisor() { return supervisor; }
    public void setSupervisor(String supervisor) { this.supervisor = supervisor; }

    @Override
    public String getStudentType() {
        return "Graduate";
    }

    @Override
    public String toString() {
        return super.toString() + ", Thesis: " + thesisTitle + ", Supervisor: " + supervisor;
    }
}
