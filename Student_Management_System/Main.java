import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Student_Manager manager = new Student_Manager();

        boolean running = true;


        while (running) {

            System.out.println("\n====================================");
            System.out.println("       STUDENT MANAGEMENT SYSTEM");
            System.out.println("====================================");

            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice) {

                case 1:

                    System.out.println("\n===== ADD STUDENT =====");

                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();

                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = scanner.nextDouble();
                    scanner.nextLine();


                    Student student = new Student(
                        id,
                        name,
                        age,
                        department,
                        email,
                        marks
                    );


                    manager.addStudent(student);

                    break;


                case 2:

                    manager.displayAllStudents();

                    break;


                case 3:

                    System.out.print("Enter Student ID: ");

                    int searchId = scanner.nextInt();
                    scanner.nextLine();

                    manager.searchStudent(searchId);

                    break;


                case 4:

                    System.out.println("\n===== UPDATE STUDENT =====");

                    System.out.print("Enter Student ID: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter New Age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter New Department: ");
                    String newDepartment = scanner.nextLine();

                    System.out.print("Enter New Email: ");
                    String newEmail = scanner.nextLine();

                    System.out.print("Enter New Marks: ");
                    double newMarks = scanner.nextDouble();
                    scanner.nextLine();


                    manager.updateStudent(
                        updateId,
                        newName,
                        newAge,
                        newDepartment,
                        newEmail,
                        newMarks
                    );

                    break;


                case 5:

                    System.out.print("Enter Student ID to delete: ");

                    int deleteId = scanner.nextInt();
                    scanner.nextLine();

                    manager.deleteStudent(deleteId);

                    break;


                case 6:

                    running = false;

                    System.out.println(
                        "Thank you for using Student Management System!"
                    );

                    break;


                default:

                    System.out.println(
                        "Invalid choice. Please try again."
                    );
            }
        }

        scanner.close();
    }
}