package com.cf.intro;

import java.util.HashSet;
import java.util.Set;

public class HashSetInternals {
    public static void main(String[] args) {
        Set<String> hs = new HashSet<>();
        hs.add("InheritanceExample");            // map.put("InheritanceExample",PRESENT)
        hs.add("B");            // map.put("B",PRESENT)
        hs.add("C");            // map.put("C",PRESENT)
        hs.add("D");            // map.put("D",PRESENT)
        hs.add("E");            // map.put("E",PRESENT)
        System.out.println(hs.size());
        hs.add("InheritanceExample");
        System.out.println(hs.size());

        Set<Employee> empSet = new HashSet<>();
        Employee e1 = new Employee(123);
        Employee e2 = new Employee(124);
        Employee e3 = new Employee(124);
        Employee[] employees = {e1, e2, e3};

        for (Employee employee : employees)
            if (empSet.add(employee)) {

            } else
                System.out.println("Duplicate : " + employee);

        System.out.println(empSet.size());
    }
}
