package com.cf.intro;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraylistExample {
    public static void main(String[] args) {

        ArrayList al = new ArrayList(4);

        al.add(new Employee());
        al.add(10);
        al.add(20);
        al.add(30);
        al.add(40);
        al.add(50);

        System.out.println(al);

        CustomArrayList cl = new CustomArrayList(5);
        cl.add(1);
        cl.add(2);
        cl.add(3);
        cl.add(4);
        cl.add(5);
        cl.add(3);
        cl.add(45);

    }
}
