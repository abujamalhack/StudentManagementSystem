package com.student.management.controller;

import com.student.management.model.Student;
import com.student.management.service.StudentService;
import java.util.List;

public class StudentController {
    private StudentService service;

    public StudentController() {
        service = new StudentService();
    }

    public boolean addStudent(Student s) {
        return service.addStudent(s);
    }

    public boolean updateStudent(String id, Student updated) {
        return service.updateStudent(id, updated);
    }

    public boolean deleteStudent(String id) {
        return service.deleteStudent(id);
    }

    public Student findStudentById(String id) {
        return service.findStudentById(id);
    }

    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    public List<Student> searchByName(String keyword) {
        return service.searchByName(keyword);
    }

    public List<Student> filterByMajor(String major) {
        return service.filterByMajor(major);
    }

    public List<Student> sortByGpa() {
        return service.sortByGpa();
    }

    public List<Student> sortByName() {
        return service.sortByName();
    }
}
