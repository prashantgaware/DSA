package com.cf.intro;

public class Employee {

    private int id;

    public Employee() { }

    public Employee(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                '}';
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        Employee e  = (Employee) obj;
        if (id == e.id)
            return true;
        else
            return false;
    }
}
