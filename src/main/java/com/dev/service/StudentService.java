package com.dev.service;

import com.dev.model.Student;

import java.util.ArrayList;

public class StudentService {

    private ArrayList<Student> students = new ArrayList<>();


    public boolean addStudent(Student student) {
        int id = student.getId();
        if (searchStudent(id) == null) {
            students.add(student);
            return true;
        } else {
            return false;
        }
    }

    public void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No Students Found.");
            return;
        }

        for (Student student : students) {
            System.out.println(student);
            System.out.println("=====================");
        }

    }

    public Student searchStudent(int id) {

        for (Student student : students) {

            if (student.getId() == id) {
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

    public boolean updateName(int id, String name) {

        Student student = searchStudent(id);

        if (student == null) {
            return false;



        }
        student.setName(name);
        return true;


    }

    public boolean updateAge(int id, int age) {

        Student student = searchStudent(id);

        if (student == null) {

            return false;

        }
        student.setAge(age);
        return true;

    }

    public boolean updateCourse(int id, String course) {

        Student student = searchStudent(id);

        if (student == null) {
            return false;
        }

            student.setCourse(course);
            return true;

    }

    public boolean updateMarks(int id, double marks) {
        Student student = searchStudent(id);

        if (student == null) {
            return false;
        }
        student.setMarks(marks);
        return true;

    }


}

