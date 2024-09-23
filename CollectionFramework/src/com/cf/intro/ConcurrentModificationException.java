package com.cf.intro;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModificationException {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(10);
        l.add(20);
        l.add(30);
        l.add(40);
        l.add(50);

        /**
         * Gives ConcurrentModificationException when we try to modify object while iterating collection framework
         */
        Iterator<Integer> itr = l.iterator();
        while (itr.hasNext()) {
            Integer val = itr.next();
//            if (val == 30) {        // Here we are modifying the object concurrently.
//                l.remove(val);
//            }
        }

        System.out.println(l);
    }
}
