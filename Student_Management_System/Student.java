public class Student {

    // Student properties
    private int id;
    private String name;
    private int age;
    private String department;
    private String email;
    private double marks;


    // Constructor
    public Student(int id, String name, int age,
                   String department, String email,
                   double marks) {

        this.id = id;
        this.name = name;
        setAge(age);
        this.department = department;
        setEmail(email);
        setMarks(marks);
    }


    // Getter for ID
    public int getId() {
        return id;
    }


    // Getter for name
    public String getName() {
        return name;
    }


    // Setter for name
    public void setName(String name) {

        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid name.");
        }
    }


    // Getter for age
    public int getAge() {
        return age;
    }


    // Setter for age
    public void setAge(int age) {

        if (age > 0 && age <= 100) {
            this.age = age;
        } else {
            System.out.println("Invalid age.");
        }
    }


    // Getter for department
    public String getDepartment() {
        return department;
    }


    // Setter for department
    public void setDepartment(String department) {

        if (department != null &&
            !department.trim().isEmpty()) {

            this.department = department;

        } else {

            System.out.println("Invalid department.");
        }
    }


    // Getter for email
    public String getEmail() {
        return email;
    }


    // Setter for email
    public void setEmail(String email) {

        if (email != null && email.contains("@")) {
            this.email = email;
        } else {
            System.out.println("Invalid email.");
        }
    }


    // Getter for marks
    public double getMarks() {
        return marks;
    }


    // Setter for marks
    public void setMarks(double marks) {

        if (marks >= 0 && marks <= 100) {
            this.marks = marks;
        } else {
            System.out.println("Marks must be between 0 and 100.");
        }
    }


    // Calculate grade
    public char calculateGrade() {

        if (marks >= 90) {
            return 'A';
        } else if (marks >= 80) {
            return 'B';
        } else if (marks >= 70) {
            return 'C';
        } else if (marks >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }


    // Display student
    public void displayStudent() {

        System.out.println("--------------------------------");
        System.out.println("ID         : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Department : " + department);
        System.out.println("Email      : " + email);
        System.out.println("Marks      : " + marks);
        System.out.println("Grade      : " + calculateGrade());
        System.out.println("--------------------------------");
    }
}