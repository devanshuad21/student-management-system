package com.dev;

import com.dev.model.Student;
import com.dev.service.StudentService;


import java.util.Scanner;
import java.util.InputMismatchException;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {



    public static void main (String[] args) {

        Scanner sc =new Scanner(System.in);

        StudentService studentService =new StudentService();




        System.out.println("===== Student Management ====");

        displayMenu();

        menu:
        while(true) {
            int choice = readInt(sc);
            switch (choice) {

                case 1:
                    int id=0;
                    Student student=null;
                    boolean check=false;
                    while(!check) {
                        try {

                            System.out.println("Give Details");
                            System.out.print("ID: ");
                            id = readInt(sc);

//                            boolean check= true;
//                      while(check) {
//                        try {
//                             id = sc.nextInt();
//                            System.out.println();
//                            check=false;
//                        } catch (InputMismatchException e) {
//
//                            System.out.println("Invalid Input type, Please enter valid ID");
//                            sc.nextLine();
//
//                        }
//                    }

                            sc.nextLine();

                            System.out.print("Name: ");
                            String name = sc.nextLine();

                            System.out.print("Age: ");
                            int age = readInt(sc);

                            sc.nextLine();

                            System.out.print("Course: ");
                            String course = sc.nextLine();

                            System.out.print("Marks: ");
                            double marks = readDouble(sc);

                            System.out.println();


                            student=  new Student(id, name, age, course, marks);
                            check=true;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }


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
                    int searchId = readInt(sc);

                    Student foundStudent = studentService.searchStudent(searchId);

                    if (foundStudent != null) {
                        System.out.println(foundStudent);
                    }else{
                        System.out.println("Student Not Found");
                    }

                    displayMenu();
                    break;

                case 4:

                    System.out.println("Enter Student Id: ");
                    int deleteId = readInt(sc);

                    studentService.deleteStudent(deleteId);

                    displayMenu();
                    break;

                case 5:
                    System.out.println("=== Update Student ====");
                    System.out.print("Enter Student ID :");

                    int updateId = readInt(sc);

                    updateMenu(updateId,studentService,sc);

                    displayMenu();
                    break;

                case 6:
                    break menu;

                default:
                    System.out.println("Invalid Choice");

            }
        }


        sc.close();

    }

    public static void displayMenu(){

        System.out.println();

        System.out.println("1. Add Students");
        System.out.println("2. View Students");
        System.out.println("3. Search Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Update Student");
        System.out.println("6. Exit");

        System.out.println();

        System.out.println("Enter choice :");

    }

    public static void updateMenu(int id, StudentService studentService, Scanner sc){




        System.out.println("1. Update Name");
        System.out.println("2. Update Age ");
        System.out.println("3. Update Course");
        System.out.println("4. Update Marks");
        System.out.println("5. Cancel");

        System.out.print("Enter choice:");
        int choice= readInt(sc);

        switch (choice){
            case 1:
                System.out.print("Enter New Name:");
                sc.nextLine();
                String newName = sc.nextLine();

                if (studentService.updateName(id, newName)) {
                    System.out.println("Student " + id + " Name Updated Successfully");
                } else {
                    System.out.println("Student " + id + " Not Found");
                }


                break;

            case 2:
                System.out.print("Enter New Age:");
                int newAge = readInt(sc);

                if (studentService.updateAge(id, newAge)) {
                    System.out.println("Student " + id + " Age Updated Successfully");
                } else {
                    System.out.println("Student " + id + " Not Found");
                }


                break;

            case 3:
                System.out.print("Enter New Course:");
                sc.nextLine();
                String newCourse =sc.nextLine();

                if (studentService.updateCourse(id, newCourse)) {
                    System.out.println("Student " + id + " Course Updated Successfully");
                } else {
                    System.out.println("Student " + id + " Not Found");
                }



                break;

            case 4:
                System.out.print("Enter New Marks:");
                double newMarks = readDouble(sc);

                if (studentService.updateMarks(id, newMarks)) {
                    System.out.println("Student " + id + " Marks Updated Successfully");
                } else {
                    System.out.println("Student " + id + " Not Found");
                }



                break;

            case 5:
                break;

            default:
                System.out.println("INVALID CHOICE");

        }

    }


    public static int readInt(Scanner sc){

        while(true){
            try {
                return sc.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Enter Valid Input Type");
                sc.nextLine();
            }
        }


    }

    public static double readDouble (Scanner sc){

        while(true){
            try {
                return sc.nextDouble();

            } catch (InputMismatchException e){
                System.out.println("Enter Valid Input Type");
                sc.nextLine();
            }
        }

    }



}
