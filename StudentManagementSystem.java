import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    static ArrayList<Student> students = new ArrayList<>();

    public static void addStudent(Scanner sc) {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        sc.nextLine(); // consume newline

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        Student s = new Student(id, name, marks);
        students.add(s);

        System.out.println("✅ Student added successfully!");
    }

    public static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\nStudent List:");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public static Student searchById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null; // not found
    }
}

