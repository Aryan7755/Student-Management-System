import java.util.*;

public class StudentManagementSystem {
    static ArrayList<Student> students = new ArrayList<>();

    public static void addStudent(Scanner sc) {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        if (searchById(id) != null) {
            System.out.println("Student with this ID already exists!");
            return;
        }
        sc.nextLine(); // consume newline

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        Student s = new Student(id, name, marks);
        students.add(s);

        System.out.println("Student added successfully!");
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

    public static List<Student> searchByName(String name) {
        List<Student> result = new ArrayList<>();

        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                result.add(s);
            }
        }
        return result;
    }

    public static void updateMarksById(int id , double marks) {
        if (marks < 0 || marks > 100) {
            System.out.println("Invalid marks! Must be between 0 and 100.");
            return;
        }
        if (id <= 0) {
            System.out.println("Invalid Id! Must be greater than 0.");
            return;
        }
        Student s = searchById(id);
        if (s == null) {
            System.out.println("Student not found!");
            return;
        }
        s.setMarks(marks);
        System.out.println("Marks updated successfully!");
    }

    public static void sortByMarksDesc() {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s2.getMarks(), s1.getMarks()); // descending
            }
        });

        System.out.println("Students sorted by marks (highest first)");
    }

    public static void displayToppers(int n) {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        // ensure sorted before showing toppers
        sortByMarksDesc();

        System.out.println("\nTop " + n + " Students:");

        for (int i = 0; i < Math.min(n, students.size()); i++) {
            System.out.println((i + 1) + ". " + students.get(i));
        }
    }



}

