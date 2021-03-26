package com.qianfeng.day0326;

import java.util.Arrays;

public class Class<Student, Teacher> {
    int id;
    String name;
    Student[] students;
    Teacher[] Teacher;
    String classroom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Teacher[] getTeacher() {
        return Teacher;
    }

    public void setTeacher(Teacher[] teacher) {
        Teacher = teacher;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + Arrays.toString(students) +
                ", Teacher=" + Arrays.toString(Teacher) +
                ", classroom='" + classroom + '\'' +
                '}';
    }
}
