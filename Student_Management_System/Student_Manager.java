import java.util.ArrayList;

public class Student_Manager {

    private ArrayList<Student> students;


    // Constructor
    public Student_Manager() {
        students = new ArrayList<>();
    }


    // Add student
    public void addStudent(Student student) {

        if (student == null) {

            System.out.println("Student cannot be null.");
            return;
        }

        if (findStudentById(student.getId()) != null) {
            System.out.println("Student ID already exists.");
            return;
        }

        students.add(student);

        System.out.println("Student added successfully.");
    }


    // Display all students
    public void displayAllStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n===== ALL STUDENTS =====");

        for (Student student : students) {
            student.displayStudent();
        }
    }


    // Search student
    public void searchStudent(int id) {

        Student student = findStudentById(id);

        if (student != null) {

            System.out.println("\nStudent found:");
            student.displayStudent();

        } else {

            System.out.println("Student not found.");
        }
    }


    // Find student by ID
    private Student findStudentById(int id) {

        for (Student student : students) {

            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }


    // Update student
    public void updateStudent(int id,
                              String name,
                              int age,
                              String department,
                              String email,
                              double marks) {

        Student student = findStudentById(id);

        if (student == null) {

            System.out.println("Student not found.");
            return;
        }

        student.setName(name);
        student.setAge(age);
        student.setDepartment(department);
        student.setEmail(email);
        student.setMarks(marks);

        System.out.println("Student updated successfully.");
    }


    // Delete student
    public void deleteStudent(int id) {

        Student student = findStudentById(id);

        if (student == null) {

            System.out.println("Student not found.");
            return;
        }

        students.remove(student);

        System.out.println("Student deleted successfully.");
    }
}