package com.tw.prograd.studentDatabase;

public class StudentRecord {
    private int rollNo ;
    private String name;
    private String grade;

    StudentRecord(String name,String grade){

        this.name=name;
        this.grade=grade;
        this.rollNo =rollNo;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
