package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CustomComparator {

    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<Employee>();
        list.add(new Employee(40, 10000, "ABC", "London"));
        list.add(new Employee(30, 80000, "Rahul", "Bangalore"));
        list.add(new Employee(23, 20000, "Ranjan", "Mumbai"));
        list.add(new Employee(56, 90000, "Issa", "Pune"));

        Collections.sort(list, new EmpSortByAge());
        for (Employee e : list) {
            System.out.println(e.toString());
        }
        System.out.println("---------------------------------");

        Collections.sort(list, new EmpSortByName());
        for (Employee e : list) {
            System.out.println(e.toString());
        }
    }

}


class EmpSortByAge implements Comparator<Employee> {

    @Override
    public int compare(Employee emp1, Employee emp2) {

        return emp1.age - emp2.age;
    }

}

class EmpSortByName implements Comparator<Employee> {

    @Override
    public int compare(Employee emp1, Employee emp2) {
        return emp1.name.compareTo(emp2.name);
    }

}

class Employee {
    int age;
    int salary;
    String name;
    String address;

    Employee(int age, int salary, String name, String address) {
        this.age = age;
        this.salary = salary;
        this.name = name;
        this.address = address;
    }

    public String toString() {
        return this.age + " " + this.salary + " " + this.name + " " + this.address;
    }
}

