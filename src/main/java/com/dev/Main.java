package com.dev;

import com.dev.model.Student;
import com.dev.service.StudentService;
import java.util.Scanner;



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main (String[] args) {


        StudentService studentService =new StudentService();


        Scanner sc =new Scanner(System.in);

        System.out.println("===== Student Management ====");

        System.out.println();

        System.out.println("1. Add Students");
        System.out.println("2. View Students");
        System.out.println("3. Search Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Exit");

        System.out.println();

        System.out.println("Enter choice :");

        menu:
        while(true) {
            int choice = sc.nextInt();
            switch (choice) {

                case 1:

                    System.out.println("Give Details");
                    System.out.print("ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Age: ");
                    int age = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Course: ");
                    String course = sc.nextLine();

                    System.out.print("Marks: ");
                    double marks = sc.nextDouble();

                    System.out.println();

                    Student student = new Student(id, name, age, course, marks);

                    if(studentService.addStudent(student)){
                        System.out.println(id + " ==== Student Added Successfully ===");
                    }else{
                        System.out.println("Student with ID: "+ student.getId() +" already exists.");
                    }


                    displayMenu();
                    break;

                case 2:

                    studentService.viewStudents();

                    displayMenu();
                    break;

                case 3:

                    System.out.print("Enter Id of student: ");
                    int searchId = sc.nextInt();

                    Student foundstudent = studentService.searchStudent(searchId);

                    if (foundstudent != null) {
                        System.out.println(foundstudent);
                    }else{
                        System.out.println("Student Not Found");
                    }

                    displayMenu();
                    break;

                case 4:

                    System.out.println("Enter Student Id: ");
                    int deleteId = sc.nextInt();

                    studentService.deleteStudent(deleteId);

                    displayMenu();
                    break;

                case 5:

                    break menu;

                default:
                    System.out.println("Invalid Choice");

            }
        }


        sc.close();

    }

    public static void displayMenu(){

        System.out.println("Enter choice: 1)Add Student 2)View Student 3)Search Student 4)Delete Student5)Exit");

    }

}
