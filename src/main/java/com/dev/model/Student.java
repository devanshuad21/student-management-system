package com.dev.model;



public class Student {

  @Override
    public String toString() {
      return "ID: " + id +
              "\nName: " + name +
              "\nAge: "+age+
              "\nCourse: "+course+
              "\nMarks: "+marks;

  }

    private int id;
    private String name;
    private int age;
    private String course;
    private double marks;

    public  Student (int id, String name, int age, String course, double marks){

        setId(id);
        setName(name);
        setAge(age);
        setCourse(course);
        setMarks(marks);

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
        if(id <= 0)
            throw new IllegalArgumentException("Id cannot be negative");

        this.id=id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        this.name = name.trim();
    }

    public void setAge(int age) {
        if(age<16 || age > 40){
            throw new IllegalArgumentException("Age must be between 16 to 100");
        }
        this.age = age;
    }

    public void setCourse(String course) {
        if(course == null || course.trim().isEmpty()){
            throw new IllegalArgumentException("Course cannot be empty.");
        }else{
            this.course = course.trim();
        }
    }
    public void setMarks(double marks){

        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100");
        }
        this.marks = marks;

    }
}





