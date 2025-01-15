package jeet;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomSorting {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(10, 60, "xyz"));
        list.add(new Student(8, 50, "pqr"));
        list.add(new Student(15, 58, "asd"));
        list.add(new Student(2, 45, "tgr"));

        System.out.println(list.toString());

        Collections.sort(list);
        System.out.println(list.toString());

        //we are passing comparator : we need to pass two objects
        Collections.sort(list, (a,b)-> {return a.id-b.id;});
        System.out.println(list.toString());


    }
}


class Student implements Comparable<Student> {
    int id;
    int age;
    String name;

    public Student(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Student comingStudentData) {
        return this.name.compareTo(comingStudentData.name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}


//interface Comparable