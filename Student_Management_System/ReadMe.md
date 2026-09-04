# 🎓 Student Management System

A console-based **Student Management System built using Java** to practice and demonstrate core **Object-Oriented Programming (OOP)** concepts.

This project allows users to add, view, search, update, and delete student records through a simple menu-driven console application.

The main purpose of this project is not just to create a working application, but to understand **how OOP concepts are applied in a real-world Java project**.

---

## 📌 Table of Contents

* [About the Project](#-about-the-project)
* [Problem Statement](#-problem-statement)
* [Project Objectives](#-project-objectives)
* [Features](#-features)
* [Technologies Used](#-technologies-used)
* [Project Structure](#-project-structure)
* [Understanding the Architecture](#-understanding-the-architecture)
* [Class 1 - Student](#-class-1---studentjava)
* [Class 2 - StudentManager](#-class-2---studentmanagerjava)
* [Class 3 - Main](#-class-3---mainjava)
* [OOP Concepts Used](#-oop-concepts-used)
* [Program Flow](#-program-flow)
* [How Student Data Is Stored](#-how-student-data-is-stored)
* [How to Run the Project](#-how-to-run-the-project)
* [Sample Execution](#-sample-execution)
* [Validation](#-validation)
* [Important Java Concepts](#-important-java-concepts)
* [Interview Questions](#-interview-questions)
* [Limitations](#-limitations)
* [Future Improvements](#-future-improvements)
* [Learning Outcomes](#-learning-outcomes)
* [Author](#-author)

---

# 📖 About the Project

The **Student Management System** is a Java console application designed to manage student information.

A student has information such as:

* Student ID
* Name
* Age
* Department
* Email
* Marks
* Grade

The application provides a menu through which the user can perform different operations.

### Main Menu

```text
====================================
       STUDENT MANAGEMENT SYSTEM
====================================

1. Add Student
2. Display All Students
3. Search Student
4. Update Student
5. Delete Student
6. Exit

Enter your choice:
```

The project follows an **Object-Oriented Programming approach**, where student data and behavior are represented using classes and objects.

---

# ❓ Problem Statement

Managing student information manually can become difficult when the number of students increases.

For example, maintaining separate variables:

```java
int id1;
String name1;
int age1;

int id2;
String name2;
int age2;
```

is not scalable.

Instead, we represent a student using a class:

```java
class Student {
    int id;
    String name;
    int age;
}
```

Now we can create multiple Student objects:

```java
Student student1 = new Student(...);
Student student2 = new Student(...);
Student student3 = new Student(...);
```

The application then stores these objects in an:

```java
ArrayList<Student>
```

This allows us to manage multiple students efficiently.

---

# 🎯 Project Objectives

The main objectives of this project are:

1. Understand Java classes and objects.
2. Practice constructors.
3. Understand the `this` keyword.
4. Implement encapsulation.
5. Use private fields.
6. Implement getters and setters.
7. Perform input validation.
8. Understand `ArrayList`.
9. Store multiple objects.
10. Perform CRUD operations.
11. Understand object-to-object interaction.
12. Practice separation of responsibilities.
13. Build a menu-driven Java application.
14. Develop a foundation for larger OOP projects.

---

# ✨ Features

The system provides the following features.

## 1. Add Student

Allows the user to add a new student.

Information required:

```text
Student ID
Name
Age
Department
Email
Marks
```

Example:

```text
Enter ID: 101
Enter Name: Lokesh
Enter Age: 21
Enter Department: CSE
Enter Email: lokesh@gmail.com
Enter Marks: 85

Student added successfully.
```

---

## 2. Display All Students

Displays all students currently stored in the system.

Example:

```text
===== ALL STUDENTS =====

--------------------------------
ID         : 101
Name       : Lokesh
Age        : 21
Department : CSE
Email      : lokesh@gmail.com
Marks      : 85.0
Grade      : B
--------------------------------
```

---

## 3. Search Student

The user can search for a student using the Student ID.

Example:

```text
Enter Student ID: 101
```

If found:

```text
Student found:

--------------------------------
ID         : 101
Name       : Lokesh
Age        : 21
Department : CSE
Email      : lokesh@gmail.com
Marks      : 85.0
Grade      : B
--------------------------------
```

If the student does not exist:

```text
Student not found.
```

---

## 4. Update Student

The user can update student information using the Student ID.

Example:

```text
Enter Student ID: 101

Enter New Name: Lokeshwar
Enter New Age: 22
Enter New Department: CSE
Enter New Email: lokeshwar@gmail.com
Enter New Marks: 95

Student updated successfully.
```

---

## 5. Delete Student

The user can delete a student using their ID.

Example:

```text
Enter Student ID to delete: 101

Student deleted successfully.
```

---

## 6. Calculate Grade

The application automatically calculates the student's grade based on marks.

|    Marks | Grade |
| -------: | :---: |
| 90 - 100 |   A   |
|  80 - 89 |   B   |
|  70 - 79 |   C   |
|  60 - 69 |   D   |
| Below 60 |   F   |

Example:

```text
Marks: 85
Grade: B
```

---

# 🛠️ Technologies Used

| Technology | Purpose                             |
| ---------- | ----------------------------------- |
| Java       | Main programming language           |
| OOP        | Application design                  |
| ArrayList  | Store multiple students             |
| Scanner    | Read user input                     |
| Git/GitHub | Version control and project hosting |

---

# 📁 Project Structure

```text
StudentManagementSystem/
│
├── Student.java
├── StudentManager.java
├── Main.java
└── README.md
```

---

# 🏗️ Understanding the Architecture

The project contains three main classes.

```text
                    Student Management System
                              |
             ┌────────────────┼────────────────┐
             |                |                |
             ↓                ↓                ↓
        Student.java    StudentManager.java   Main.java
             |                |                |
             ↓                ↓                ↓
        Student Data     Manage Students    User Input
        & Behavior       & Operations        & Menu
```

Each class has a specific responsibility.

---

# 👨‍🎓 Class 1 - Student.java

The `Student` class represents **one student**.

It contains the student's data and behavior.

## Student Properties

```java
private int id;
private String name;
private int age;
private String department;
private String email;
private double marks;
```

These fields represent the state of a Student object.

For example:

```text
Student
│
├── id = 101
├── name = Lokesh
├── age = 21
├── department = CSE
├── email = lokesh@gmail.com
└── marks = 85
```

---

# 🔐 Why Are Fields Private?

The fields are declared as:

```java
private
```

Example:

```java
private double marks;
```

This prevents other classes from directly modifying the value.

We don't want:

```java
student.marks = 500;
```

Instead, we use:

```java
student.setMarks(500);
```

The setter can validate the value before updating it.

This is called **Encapsulation**.

---

# 🏗️ Student Constructor

The constructor initializes a Student object.

```java
public Student(
        int id,
        String name,
        int age,
        String department,
        String email,
        double marks) {

    this.id = id;
    this.name = name;
    setAge(age);
    this.department = department;
    setEmail(email);
    setMarks(marks);
}
```

When we write:

```java
Student student = new Student(
    101,
    "Lokesh",
    21,
    "CSE",
    "lokesh@gmail.com",
    85
);
```

the constructor is automatically called.

The constructor initializes the object.

---

# 🔎 Understanding `this`

Consider:

```java
this.id = id;
```

There are two `id` values.

```text
this.id
   ↓
Student object's id

id
   ↓
Constructor parameter
```

Therefore:

```java
this.id = id;
```

means:

```text
Object's ID = parameter ID
```

The `this` keyword refers to the **current object**.

---

# 📤 Getters

Because our variables are private, we need methods to read their values.

Example:

```java
public int getId() {
    return id;
}
```

Similarly:

```java
public String getName() {
    return name;
}
```

and:

```java
public double getMarks() {
    return marks;
}
```

A getter provides controlled read access.

---

# 📥 Setters

Setters allow controlled modification.

Example:

```java
public void setMarks(double marks) {

    if (marks >= 0 && marks <= 100) {
        this.marks = marks;
    } else {
        System.out.println(
            "Marks must be between 0 and 100."
        );
    }
}
```

Instead of allowing:

```java
student.marks = 500;
```

we use:

```java
student.setMarks(500);
```

The value is rejected.

---

# 🧮 Grade Calculation

The Student class contains:

```java
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
```

This method represents **behavior** of a Student object.

The Student doesn't only contain data.

It also performs operations on that data.

Therefore:

```text
Student
│
├── Data
│   ├── id
│   ├── name
│   ├── age
│   ├── department
│   ├── email
│   └── marks
│
└── Behavior
    ├── calculateGrade()
    └── displayStudent()
```

---

# 👨‍💼 Class 2 - StudentManager.java

The `StudentManager` class is responsible for managing multiple students.

It contains:

```java
private ArrayList<Student> students;
```

This means:

> The StudentManager maintains a collection of Student objects.

Conceptually:

```text
StudentManager
      |
      ↓
ArrayList<Student>
      |
      ├── Student 101
      ├── Student 102
      ├── Student 103
      └── Student 104
```

---

# 📚 Why ArrayList?

We don't know beforehand how many students the user will add.

We could have:

```java
Student student1;
Student student2;
Student student3;
```

but this is not practical.

Instead:

```java
ArrayList<Student> students;
```

allows us to dynamically store Student objects.

---

# ➕ Add Student

The manager contains:

```java
public void addStudent(Student student)
```

The Student object is added using:

```java
students.add(student);
```

Before adding, we check whether the ID already exists.

```java
if (findStudentById(student.getId()) != null) {
    System.out.println("Student ID already exists.");
    return;
}
```

This prevents duplicate IDs.

---

# 🔍 Finding a Student

The manager has an internal method:

```java
private Student findStudentById(int id)
```

It loops through the list:

```java
for (Student student : students) {

    if (student.getId() == id) {
        return student;
    }
}
```

If a matching student is found, the Student object is returned.

Otherwise:

```java
return null;
```

---

# 🔎 Search Student

The public search method uses the helper method:

```java
public void searchStudent(int id)
```

Internally:

```java
Student student = findStudentById(id);
```

If found:

```java
student.displayStudent();
```

Otherwise:

```text
Student not found.
```

---

# ✏️ Update Student

The manager first finds the student:

```java
Student student = findStudentById(id);
```

Then updates the information using setters:

```java
student.setName(name);
student.setAge(age);
student.setDepartment(department);
student.setEmail(email);
student.setMarks(marks);
```

Notice that we don't directly modify the private fields.

This maintains encapsulation.

---

# 🗑️ Delete Student

The manager finds the student:

```java
Student student = findStudentById(id);
```

Then removes it:

```java
students.remove(student);
```

---

# 🖥️ Class 3 - Main.java

`Main` is the entry point of the application.

Java starts execution from:

```java
public static void main(String[] args)
```

---

# ⌨️ Scanner

We use:

```java
Scanner scanner = new Scanner(System.in);
```

This allows the application to receive input from the user.

For example:

```java
int choice = scanner.nextInt();
```

reads an integer.

And:

```java
String name = scanner.nextLine();
```

reads a complete line.

---

# 🔄 Menu Loop

The application continuously displays the menu using:

```java
while (running) {
    ...
}
```

The variable:

```java
boolean running = true;
```

means the application should continue running.

When the user selects Exit:

```java
running = false;
```

the loop stops.

---

# 🔀 Switch Statement

The user's choice is handled using:

```java
switch (choice)
```

For example:

```java
case 1:
    // Add student
    break;

case 2:
    // Display students
    break;

case 3:
    // Search student
    break;
```

This connects the menu to the corresponding operations.

---

# 🔄 Complete Program Flow

The overall flow is:

```text
                START
                  |
                  ↓
           Create Scanner
                  |
                  ↓
        Create StudentManager
                  |
                  ↓
             Show Menu
                  |
                  ↓
          Read User Choice
                  |
        ┌─────────┼──────────┐
        ↓         ↓          ↓
       Add     Search      Update
        |         |          |
        ↓         ↓          ↓
      Student   Find ID    Find ID
        |         |          |
        └─────────┼──────────┘
                  |
                  ↓
             Show Menu
                  |
                  ↓
                Exit?
               /     \
             No       Yes
             |         |
             ↓         ↓
          Continue    END
```

---

# 🧩 CRUD Operations

This project implements basic **CRUD** operations.

CRUD means:

```text
C → Create
R → Read
U → Update
D → Delete
```

Our application:

| CRUD   | Feature                |
| ------ | ---------------------- |
| Create | Add Student            |
| Read   | Display/Search Student |
| Update | Update Student         |
| Delete | Delete Student         |

CRUD is a fundamental concept used in many real-world applications.

---

# 🧠 OOP Concepts Used

This project primarily focuses on the following OOP concepts.

---

## 1. Class

A class is a blueprint for creating objects.

Example:

```java
public class Student
```

---

## 2. Object

An object is an instance of a class.

Example:

```java
Student student = new Student(...);
```

---

## 3. Encapsulation

Data is hidden using:

```java
private
```

and accessed through methods:

```java
getMarks()
setMarks()
```

---

## 4. Constructor

The constructor initializes objects.

```java
public Student(...) {
    ...
}
```

---

## 5. `this` Keyword

Used to refer to the current object.

```java
this.name = name;
```

---

## 6. Methods

Methods represent the behavior of an object.

Examples:

```java
calculateGrade()
displayStudent()
setMarks()
```

---

## 7. Access Modifiers

The project uses:

```text
private
public
```

### `private`

Used to protect internal data.

### `public`

Used for methods that other classes need to access.

---

## 8. Encapsulation + Validation

The setter:

```java
setMarks()
```

does two things:

```text
Receive value
     ↓
Validate value
     ↓
Accept / Reject
```

This keeps the object in a valid state.

---

## 9. Object Interaction

`StudentManager` works with `Student` objects.

```java
ArrayList<Student>
```

and:

```java
manager.addStudent(student);
```

This demonstrates interaction between objects.

---

# 🔗 Class Relationships

The relationship can be represented as:

```text
Main
 |
 | uses
 ↓
StudentManager
 |
 | manages
 ↓
Student
```

More specifically:

```text
Main
  |
  ↓
StudentManager
  |
  └── ArrayList<Student>
              |
              ├── Student
              ├── Student
              └── Student
```

---

# 💾 How Student Data Is Stored

Suppose we add:

```text
101
Lokesh
21
CSE
lokesh@gmail.com
85
```

The application creates:

```java
Student student = new Student(
    101,
    "Lokesh",
    21,
    "CSE",
    "lokesh@gmail.com",
    85
);
```

Then:

```java
manager.addStudent(student);
```

Internally:

```java
students.add(student);
```

The list now contains:

```text
students
   |
   └── Student Object
          |
          ├── id = 101
          ├── name = Lokesh
          ├── age = 21
          ├── department = CSE
          ├── email = lokesh@gmail.com
          └── marks = 85
```

---

# ▶️ How to Run the Project

## Prerequisites

Install:

* Java JDK
* VS Code / IntelliJ IDEA / Eclipse
* Terminal or Command Prompt

Check Java installation:

```bash
java -version
```

Check compiler:

```bash
javac -version
```

---

# 📂 Step 1 — Create Project Folder

Create:

```text
StudentManagementSystem
```

Inside it:

```text
StudentManagementSystem/
├── Student.java
├── StudentManager.java
└── Main.java
```

---

# 📝 Step 2 — Compile

Open the terminal inside the project directory.

Run:

```bash
javac *.java
```

If compilation succeeds, `.class` files will be created.

---

# ▶️ Step 3 — Run

Execute:

```bash
java Main
```

You should see:

```text
====================================
       STUDENT MANAGEMENT SYSTEM
====================================

1. Add Student
2. Display All Students
3. Search Student
4. Update Student
5. Delete Student
6. Exit

Enter your choice:
```

---

# 🧪 Sample Execution

## Add Student

```text
Enter your choice: 1

===== ADD STUDENT =====

Enter ID: 101
Enter Name: Lokesh
Enter Age: 21
Enter Department: CSE
Enter Email: lokesh@gmail.com
Enter Marks: 85

Student added successfully.
```

---

## Add Another Student

```text
Enter your choice: 1

Enter ID: 102
Enter Name: Arun
Enter Age: 20
Enter Department: IT
Enter Email: arun@gmail.com
Enter Marks: 92

Student added successfully.
```

---

## Display

```text
Enter your choice: 2

===== ALL STUDENTS =====

--------------------------------
ID         : 101
Name       : Lokesh
Age        : 21
Department : CSE
Email      : lokesh@gmail.com
Marks      : 85.0
Grade      : B
--------------------------------

--------------------------------
ID         : 102
Name       : Arun
Age        : 20
Department : IT
Email      : arun@gmail.com
Marks      : 92.0
Grade      : A
--------------------------------
```

---

# 🔐 Validation

The project includes basic validation.

## Age

```java
if (age > 0 && age <= 100)
```

Valid:

```text
21
35
60
```

Invalid:

```text
-10
0
150
```

---

## Marks

```java
if (marks >= 0 && marks <= 100)
```

Valid:

```text
85
92
67
```

Invalid:

```text
-10
101
500
```

---

## Email

Basic validation checks whether the email contains:

```text
@
```

For example:

```text
lokesh@gmail.com
```

is accepted.

Whereas:

```text
lokeshgmail.com
```

is rejected.

---

## Name

The name cannot be empty.

```java
if (name != null && !name.trim().isEmpty())
```

---

# ⚠️ Current Limitations

This is intentionally a **console-based beginner/intermediate OOP project**, so it has some limitations.

### 1. No Database

Data is stored only in memory.

When the program exits, the data is lost.

### 2. Basic Email Validation

The project only checks whether the email contains `@`.

### 3. No Authentication

Anyone can access the application.

### 4. Console Interface

There is no graphical or web interface.

### 5. No Permanent Storage

Students are not saved to a file or database.

---

# 🚀 Future Improvements

This project can be extended significantly.

## Version 2

Add:

* File handling
* Save students to a `.txt` or `.csv` file
* Load students when the program starts

---

## Version 3

Add database support:

```text
Java
  ↓
JDBC
  ↓
MySQL
  ↓
Student Database
```

Tables could include:

```text
students
--------------------------
id
name
age
department
email
marks
```

---

## Version 4

Build a web application:

```text
Frontend
HTML
CSS
JavaScript
        ↓
Backend
Java / Spring Boot
        ↓
Database
MySQL
```

---

## Version 5

Add authentication:

```text
Login
  ↓
Admin Dashboard
  ↓
Student Management
```

---

## Version 6

Add REST APIs:

```text
GET    /students
GET    /students/{id}
POST   /students
PUT    /students/{id}
DELETE /students/{id}
```

---

# 🎓 Learning Outcomes

After completing this project, you should understand:

### Java Fundamentals

* Variables
* Data types
* Conditions
* Loops
* Methods
* `switch`
* `Scanner`

### OOP

* Classes
* Objects
* Constructors
* `this`
* Encapsulation
* Getters
* Setters
* Access modifiers
* Object relationships

### Collections

* `ArrayList`
* Generics
* Enhanced `for` loop

### Application Design

* Separation of responsibilities
* CRUD operations
* Validation
* Menu-driven applications

---

# 💼 Interview Questions From This Project

## Beginner

### 1. What is a class?

A class is a blueprint used to create objects.

### 2. What is an object?

An object is an instance of a class.

### 3. What is a constructor?

A constructor initializes an object when it is created.

### 4. What is `this`?

`this` refers to the current object.

---

## OOP

### 5. What is encapsulation?

Encapsulation is bundling data and methods inside a class while restricting direct access to internal data.

### 6. Why are Student fields private?

To prevent direct modification and provide controlled access.

### 7. Why use getters and setters?

Getters provide read access, while setters provide controlled modification and validation.

### 8. Why don't we have `setId()`?

Because the design treats the ID as fixed after the Student object is created.

---

## Collections

### 9. Why use `ArrayList<Student>`?

Because the system needs to dynamically store multiple Student objects.

### 10. Why use generics?

`ArrayList<Student>` ensures that the list is designed to store Student objects and provides compile-time type safety.

---

## Design

### 11. Why create StudentManager?

To separate student-management logic from the Student class and user-interface logic.

### 12. Why is `findStudentById()` private?

It is an internal helper method used by `StudentManager`, so external classes don't need direct access to it.

### 13. Where is object interaction happening?

For example:

```java
manager.addStudent(student);
```

A `Student` object is passed to a `StudentManager` object.

---

# 🧠 Key Design Principle

The most important lesson from this project is:

> **Don't put everything inside one class.**

Bad design:

```text
Main.java
│
├── Student data
├── Add student
├── Search student
├── Delete student
├── Update student
├── Validation
├── Grade calculation
└── User interface
```

Better design:

```text
Student.java
│
└── Student data + student behavior


StudentManager.java
│
└── Student management operations


Main.java
│
└── User interaction + menu
```

This makes the application easier to understand, maintain, and extend.

---

# 📌 Project Summary

The Student Management System is a beginner-friendly Java project designed to demonstrate how OOP concepts can be used to solve a real-world problem.

The project uses:

```text
Classes
   ↓
Objects
   ↓
Encapsulation
   ↓
Constructors
   ↓
Getters / Setters
   ↓
Validation
   ↓
ArrayList
   ↓
Object Interaction
   ↓
CRUD Operations
 
```

---

 