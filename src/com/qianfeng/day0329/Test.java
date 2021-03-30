package com.qianfeng.day0329;

import java.util.Calendar;
import java.util.Scanner;

public class Test {
    static Scanner sc = new Scanner(System.in);

    static Subject[] subjects=new Subject[0];
    static Teacher[] teachers=new Teacher[0];

    public static void main(String[] args) {
        do {
            System.out.println("课程：");
            showSubject();
            System.out.println("教师：");
            printTeachers();
            System.out.println("请选择：");
            System.out.println("1、添加课程 2、添加教师 3、修改课程信息 4、修改教师信息 5、删除教师 6、删除课程 Q、退出");
            String s=sc.next();
            if ("Q".equals(s)||"q".equals(s))return;
            switch(s){
                case "1":
                    subjects=addSubject(subjects,inputSubjects());
                    break;
                case "2":
                    teachers=addTeacher(teachers,inputTeachers());
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;
                default:;
            }
        }while (true);
    }
    public static Teacher[] addTeacher(Teacher[] teachers,Teacher teacher){
        Teacher[] newTeachers=new Teacher[teachers.length+1];
        System.arraycopy(teachers, 0, newTeachers, 0, teachers.length);
        newTeachers[teachers.length]=teacher;
        return newTeachers;
    }
    public static Subject[] addSubject(Subject[] subjects,Subject subject){
        Subject[] newSubjects=new Subject[subjects.length+1];
        System.arraycopy(subjects, 0, newSubjects, 0, subjects.length);
        newSubjects[subjects.length]=subject;
        return newSubjects;
    }
    public static Teacher inputTeachers() {
        System.out.println("请输入添加的教师信息");
        System.out.println("请输入姓名");
        String name = sc.next();
        System.out.println("请输入性别");
        Gender gender = "男".equals(sc.next()) ? Gender.MALE : Gender.FEMALE;
        System.out.println("请输入薪资");
        float salary = sc.nextFloat();
        System.out.println("请输入教龄");
        int timeOfTeaching = sc.nextInt();
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, -timeOfTeaching);
        Subject[] addSubjects=new Subject[0];
        do{
            if(subjects.length!=0||addSubjects.length==subjects.length){
                System.out.println("请选择该教师执教的科目:");
                showSubject();
                int s = sc.nextInt();
                if (s>subjects.length||s<1)break;
                addSubjects=addSubject(addSubjects,subjects[s-1]);
            }else {
                break;
            }
        }while(true);
        return new Teacher(name, gender, c.getTime(), salary, subjects);
    }

    public static Subject inputSubjects() {
        System.out.println("请输入添加学科的信息");
        System.out.println("请输入学科名");
        String name = sc.next();
        System.out.println("请输入学时");
        int period = sc.nextInt();
        System.out.println("请输入积分");
        int point = sc.nextInt();
        return new Subject(name, period, point);
    }
    public static void showSubject(){
        int count=1;
        for (Subject subject : subjects) {
            System.out.println(count+++"、"+subject);
        }
    }

    public static void printTeachers() {
        for (int i = 0; i < teachers.length; i++) {
            System.out.println("第"+(i+1)+"位老师");
            System.out.println(teachers[i]);
        }
    }
}
