package com.student.management.model;

public class UndergradStudent extends Student {
    private String finalYearProject;

    public UndergradStudent(String id, String name, String email, String major, double gpa, int year, String finalYearProject) {
        super(id, name, email, major, gpa, year);
        this.finalYearProject = finalYearProject;
    }

    public String getFinalYearProject() { return finalYearProject; }
    public void setFinalYearProject(String finalYearProject) { this.finalYearProject = finalYearProject; }

    @Override
    public String getStudentType() {
        return "Undergraduate";
    }

    @Override
    public String toString() {
        return super.toString() + ", Project: " + finalYearProject;
    }
}
