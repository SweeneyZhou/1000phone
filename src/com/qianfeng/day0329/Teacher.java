package com.qianfeng.day0329;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Teacher {
    private String name;
    private Gender gender;
    private Date dateOfTeaching;
    private float salary;
    private Subject[] subjects;


    public Teacher(){ }
    public Teacher(String name, Gender gender, Date dateOfTeaching, float salary, Subject[] subjects) {
        this.name = name;
        this.gender = gender;
        this.dateOfTeaching = dateOfTeaching;
        this.salary = salary;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDateOfTeaching() {
        return dateOfTeaching;
    }

    public void setDateOfTeaching(Date dateOfTeaching) {
        this.dateOfTeaching = dateOfTeaching;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Subject[] getSubjects() {
        return subjects;
    }

    public void setSubjects(Subject[] subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        Calendar c1=Calendar.getInstance();
        c1.setTime(dateOfTeaching);
        int time=Calendar.getInstance().get(Calendar.YEAR)-c1.get(Calendar.YEAR);
        return
                "姓名:" + name + "\n" +
                "性别:" + gender.toString() + "\n" +
                "教龄:" + time+ "\n"+
                "薪资:" + salary + "\n"+
                "学科:" + Arrays.toString(subjects)+ "\n"
                ;
    }
}
