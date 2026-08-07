package com.dev.service;

import com.dev.model.Student;

import java.util.ArrayList;

public class StudentService {

    private ArrayList<Student> students = new ArrayList<>();


    public void addStudent(Student student) {
            students.add(student);
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
}
