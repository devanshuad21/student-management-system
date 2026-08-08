# Day 1

Today I learned:
- Why fields should be private.
- Why constructors exist.
- How `this` works.
- Why getters and setters are needed.
- Why reusing setters inside constructors avoids duplicate validation logic.

Question:
- How should we handle invalid data during object creation?


## Session 3 - Student Management System (Add & View Features)

### What I Built

- Created a `StudentService` class to manage all student-related operations.
- Stored all students inside an `ArrayList<Student>`.
- Implemented the `addStudent(Student student)` method.
- Implemented the `viewStudents()` method using an enhanced for loop.
- Built a console-based menu using `while(true)` and `switch`.
- Added functionality to create students through user input instead of hardcoding them.
- Successfully displayed all added students using `toString()`.

---

## Java Concepts I Learned

### 1. Separation of Responsibilities (Single Responsibility Principle)

Each class should have one primary responsibility.

- `Student` → Represents one student and stores its data.
- `StudentService` → Manages all student operations.
- `Main` → Handles user interaction and program flow.

This makes the code cleaner, easier to understand, and easier to extend.

---

### 2. Why StudentService Owns the ArrayList

Initially I thought StudentService should store a single `Student`.

Later I realized that StudentService manages multiple students, so it should own:

```java
private ArrayList<Student> students = new ArrayList<>();
```

This allows adding, viewing, updating, searching, and deleting students.

---

### 3. Why addStudent() Takes a Student Object

Instead of taking input directly, StudentService accepts a `Student` object.

```java
addStudent(Student student)
```

Reason:

- Main collects input from the user.
- StudentService should only perform business logic.
- This keeps the application loosely coupled.

---

### 4. Enhanced For Loop

Used an enhanced for loop to display every student.

```java
for (Student student : students) {
    System.out.println(student);
}
```

It is cleaner than using an indexed loop when I only need to read data.

---

### 5. Why Override toString()

Printing an object normally gives something like:

```
Student@6d06d69c
```

By overriding `toString()`, Java knows how to display a Student object in a readable format.

```java
@Override
public String toString() {
    ...
}
```

---

### 6. Business Rules vs Data Types

This was one of my biggest learnings.

Java validates the **data type**, not the **meaning** of the data.

Example:

```java
String course = "7.6";
```

This is completely valid because `"7.6"` is still a String.

If I want only valid course names like "IT" or "CSE", I must write my own validation logic.

---

### 7. Scanner Buffer Issue

When using:

```java
nextInt()
```

or

```java
nextDouble()
```

I need to call:

```java
nextLine();
```

before reading a String.

Otherwise the newline left in the buffer gets consumed immediately.

---

### 8. Why Delete Should Use ID

Instead of:

```java
deleteStudent(Student student)
```

a better design is:

```java
deleteStudent(int id)
```

Reason:

- The user knows the student's ID.
- ID is unique.
- StudentService can search the ArrayList using the ID and remove the correct object.

---

### 9. Code Review Improvements

Things I improved after code review:

- Removed unused imports.
- Learned that constructors can reuse setters to avoid duplicate validation logic.
- Improved naming by preferring descriptive variable names over single-letter variables.
- Learned to think about empty collections before displaying data.

---

## Software Engineering Lessons

Before writing code, I should ask:

- Which class owns this data?
- Which class is responsible for this operation?
- Am I duplicating logic?
- Can this code be reused later?
- Does this class have more than one responsibility?

These questions help me design software instead of only writing Java syntax.

---

## Git Commit

Commit #3

```
Implement console menu with add and view student features
```

---

## Questions for Next Session

- How should I search a student by ID?
- How should I delete a student safely?
- How can I prevent duplicate student IDs?
- How can I refactor Main.java to avoid repeated menu code?

# LEARNINGS.md

# Student Management System

---

# Session 4 - Search, Delete & Better Design

## Features Completed

- ✅ Add Student
- ✅ View Students
- ✅ Search Student
- ✅ Delete Student
- ✅ Refactored Menu using displayMenu()

---

# Java Concepts Learned

## 1. Linear Search

To search a student by ID, I traversed the ArrayList one student at a time.

Algorithm:

```
Loop through students

↓

Compare IDs

↓

If found → Return Student

↓

Otherwise continue

↓

Reached end → Return null
```

Implementation:

```java
public Student searchStudent(int id){

    for(Student student : students){

        if(student.getId() == id){

            return student;

        }

    }

    return null;

}
```

---

## 2. Why searchStudent() Returns Student Instead of Printing

Instead of printing inside StudentService,

```java
public Student searchStudent(int id)
```

returns the Student object.

Reason:

- Main decides how to display information.
- StudentService should only perform business logic.
- Makes the method reusable.

The same method can later be used by:

- Search
- Delete
- Update
- Duplicate ID Validation
- Spring Boot Controllers

---

## 3. Returning null

When a student is not found, returning

