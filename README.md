# Student Management System (SMS)

## Overview
The Student Management System is a Java-based desktop application developed using Object-Oriented Programming principles and Java Swing GUI.

The project allows users to manage student records efficiently through CRUD operations, searching, filtering, and sorting features.

---

# Features

- Add Student
- Edit Student
- Delete Student
- Search by Name
- Filter by Major
- Sort by GPA
- Sort by Name
- Java Swing GUI
- Object-Oriented Design

---

# OOP Concepts Used

## Inheritance
- Person → Student
- Student → UndergradStudent / GraduateStudent

## Polymorphism
- Method overriding using getRole() and getStudentType()

## Abstract Class
- Person class

## Interface
- IStudentOperations interface

## Encapsulation
- Private fields with getters and setters

---

# Collections Used

- ArrayList
- HashMap

---

# Technologies

- Java 8+
- Java Swing
- Collections Framework
- MVC Architecture

---

# Project Structure

```text
src/
 ├── model/
 ├── service/
 ├── controller/
 ├── ui/
 ├── util/
 └── Main.java
