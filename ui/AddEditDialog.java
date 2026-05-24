package com.student.management.ui;

import com.student.management.model.Student;
import com.student.management.util.ValidationUtils;
import javax.swing.*;
import java.awt.*;

public class AddEditDialog extends JDialog {
    private JTextField idField, nameField, emailField, majorField, gpaField, yearField;
    private JButton saveButton;
    private Student resultStudent;
    private boolean isEdit;

    public AddEditDialog(Frame owner, String title, Student existing) {
        super(owner, title, true);
        isEdit = (existing != null);
        initializeComponents();
        if (isEdit) {
            idField.setText(existing.getId());
            idField.setEditable(false);
            nameField.setText(existing.getName());
            emailField.setText(existing.getEmail());
            majorField.setText(existing.getMajor());
            gpaField.setText(String.valueOf(existing.getGpa()));
            yearField.setText(String.valueOf(existing.getYear()));
        }
        setSize(400, 350);
        setLocationRelativeTo(owner);
    }

    private void initializeComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Row 0
        gbc.gridx=0; gbc.gridy=0; add(new JLabel("ID:"), gbc);
        idField = new JTextField(15);
        gbc.gridx=1; add(idField, gbc);
        // Row 1
        gbc.gridx=0; gbc.gridy=1; add(new JLabel("Name:"), gbc);
        nameField = new JTextField(15);
        gbc.gridx=1; add(nameField, gbc);
        // Row 2
        gbc.gridx=0; gbc.gridy=2; add(new JLabel("Email:"), gbc);
        emailField = new JTextField(15);
        gbc.gridx=1; add(emailField, gbc);
        // Row 3
        gbc.gridx=0; gbc.gridy=3; add(new JLabel("Major:"), gbc);
        majorField = new JTextField(15);
        gbc.gridx=1; add(majorField, gbc);
        // Row 4
        gbc.gridx=0; gbc.gridy=4; add(new JLabel("GPA:"), gbc);
        gpaField = new JTextField(15);
        gbc.gridx=1; add(gpaField, gbc);
        // Row 5
        gbc.gridx=0; gbc.gridy=5; add(new JLabel("Year:"), gbc);
        yearField = new JTextField(15);
        gbc.gridx=1; add(yearField, gbc);

        saveButton = new JButton("Save");
        gbc.gridx=0; gbc.gridy=6; gbc.gridwidth=2;
        add(saveButton, gbc);

        saveButton.addActionListener(e -> saveStudent());
    }

    private void saveStudent() {
        String id = idField.getText().trim();
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String major = majorField.getText().trim();
        double gpa;
        int year;
        try {
            gpa = Double.parseDouble(gpaField.getText().trim());
            year = Integer.parseInt(yearField.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "GPA must be a number, Year must be integer.");
            return;
        }
        if (!ValidationUtils.isValidEmail(email)) {
            JOptionPane.showMessageDialog(this, "Invalid email format.");
            return;
        }
        resultStudent = new Student(id, name, email, major, gpa, year);
        setVisible(false);
    }

    public Student getResultStudent() {
        return resultStudent;
    }
}
