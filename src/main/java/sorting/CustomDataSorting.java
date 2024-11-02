package sorting;

import java.util.ArrayList;
import java.util.Collections;

public class CustomDataSorting {
    public static void main(String[] args) {

        ArrayList<StudentData> list = new ArrayList<StudentData>();

        // Inserting data
        list.add(new StudentData("Ram", 98));
        list.add(new StudentData("Shyam", 84));
        list.add(new StudentData("Lokesh", 90));

        Collections.sort(list);

        // Displaying data
        for (StudentData sd : list) {
            System.out.println(sd.name + " " + sd.marks);
        }
    }

}

class StudentData implements Comparable<StudentData> {
    String name;
    int marks;

    // Constructor
    StudentData(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    // overriding method to sort
    // the student data
    public int compareTo(StudentData sd) {
        return this.marks - sd.marks;
    }
}


