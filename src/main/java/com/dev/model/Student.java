package com.dev.model;

public class Student {

    private int id;
    private String name;
    private int age;
    private String course;
    private double marks;

    public  Student (int id, String name, int age, String course, double marks){

        this.id=id;
        this.name=name;
        this.age=age;
        this.course=course;
        this.marks=marks;

    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getCourse(){
        return course;
    }
    public double getMarks(){
        return marks;
    }
    //setterss

    public void setId(int id){
        if (id>100)
            this.id=id;
    }
    public void setName (String name){
        if (name!=null){
            this.name=name;
        }
    }
    public void setAge(int age) {
        if(age <= 0){
            throw new IllegalArgumentException("Age must be positive");
        }
        this.age = age;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    public void setMarks(double marks){
        if(marks>=0 && marks<=100)
            this.marks=marks;
    }
}