```java
null
```

is acceptable because:

- Not finding a student is a normal situation.
- It is not an exceptional condition.

Main checks:

```java
if(student != null){
    ...
}else{
    ...
}
```

---

## 4. Linear Search Becomes Reusable

One method now supports multiple features.

```
searchStudent()

↓

Search

↓

Delete

↓

Update

↓

Duplicate Validation
```

Instead of writing four search algorithms, I reuse one.

---

## 5. Deleting by ID

Instead of

```java
deleteStudent(Student student)
```

I implemented

```java
deleteStudent(int id)
```

Reason:

The user knows the student's ID, not the Student object.

StudentService searches for the matching object internally.

---

## 6. Why StudentService Owns Business Rules

Duplicate ID validation does NOT belong inside Student.

Reason:

A Student object only knows about itself.

It cannot know whether another student already has the same ID.

StudentService owns the ArrayList, so it is responsible for checking uniqueness.

---

## 7. Constructor Reusing Setters

Instead of

```java
this.id = id;
```

I changed the constructor to

```java
setId(id);
setName(name);
setAge(age);
setCourse(course);
setMarks(marks);
```

Benefits:

- Validation is written once.
- No duplicate code.
- Easier to maintain.

---

## 8. Refactoring

I extracted duplicate menu printing into

```java
displayMenu();
```

instead of repeating

```java
System.out.println(...)
```

many times.

This made Main.java cleaner.

---

## 9. Scope in Java

I learned why this gives an error:

```java
Student student = ...
```

inside multiple switch cases.

Variables declared inside switch cases share the same scope unless braces are used.

Solutions:

- Use different variable names
- Create a new scope using braces

---

## 10. Reading if Conditions in English

A useful debugging technique.

Example:

```java
if(searchStudent(id) == null)
```

Read it as:

"If no student with this ID exists, add the student."

My earlier bug became obvious because I accidentally wrote:

```java
if(searchStudent(id) != null)
```

which reads as

"If the student already exists, add another one."

Reading conditions in plain English helps catch logical errors.

---

## 11. Data Type vs Business Meaning

Java only validates the data type.

Example:

```java
String course = "7.6";
```

This is completely valid because it is still a String.

If I want only valid courses like

- IT
- CSE
- ECE

I must write my own validation.

---

## 12. Why Scanner Crashes

Entering

```
abc
```

for

```java
nextInt()
```

throws

```
InputMismatchException
```

This is because Scanner expects an integer.

This will be solved later using Exception Handling.

---

## 13. Better API Design

Instead of

```java
public void addStudent(...)
```

I should design

```java
public boolean addStudent(Student student)
```

Reason:

StudentService should return whether the operation succeeded.

Main decides what message to show.

Example:

```java
if(studentService.addStudent(student)){
    System.out.println("Student Added Successfully");
}else{
    System.out.println("Duplicate ID");
}
```

This creates better separation between UI and business logic.

---

# Software Engineering Lessons

## Every class has one responsibility.

Student

- Stores data.

StudentService

- Manages students.

Main

- Interacts with the user.

---

## Business Logic vs User Interface

Main

- Scanner
- Menu
- Printing
- User Input

StudentService

- Searching
- Adding
- Deleting
- Updating
- Validation

Keeping them separate makes the application easier to maintain.

---

## Validate Only What Your Class Knows

Student validates:

- Name
- Age
- Marks
- Course

StudentService validates:

- Duplicate IDs
- Search
- Delete
- Update

---

## Debugging Habit

Instead of immediately changing code,

follow this order:

1. Read the error carefully.
2. Read the if-condition in English.
3. Check the values flowing through the program.
4. Question the design only if necessary.

---

## Refactoring Habit

If I copy the same code more than once,

I should ask:

"Can this become a method?"

Example:

```java
displayMenu();
```

---

# Current Project Progress

## Completed

- Project Setup
- GitHub Integration
- Student Model
- Constructor
- Getters
- Setters
- Validation
- toString()
- StudentService
- ArrayList
- Add Student
- View Students
- Search Student
- Delete Student
- Menu System
- Refactoring (displayMenu)

---

## Remaining Features

- Duplicate ID Validation
- Update Student
- Exception Handling
- Better Input Validation
- Sorting
- Statistics
- Save to File
- Load from File

---

# Git History

Commit #1

```
Initial project setup
```

Commit #2

```
Create Student model with constructor, getters and setters
```

Commit #3

```
Implement console menu with add and view student features
```

Commit #4 (Current)

```
Implement search and delete student features with menu refactoring
```

---

# Biggest Personal Learning

At the beginning, I was mostly learning Java syntax.

Now I think about:

- Which class should own this responsibility?
- Can this method be reused?
- Should this method return something?
- Is this business logic or UI logic?
- Am I duplicating code?
- How should software behave when the user makes a mistake?

These questions help me design software instead of only writing Java code.