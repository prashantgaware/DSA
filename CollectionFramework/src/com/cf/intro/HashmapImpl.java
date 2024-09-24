package com.cf.intro;

import java.util.HashMap;
import java.util.Map;

public class HashmapImpl {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("InheritanceExample", 55);
        map.put("InheritanceExample", 56);
        map.put("InheritanceExample", 57);
        map.put("InheritanceExample", 58);
        System.out.println(map.size());
        System.out.println(map);
        System.out.println();

        Employee e1 = new Employee(121);
        Employee e2 = new Employee(121);
        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());

        Map<Employee, String> empMap = new HashMap<>();
        empMap.put(e1, "Prashant");
        empMap.put(e2, "Saurav");
        System.out.println(empMap.size());
        System.out.println(empMap);
    }
}
