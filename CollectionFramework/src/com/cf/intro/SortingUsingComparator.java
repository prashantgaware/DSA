package com.cf.intro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee1 implements Comparator {
    private int id;
    private String name;
    private double salary;

    public Employee1() {
    }

    public Employee1(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}

public class SortingUsingComparator {

    public static void main(String[] args) {
        Employee1 e1 = new Employee1(1, "Abc", 10000);
        Employee1 e4 = new Employee1(1, "Abc", 13000);
        Employee1 e5 = new Employee1(1, "Abc", 17000);
        Employee1 e2 = new Employee1(1, "Abc", 11000);
        Employee1 e3 = new Employee1(1, "Abc", 19000);

        List<Employee1> empList = new ArrayList<>();
        empList.add(e1);
        empList.add(e4);
        empList.add(e5);
        empList.add(e2);
        empList.add(e3);

//        Collections.sort(empList);
        Collections.sort(empList, new Comparator<Employee1>() {
            @Override
            public int compare(Employee1 x, Employee1 y) {
                return Double.compare(x.getSalary(), y.getSalary());
            }
        });
    }
}
