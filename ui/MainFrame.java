package com.student.management.ui;

import com.student.management.controller.StudentController;
import com.student.management.model.Student;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class MainFrame extends JFrame {
    private StudentController controller;
    private JTable studentTable;
    private StudentTableModel tableModel;
    private JTextField searchField;
    private JComboBox<String> filterCombo;

    public MainFrame() {
        controller = new StudentController();
        setTitle("Student Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        initUI();
        refreshTable();
    }

    private void initUI() {
        setLayout(new BorderLayout(10,10));
        ((JComponent) getContentPane()).setBorder(new EmptyBorder(10,10,10,10));

        // Top panel with buttons
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton addBtn = new JButton("Add Student");
        JButton editBtn = new JButton("Edit Student");
        JButton deleteBtn = new JButton("Delete Student");
        JButton refreshBtn = new JButton("Refresh");
        topPanel.add(addBtn);
        topPanel.add(editBtn);
        topPanel.add(deleteBtn);
        topPanel.add(refreshBtn);
        add(topPanel, BorderLayout.NORTH);

        // Center: Table
        tableModel = new StudentTableModel(List.of());
        studentTable = new JTable(tableModel);
        studentTable.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(studentTable);
        add(scrollPane, BorderLayout.CENTER);

        // Bottom: Search & Filter
        JPanel bottomPanel = new JPanel(new GridLayout(2,1,5,5));
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.add(new JLabel("Search by Name:"));
        searchField = new JTextField(15);
        JButton searchBtn = new JButton("Search");
        searchPanel.add(searchField);
        searchPanel.add(searchBtn);

        JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        filterPanel.add(new JLabel("Filter by Major:"));
        filterCombo = new JComboBox<>(new String[]{"All", "CS", "IT", "Math"});
        JButton filterBtn = new JButton("Filter");
        JButton sortByNameBtn = new JButton("Sort by Name");
        JButton sortByGpaBtn = new JButton("Sort by GPA");
        filterPanel.add(filterCombo);
        filterPanel.add(filterBtn);
        filterPanel.add(sortByNameBtn);
        filterPanel.add(sortByGpaBtn);

        bottomPanel.add(searchPanel);
        bottomPanel.add(filterPanel);
        add(bottomPanel, BorderLayout.SOUTH);

        // Event Handlers
        addBtn.addActionListener(e -> addStudent());
        editBtn.addActionListener(e -> editStudent());
        deleteBtn.addActionListener(e -> deleteStudent());
        refreshBtn.addActionListener(e -> refreshTable());
        searchBtn.addActionListener(e -> searchStudent());
        filterBtn.addActionListener(e -> filterStudents());
        sortByNameBtn.addActionListener(e -> sortByName());
        sortByGpaBtn.addActionListener(e -> sortByGpa());
    }

    private void refreshTable() {
        List<Student> all = controller.getAllStudents();
        tableModel.setStudents(all);
    }

    private void addStudent() {
        AddEditDialog dialog = new AddEditDialog(this, "Add Student", null);
        dialog.setVisible(true);
        Student newStudent = dialog.getResultStudent();
        if (newStudent != null) {
            if (controller.addStudent(newStudent)) {
                JOptionPane.showMessageDialog(this, "Student added.");
                refreshTable();
            } else {
                JOptionPane.showMessageDialog(this, "Student ID already exists.");
            }
        }
    }

    private void editStudent() {
        int selectedRow = studentTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Select a student to edit.");
            return;
        }
        String id = (String) tableModel.getValueAt(selectedRow, 0);
        Student existing = controller.findStudentById(id);
        AddEditDialog dialog = new AddEditDialog(this, "Edit Student", existing);
        dialog.setVisible(true);
        Student updated = dialog.getResultStudent();
        if (updated != null) {
            controller.updateStudent(id, updated);
            JOptionPane.showMessageDialog(this, "Student updated.");
            refreshTable();
        }
    }

    private void deleteStudent() {
        int selectedRow = studentTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Select a student to delete.");
            return;
        }
        String id = (String) tableModel.getValueAt(selectedRow, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "Delete student " + id + "?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            controller.deleteStudent(id);
            refreshTable();
        }
    }

    private void searchStudent() {
        String keyword = searchField.getText().trim();
        if (keyword.isEmpty()) refreshTable();
        else {
            List<Student> result = controller.searchByName(keyword);
            tableModel.setStudents(result);
        }
    }

    private void filterStudents() {
        String major = (String) filterCombo.getSelectedItem();
        if (major.equals("All")) refreshTable();
        else {
            List<Student> filtered = controller.filterByMajor(major);
            tableModel.setStudents(filtered);
        }
    }

    private void sortByName() {
        List<Student> sorted = controller.sortByName();
        tableModel.setStudents(sorted);
    }

    private void sortByGpa() {
        List<Student> sorted = controller.sortByGpa();
        tableModel.setStudents(sorted);
    }
}
