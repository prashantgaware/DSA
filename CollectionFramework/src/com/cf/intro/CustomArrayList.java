package com.cf.intro;

import java.util.Arrays;

public class CustomArrayList {

    Object[] a = null;
    int index = 0;

    public CustomArrayList(int size) {
        a = new Object[size];
    }

    public CustomArrayList() {
        a = new Object[10];
    }

    public void add(Object o) {

        if (index >= a.length) {
            int newSize = a.length + (a.length/2);
            a = Arrays.copyOf(a, newSize);
            /*Object[] newArr = new Object[newSize];
            for (int i=0; i<a.length; i++) {
                newArr[i] = a[i];
            }

            a = newArr;*/
        }

        a[index] = o;
        index++;
    }
}
