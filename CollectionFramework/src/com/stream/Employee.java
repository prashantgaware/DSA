package com.stream;

public class Employee {
    private Integer id;
    private String name;
    private Double salary;
    private String department;
    private Integer age;
    private String city;

    public Employee(Integer id, String name, Double salary, String department, Integer age, String city) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.age = age;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public Integer getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }
}
