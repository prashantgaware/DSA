package com.cf.intro;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentModificationExceptionAvoidUsingCopyOnWriteArrayList {
    public static void main(String[] args) {
        List<Integer> l = new CopyOnWriteArrayList<>();
        l.add(10);
        l.add(20);
        l.add(30);
        l.add(40);
        l.add(50);

        /*
         * CopyOnWriteArrayList is used for arraylist.
         * For Hashet and hapshmap, there are ConcurrentHashmap and CopyOnHashSet class are present.
         */

        /**
         * no concurrentModificationExcep bdos we are using CopyOnWriteArrayList.
         * Uses Iterator Design Pattern
         * Use of Concurrency.
         */
        Iterator<Integer> itr = l.iterator();
        while (itr.hasNext()) {
            Integer val = itr.next();
            if (val == 30) {
                l.remove(val);
            }
        }

        System.out.println(l);
    }
}
