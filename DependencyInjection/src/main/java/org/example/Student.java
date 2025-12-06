package org.example;

public class Student {
    Course course;
    //dependency injection -->
    public Student() {}
    public Student(Course course) {
        this.course = course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void study() {
        System.out.println("study course started--");
        int start=course.enroll();
        if(start>0){
            System.out.println(" course journey started--");
        }
        else{
            System.out.println(" payment failed--");
        }
    }
}
