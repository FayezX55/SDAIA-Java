package day3;

import java.util.ArrayList;
import java.util.Comparator;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class School {
    private ArrayList<Student> students;

    public School() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudentById(int studentId) {
        students.removeIf(student -> student.getStudentId() == studentId);
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void sortStudentsByName() {
        students.sort(Comparator.comparing(Student::getName));
    }

    public Student findStudentById(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }

    public void writeStudentsToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Student student : students) {
                writer.write(student.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readStudentsFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                String name = parts[0].split(": ")[1];
                int age = Integer.parseInt(parts[1].split(": ")[1]);
                String address = parts[2].split(": ")[1];
                int studentId = Integer.parseInt(parts[3].split(": ")[1]);
                String course = parts[4].split(": ")[1];
                addStudent(new Student(name, age, address, studentId, course));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
