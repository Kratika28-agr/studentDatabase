package com.tw.prograd.studentDatabase;

import java.util.ArrayList;
import java.util.Scanner;

public class Adminn {
    private static ArrayList<StudentRecord> students = new ArrayList<>();
    private final String userType;

    public Adminn(String userType) {
        this.userType = userType;
    }

    public void addStudentsData(StudentRecord s) {
        if (userType.equalsIgnoreCase("admin")) {
            students.add(s);
        } else {
            System.out.println("You are not allowed to do anything to database");
        }
    }

    public void updateStudentsData(int id, StudentRecord newData) {
        if (userType.equalsIgnoreCase("admin")) {
            for(StudentRecord iterator: students){
                if(iterator.getRollNo()==id){
                    iterator.setName(newData.getName());
                    iterator.setGrade(newData.getGrade());
                    break;
                }
            }
        } else {
            System.out.println("You are not allowed to do anything to database");
        }
    }
    public void removeStudentsData(int id) {
        if (userType.equalsIgnoreCase("admin")) {
            for(StudentRecord iterator: students){
                if(iterator.getRollNo()==id){
                    students.remove(iterator);
                    break;
                }
            }

        } else {
            System.out.println("You are not allowed to do anything to database");
        }
    }

    public void showStudentDetails() {
        for (StudentRecord iterator : students) {
            System.out.println(iterator.getRollNo()+" "+iterator.getName()+" "+iterator.getGrade());
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Adminn admin = new Adminn("admin");
        Adminn nonTeachingUser = new Adminn("non-teaching");
        String name,grade;
        for(int i=0;i<3;i++){
            name=scan.nextLine();
            grade=scan.nextLine();
            StudentRecord o=new StudentRecord(name,grade);
            admin.addStudentsData(o);
            nonTeachingUser.addStudentsData(o);
        }
        admin.showStudentDetails();
        System.out.println("Enter id  whose record you want to delete");
        int id= scan.nextInt();
        admin.removeStudentsData(id);
        admin.showStudentDetails();
        System.out.println("Enter id  whose record you want to update");
        id=scan.nextInt();
        scan.nextLine();
        System.out.println("Enter new data");
        name= scan.nextLine();
        grade= scan.nextLine();

        StudentRecord newData= new StudentRecord(name,grade);
        admin.updateStudentsData(id,newData);
        nonTeachingUser.showStudentDetails();
    }
}
