package com.cf.intro;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CollectionIterator {
    public static void main(String[] args) {
        Employee e1 = new Employee(123);
        Employee e2 = e1;
        e1.setId(111);
        System.out.println(e1.getId());
        System.out.println(e2.getId());

        List<Integer> l = new ArrayList<>();
        l.add(10);
        l.add(20);
        l.add(30);
        l.add(40);
        l.add(50);

        Iterator<Integer> itr = l.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }

        ListIterator<Integer> listIterator = l.listIterator();
        int i = 0;
        while (listIterator.hasNext()) {
            i++;
            Integer val = listIterator.next();
            if (i == 2) {
                if (listIterator.hasPrevious()) {
                    Integer prevVal = listIterator.previous();
                    System.out.println(prevVal);
                }
            }
            System.out.println(val);
        }
    }
}
