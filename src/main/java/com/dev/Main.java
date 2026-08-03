package com.dev;

import com.dev.model.Student;

import static java.lang.IO.*;
import static java.lang.String.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main (String[] args) {
        Student s = new Student(101, "Dev", 22, "IT", 91.04);

        System.out.println(s.getName());
    }
}
