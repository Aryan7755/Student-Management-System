import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Marks");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    StudentManagementSystem.addStudent(sc);
                    break;

                case 2:
                    StudentManagementSystem.displayStudents();
                    break;

                case 3:
                    handleSearch(sc);
                    break;

                case 4:
                    handleUpdate(sc);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ===========================
    // SEARCH HANDLER
    // ===========================
    public static void handleSearch(Scanner sc) {
        System.out.println("\n1. Search by ID");
        System.out.println("2. Search by Name");
        System.out.print("Enter choice: ");

        int ch = sc.nextInt();
        sc.nextLine(); // consume newline

        if (ch == 1) {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            Student s = StudentManagementSystem.searchById(id);

            if (s == null) {
                System.out.println("Student not found!");
            } else {
                System.out.println("Found: " + s);
            }

        } else if (ch == 2) {
            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            List<Student> list = StudentManagementSystem.searchByName(name);

            if (list.isEmpty()) {
                System.out.println("No students found!");
            } else {
                System.out.println("Matching Students:");
                for (Student s : list) {
                    System.out.println(s);
                }
            }

        } else {
            System.out.println("Invalid choice!");
        }
    }

    // ===========================
    // UPDATE HANDLER
    // ===========================
    public static void handleUpdate(Scanner sc) {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        System.out.print("Enter new marks: ");
        double marks = sc.nextDouble();

        StudentManagementSystem.updateMarksById(id, marks);

    }
}
