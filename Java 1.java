import java.util.*;

class Student {
    int id;
    String name;
    String course;

    Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public String toString() {
        return id + " - " + name + " (" + course + ")";
    }
}

public class StudentManagement {
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addStudent(sc);
                case 2 -> viewStudents();
                case 3 -> searchStudent(sc);
                case 4 -> deleteStudent(sc);
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    static void addStudent(Scanner sc) {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Course: ");
        String course = sc.nextLine();
        students.add(new Student(id, name, course));
        System.out.println("✅ Student added!");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            System.out.println("\n--- Student List ---");
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    static void searchStudent(Scanner sc) {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();
        for (Student s : students) {
            if (s.id == id) {
                System.out.println("Found: " + s);
                return;
            }
        }
        System.out.println("❌ Student not found!");
    }

    static void deleteStudent(Scanner sc) {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();
        students.removeIf(s -> s.id == id);
        System.out.println("✅ Student deleted (if existed).");
    }
}
