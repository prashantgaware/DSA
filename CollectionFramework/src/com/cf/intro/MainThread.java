package com.cf.intro;

import java.util.ArrayList;
import java.util.List;

public class MainThread {

    public static void main(String[] args) {

        List<Integer> l = new ArrayList<>();
        Thread1 t1 = new Thread1(l, "T1");
        Thread2 t2 = new Thread2(l, "T2");

        t1.start();
        t2.start();

        System.out.println(l);
    }

}
