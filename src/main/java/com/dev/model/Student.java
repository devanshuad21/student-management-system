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
        if(id > 0)
            this.id=id;
    }
    public void setName (String name){
        if(name != null && !name.trim().isEmpty()){
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
        if(course != null && !course.trim().isEmpty())
            this.course = course;
    }
    public void setMarks(double marks){
        if(marks>=0 && marks<=100)
            this.marks=marks;
    }
}





