package com.student.management.service;

import com.student.management.model.Student;
import java.util.List;
import java.util.Map;

public interface IStudentOperations {
    boolean addStudent(Student s);
    boolean updateStudent(String id, Student updated);
    boolean deleteStudent(String id);
    Student findStudentById(String id);
    List<Student> getAllStudents();
    Map<String, Student> getStudentMap();
    List<Student> searchByName(String keyword);
    List<Student> filterByMajor(String major);
    List<Student> sortByGpa();
    List<Student> sortByName();
}
