package com.stream;

import java.util.List;

public class StreamImpl {
    public static void main(String[] args) {
        StreamImpl streamImpl = new StreamImpl();
        List<Employee> employees = streamImpl.employeeList();

        // Print all employees
        List<String> empList = employees.stream()
                .map(Employee::getName)
                .toList();
        empList.forEach(System.out::println);
    }

    public List<Employee> employeeList() {
        return List.of(
                new Employee(1, "John", 50000.0, "IT", 30, "New York"),
                new Employee(2, "Jane", 60000.0, "HR", 25, "Chicago"),
                new Employee(3, "Mike", 55000.0, "IT", 35, "San Francisco"),
                new Employee(4, "Emily", 70000.0, "Finance", 28, "New York"),
                new Employee(5, "David", 45000.0, "IT", 32, "Chicago"),
                new Employee(6, "Sophia", 80000.0, "HR", 29, "San Francisco"),
                new Employee(7, "Daniel", 52000.0, "Finance", 31, "New York"),
                new Employee(8, "Olivia", 75000.0, "IT", 27, "Chicago"),
                new Employee(9, "James", 48000.0, "HR", 33, "San Francisco"),
                new Employee(10, "Ava", 62000.0, "Finance", 26, "New York")
        );
    }
}
