package com.student.management.ui;

import com.student.management.model.Student;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class StudentTableModel extends AbstractTableModel {
    private List<Student> students;
    private final String[] columns = {"ID", "Name", "Email", "Major", "GPA", "Year"};

    public StudentTableModel(List<Student> students) {
        this.students = students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() { return students.size(); }

    @Override
    public int getColumnCount() { return columns.length; }

    @Override
    public String getColumnName(int col) { return columns[col]; }

    @Override
    public Object getValueAt(int row, int col) {
        Student s = students.get(row);
        switch (col) {
            case 0: return s.getId();
            case 1: return s.getName();
            case 2: return s.getEmail();
            case 3: return s.getMajor();
            case 4: return s.getGpa();
            case 5: return s.getYear();
            default: return "";
        }
    }
}
