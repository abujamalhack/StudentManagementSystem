package com.student.management.service;

import com.student.management.model.Student;
import java.util.*;

public class StudentService implements IStudentOperations {
    private List<Student> studentList;
    private Map<String, Student> studentMap;

    public StudentService() {
        studentList = new ArrayList<>();
        studentMap = new HashMap<>();
        // Preload dummy data
        addSampleData();
    }

    private void addSampleData() {
        addStudent(new Student("S001", "Alice Johnson", "alice@uni.edu", "CS", 3.8, 2));
        addStudent(new Student("S002", "Bob Smith", "bob@uni.edu", "IT", 3.2, 3));
        addStudent(new Student("S003", "Charlie Brown", "charlie@uni.edu", "CS", 3.9, 4));
    }

    @Override
    public boolean addStudent(Student s) {
        if (studentMap.containsKey(s.getId())) return false;
        studentList.add(s);
        studentMap.put(s.getId(), s);
        return true;
    }

    @Override
    public boolean updateStudent(String id, Student updated) {
        Student existing = studentMap.get(id);
        if (existing == null) return false;
        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        existing.setMajor(updated.getMajor());
        existing.setGpa(updated.getGpa());
        existing.setYear(updated.getYear());
        // For subclasses, additional fields handled separately but here simple demo
        return true;
    }

    @Override
    public boolean deleteStudent(String id) {
        Student removed = studentMap.remove(id);
        if (removed != null) {
            studentList.remove(removed);
            return true;
        }
        return false;
    }

    @Override
    public Student findStudentById(String id) {
        return studentMap.get(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(studentList);
    }

    @Override
    public Map<String, Student> getStudentMap() {
        return new HashMap<>(studentMap);
    }

    @Override
    public List<Student> searchByName(String keyword) {
        List<Student> result = new ArrayList<>();
        for (Student s : studentList) {
            if (s.getName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(s);
            }
        }
        return result;
    }

    @Override
    public List<Student> filterByMajor(String major) {
        List<Student> result = new ArrayList<>();
        for (Student s : studentList) {
            if (s.getMajor().equalsIgnoreCase(major)) {
                result.add(s);
            }
        }
        return result;
    }

    @Override
    public List<Student> sortByGpa() {
        List<Student> sorted = new ArrayList<>(studentList);
        sorted.sort((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa()));
        return sorted;
    }

    @Override
    public List<Student> sortByName() {
        List<Student> sorted = new ArrayList<>(studentList);
        sorted.sort(Comparator.comparing(Student::getName));
        return sorted;
    }
}
