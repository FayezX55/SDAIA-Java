package com.example;
import java.util.ArrayList;

class Student {
    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}

class StudentManager {
    private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student getStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public ArrayList<Student> getAllStudents() {
        return students;
    }

    public boolean removeStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                return true;
            }
        }
        return false;
    }
}

public class HW {
    public static void main(String[] args) {
        Student student1 = new Student("John", 1);
        Student student2 = new Student("Alice", 2);
        Student student3 = new Student("Bob", 3);

        StudentManager manager = new StudentManager();

        manager.addStudent(student1);
        manager.addStudent(student2);
        manager.addStudent(student3);

        int idToFind = 2;
        Student foundStudent = manager.getStudentById(idToFind);
        if (foundStudent != null) {
            System.out.println("Student found with ID " + idToFind + ": " + foundStudent.getName());
        } else {
            System.out.println("Student with ID " + idToFind + " not found.");
        }

        System.out.println("All students:");
        for (Student student : manager.getAllStudents()) {
            System.out.println("ID: " + student.getId() + ", Name: " + student.getName());
        }

        int idToRemove = 1;
        boolean removed = manager.removeStudentById(idToRemove);
        if (removed) {
            System.out.println("Student with ID " + idToRemove + " removed successfully.");
        } else {
            System.out.println("Student with ID " + idToRemove + " not found for removal.");
        }

        System.out.println("All students after removal:");
        for (Student student : manager.getAllStudents()) {
            System.out.println("ID: " + student.getId() + ", Name: " + student.getName());
        }
    }
}
