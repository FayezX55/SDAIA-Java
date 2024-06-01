package day3;

public class Main {
    public static void main(String[] args) {
        School school = new School();

        Student student1 = new Student("Ahmed", 20, "789 Pine St", 1001, "Computer Science");
        Student student2 = new Student("Fayez", 22, "321 Elm St", 1002, "Mathematics");
        Student student3 = new Student("Badr", 21, "654 Maple St", 1003, "Physics");

        school.addStudent(student1);
        school.addStudent(student2);
        school.addStudent(student3);

        System.out.println("All Students:");
        school.displayAllStudents();

        school.sortStudentsByName();
        System.out.println("All Students (sorted by name):");
        school.displayAllStudents();

        Student foundStudent = school.findStudentById(1002);
        System.out.println("Found Student with ID 1002: " + foundStudent);

        school.writeStudentsToFile("students.txt");
        System.out.println("Students written to file.");

        School newSchool = new School();
        newSchool.readStudentsFromFile("students.txt");
        System.out.println("Students read from file:");
        newSchool.displayAllStudents();

    }
}