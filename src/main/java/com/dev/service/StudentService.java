package com.dev.service;

import com.dev.model.Student;

import java.util.ArrayList;

public class StudentService {

    private ArrayList<Student> students = new ArrayList<>();


    public boolean addStudent(Student student) {
        int id= student.getId();
        if(searchStudent(id)==null){
            students.add(student);
            return true;
        }
        else {
            return false;
        }
    }

    public void viewStudents() {

        if(students.isEmpty()){
            System.out.println("No Students Found.");
            return;
        }

        for (Student student :students){
            System.out.println(student);
        }

    }

    public Student searchStudent(int id){

        for (Student student :students){

            if (student.getId()==id){
                return student;
            }

        }

        return null;
    }

    public void deleteStudent(int id) {

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getId() == id) {

                students.remove(i);
                System.out.println("Student " + id + " Removed Successfully");
                return;

            }
        }
        System.out.println("Student " + id + " Not Found");

    }
}

